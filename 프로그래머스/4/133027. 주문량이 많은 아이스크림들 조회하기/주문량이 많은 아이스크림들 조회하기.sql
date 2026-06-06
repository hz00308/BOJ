with JULY_FLAVOR as (
    select flavor, sum(total_order) as total_order
    from july
    group by flavor
)
select FH.flavor
from first_half FH join july_flavor JF
on FH.flavor = JF.flavor
group by FH.flavor
order by FH.total_order + JF.total_order desc
limit 3;