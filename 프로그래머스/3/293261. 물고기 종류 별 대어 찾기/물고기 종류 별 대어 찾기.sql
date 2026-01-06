select ID, FISH_NAME, LENGTH
from (select FISH_TYPE, max(LENGTH) as ML from FISH_INFO group by FISH_TYPE) as f
    join FISH_INFO using(FISH_TYPE)
    join FISH_NAME_INFO using(FISH_TYPE)
where ML = LENGTH
order by ID;