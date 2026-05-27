select animal_id, O.name
from animal_ins I join animal_outs O using(animal_id)
order by datediff(O.datetime, I.datetime) desc
limit 2;