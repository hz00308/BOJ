with parent_data as (
    select parent_id, count(*) as child_count
    from ecoli_data
    where parent_id is not null
    group by parent_id
)
select 
    id,
    ifnull(p.child_count, 0) as child_count
from ecoli_data e left join parent_data p
on e.id = p.parent_id
order by e.id;