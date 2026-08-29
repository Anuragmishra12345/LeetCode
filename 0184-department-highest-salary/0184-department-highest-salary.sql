# Write your MySQL query statement below
with maxSalary as(
    select max(salary) as ms, departmentId
    from Employee
    group by departmentId
)

select d.name as Department , e.name as Employee , e.salary
from Employee e
join Department d
on e.departmentId=d.id
where (e.departmentId, e.salary )in(select departmentId, ms from maxSalary);
