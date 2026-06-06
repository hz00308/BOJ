with frontend as (
    select code
    from skillcodes
    where category = "Front End"
)
select id, email, first_name, last_name
from developers, frontend
where skill_code & code > 0
group by id, email, first_name, last_name
order by id;