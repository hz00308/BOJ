select 
    ANIMAL_ID, NAME, 
    if(left(SEX_UPON_INTAKE, position(' ' in SEX_UPON_INTAKE)-1) = 'Neutered' or left(SEX_UPON_INTAKE, position(' ' in SEX_UPON_INTAKE)-1) = 'Spayed', 'O', 'X') as `중성화`
from ANIMAL_INS
order by ANIMAL_ID;