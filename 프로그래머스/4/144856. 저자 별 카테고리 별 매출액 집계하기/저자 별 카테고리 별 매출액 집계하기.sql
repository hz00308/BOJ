select 
    author_id, author_name, category, 
    sum(sales*price) as total_sales
from book_sales 
    join book using(book_id)
    join author using(author_id)
where year(sales_date) = 2022 and month(sales_date) = 1
group by author_id, author_name, category
order by author_id, category desc;