with unavailable_cars as (
    select car_id
    from car_rental_company_rental_history 
    where start_date <= '2022-11-30' and end_date >= '2022-11-01'
)
select 
    car_id, C.car_type, 
    floor(daily_fee * 30 * (100-ifnull(discount_rate, 0))/100) as fee
from car_rental_company_car C
left join car_rental_company_discount_plan DP
on C.car_type = DP.car_type and duration_type = '30일 이상'
where C.car_type in ('세단', 'SUV')
    and car_id not in (select * from unavailable_cars)
    and floor(daily_fee * 30 * (100-ifnull(discount_rate, 0))/100) between 500000 and 1999999
order by fee desc, C.car_type, car_id desc;