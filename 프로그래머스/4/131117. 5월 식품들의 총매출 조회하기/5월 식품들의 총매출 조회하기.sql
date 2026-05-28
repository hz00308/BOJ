select 
    product_id, product_name, 
    sum(price*amount) as total_sales
from food_product join food_order using(product_id)
where year(produce_date) = 2022 and month(produce_date) = 5
group by product_id, product_name
order by total_sales desc, product_id;