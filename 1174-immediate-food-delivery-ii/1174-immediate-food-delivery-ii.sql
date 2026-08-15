select 
round(
    avg(
        case
        when d.customer_pref_delivery_date=d.order_date then 1
        else 0
        end
    )*100,
    2
) as immediate_percentage
from Delivery d
join(
    select customer_id, min(order_date) as firstOrder from Delivery 
    group by customer_id
) f
on f.customer_id=d.customer_id
and f.firstOrder=d.order_date;
