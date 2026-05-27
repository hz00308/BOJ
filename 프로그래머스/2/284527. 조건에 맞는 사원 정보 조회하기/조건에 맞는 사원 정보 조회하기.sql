with grade2022 as (
    select emp_no, sum(score) as score
    from hr_grade
    where year = 2022
    group by emp_no
)
select score, emp_no, emp_name, position, email
from hr_employees join grade2022 using(emp_no)
where score = (select max(score) from grade2022);
