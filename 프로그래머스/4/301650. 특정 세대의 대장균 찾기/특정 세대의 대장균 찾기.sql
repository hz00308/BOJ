with first_gen as (
    select id
    from ecoli_data
    where parent_id is null
),
second_gen as (
    select ecoli_data.id
    from ecoli_data join first_gen
    on ecoli_data.parent_id = first_gen.id
)
select ecoli_data.id
from ecoli_data join second_gen
on ecoli_data.parent_id = second_gen.id
order by ecoli_data.id;