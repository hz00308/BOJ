with recursive ecoli_cte as (
    select id, parent_id, 1 as generation
    from ecoli_data
    where parent_id is null
    union all
    select Child.id, Child.parent_id, Parent.generation+1
    from ecoli_data Child join ecoli_cte Parent 
    on Child.parent_id = Parent.id
)
select count(id) as count, generation
from ecoli_cte
where id not in (
    select distinct parent_id
    from ecoli_cte
    where parent_id is not null -- 필수 (null과의 비교는 unknown이기 때문)
)
group by generation
order by generation;