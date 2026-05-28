select apnt_no, pt_name, pt_no, appointment.mcdp_cd, dr_name, apnt_ymd
from appointment 
    join doctor on appointment.mddr_id = doctor.dr_id
    join patient using(pt_no)
where date(apnt_ymd) = '2022-04-13' 
    and appointment.mcdp_cd = 'CS'
    and apnt_cncl_yn = 'N'
order by apnt_ymd;