# Write your MySQL query statement below

select employee_id,
    case
        when employee_id%2!=0 and name not like 'M%' then salary
        else 0
    END as bonus

    from Employees
    Order by employee_id;