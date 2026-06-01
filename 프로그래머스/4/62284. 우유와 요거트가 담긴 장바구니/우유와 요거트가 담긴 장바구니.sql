select distinct cart_id
from cart_products p1 join cart_products p2 using(cart_id)
where p1.name = 'Milk' and p2.name = 'Yogurt'
order by cart_id;