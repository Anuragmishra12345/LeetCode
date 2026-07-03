# Write your MySQL query statement below
SELECT *
FROM Cinema
where id%2!=0 && description!='boring'
order by rating DESC;