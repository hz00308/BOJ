with truckCTE as (
    select 
        history_id, car_type, daily_fee,
        datediff(end_date, start_date)+1 as rent_days,
        case
            when datediff(end_date, start_date)+1 >= 90 then '90일 이상'
            when datediff(end_date, start_date)+1 >= 30 then '30일 이상'
            when datediff(end_date, start_date)+1 >= 7 then '7일 이상'
            else null
        end as duration_type
    from car_rental_company_rental_history 
    join car_rental_company_car using(car_id)
    where car_type = '트럭'
)
select 
    history_id, 
    floor(daily_fee * rent_days * (100-ifnull(discount_rate, 0))/100) as fee
from truckCTE left join car_rental_company_discount_plan using(car_type, duration_type)
order by fee desc, history_id desc;
    
    