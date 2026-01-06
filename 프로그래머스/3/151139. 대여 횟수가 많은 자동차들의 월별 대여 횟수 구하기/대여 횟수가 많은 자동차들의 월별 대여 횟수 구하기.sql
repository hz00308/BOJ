select month(START_DATE) as `MONTH`, CAR_ID, count(*) as RECORDS
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
where CAR_ID in (
    select CAR_ID
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY
    where year(START_DATE) = 2022
        and month(START_DATE) in (08, 09, 10)
    group by CAR_ID
    having count(*) >= 5
) and year(START_DATE) = 2022 and month(START_DATE) in (08, 09, 10)
group by month(START_DATE), CAR_ID
having count(*) != 0
order by `MONTH`, CAR_ID desc;

