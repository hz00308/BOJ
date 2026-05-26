select item_id, item_name, rarity
from item_info join item_tree using(item_id)
where parent_item_id in (
    select item_id from item_info where rarity = 'RARE'
)
order by item_id desc;