select
    id,
    case -- 위에서부터 순서대로 검사해서 처음 만족하는 조건만 실행
        when size_of_colony <= 100 then 'LOW'
        when size_of_colony <= 1000 then 'MEDIUM'
        else 'HIGH'
    end as size
from ecoli_data
order by id;