select animal_id, O.name
from animal_ins I join animal_outs O using(animal_id)
where I.datetime > O.datetime
order by I.datetime;