with FE as (
    select code
    from skillcodes
    where category = 'Front End'
),
developers_PY as (
    select *
    from developers
    where skill_code & (select code from skillcodes where name = 'Python') > 0
),
developers_A as (
    select distinct id
    from developers_PY, FE
    where skill_code & code > 0
),
developers_B as (
    select id
    from developers 
    where skill_code & (select code from skillcodes where name = 'C#') > 0
),
developers_C as (
    select distinct id
    from developers, FE
    where skill_code & code > 0
),
developers_grade as (
    select 
        case
            when id in(select id from developers_A) then 'A'
            when id in(select id from developers_B) then 'B'
            when id in(select id from developers_C) then 'C'
            else null
        end as grade,
        id, email
    from developers
)
select *
from developers_grade
where grade is not null
order by grade, id;
