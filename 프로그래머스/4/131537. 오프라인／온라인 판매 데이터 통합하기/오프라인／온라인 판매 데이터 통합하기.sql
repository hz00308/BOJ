select *
from (
    select sales_date, product_id, user_id, sales_amount
    from online_sale 
    where month(sales_date) = 3
    union
    select sales_date, product_id, null as user_id, sales_amount
    from offline_sale
    where month(sales_date) = 3
) SALE
order by sales_date, product_id, user_id;
