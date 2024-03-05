# Write your MySQL query statement below
SELECT (
    select distinct Salary
    from Employee order by salary desc
    limit 1 offset 1
) AS SecondHighestSalary;