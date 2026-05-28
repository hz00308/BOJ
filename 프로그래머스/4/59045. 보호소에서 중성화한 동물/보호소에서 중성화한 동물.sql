select animal_id, animal_type, name
from animal_ins join animal_outs using(animal_id, animal_type, name)
where (sex_upon_intake = 'Intact Female' and sex_upon_outcome = 'Spayed Female')
    or (sex_upon_intake = 'Intact Male' and sex_upon_outcome = 'Neutered Male')
order by animal_id;