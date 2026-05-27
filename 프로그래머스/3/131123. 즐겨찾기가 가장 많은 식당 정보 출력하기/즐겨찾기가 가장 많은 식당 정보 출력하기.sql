with max_fav as (
    select food_type, max(favorites) as mf
    from rest_info
    group by food_type
)
select food_type, rest_id, rest_name, favorites
from rest_info join max_fav using(food_type)
where favorites = mf
order by food_type desc;