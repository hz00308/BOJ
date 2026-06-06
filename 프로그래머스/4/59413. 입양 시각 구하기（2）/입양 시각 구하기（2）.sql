with recursive hours as ( -- 재귀적 CTE
    select 0 as hour -- 초기값 설정
    union all -- union all 
    select hour+1 -- 재귀: 이전 결과에 1을 더함
    from hours
    where hour < 23 -- 종료 조건 
)
select H.hour, count(animal_id) as count
from hours H left join animal_outs AO
on H.hour = hour(AO.datetime)
group by H.hour
order by H.hour;