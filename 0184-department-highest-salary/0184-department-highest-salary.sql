# Write your MySQL query statement below

select d.name as Department , e.name as Employee , e.salary
from Employee e
join Department d
on e.departmentId=d.id
where (e.departmentId, e.salary )in(select departmentId , max(salary) as ms
    from Employee
    group by departmentId);
