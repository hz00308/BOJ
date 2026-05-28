with max_price_per_category as  (
    select category, max(price) as max_price
    from food_product
    where category in ('과자', '국', '김치', '식용유')
    group by category
)
select category, max_price, product_name
from food_product join max_price_per_category using(category)
where price = max_price
order by max_price desc;