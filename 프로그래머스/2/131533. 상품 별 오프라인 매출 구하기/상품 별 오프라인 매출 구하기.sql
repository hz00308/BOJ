select p.PRODUCT_CODE, sum(p.PRICE * os.SALES_AMOUNT) as SALES
from OFFLINE_SALE as os join PRODUCT as p using(PRODUCT_ID)
group by p.PRODUCT_CODE
order by SALES desc, p.PRODUCT_CODE;