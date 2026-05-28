with size_cume_dist as (
    select 
        id,
        cume_dist() over(order by size_of_colony desc) as scd
    from ecoli_data
    order by id
)
select
    id, 
    case
        when scd <= 0.25 then 'CRITICAL'
        when scd <= 0.5 then 'HIGH'
        when scd <= 0.75 then 'MEDIUM'
        else 'LOW'
    end as colony_name
from size_cume_dist;
