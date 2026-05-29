select year(sales_date) as year, month(sales_date) as month, gender, count(distinct user_id) as users
from online_sale join user_info using(user_id)
where gender is not null
group by year(sales_date), month(sales_date), gender
order by year, month, gender;
-- 회원 수를 구하는 것이므로 count(*)가 아닌 count(distinct user_id)