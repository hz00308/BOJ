select item_id, item_name, rarity
from item_info
where not exists (
    select 1
    from item_tree
    where parent_item_id = item_info.item_id
)
order by item_id desc;