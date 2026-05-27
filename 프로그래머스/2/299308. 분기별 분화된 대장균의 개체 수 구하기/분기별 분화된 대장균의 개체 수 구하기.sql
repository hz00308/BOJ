select 
    concat(quarter(differentiation_date), 'Q') as quarter,
    count(*) as ecoli_count
from ecoli_data
group by quarter(differentiation_date)
order by quarter;
