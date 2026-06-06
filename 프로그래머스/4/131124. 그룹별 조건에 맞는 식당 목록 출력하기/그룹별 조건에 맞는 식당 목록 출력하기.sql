select 
    member_name, review_text, 
    date_format(review_date, '%Y-%m-%d') as review_date
from rest_review join member_profile using(member_id)
where member_id = (
    select member_id
    from rest_review
    group by member_id
    order by count(member_id) desc
    limit 1 -- 여러 명인 경우 in으로 했을 때 통과가 안 됨
)
order by review_date, review_text;