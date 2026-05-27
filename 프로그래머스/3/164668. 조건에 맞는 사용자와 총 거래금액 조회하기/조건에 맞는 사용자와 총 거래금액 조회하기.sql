select user_id, nickname, sum(price) as total_sales
from used_goods_board B join used_goods_user U
on B.writer_id = U.user_id
where status = 'DONE'
group by user_id
having sum(price) >= 700000
order by total_sales;