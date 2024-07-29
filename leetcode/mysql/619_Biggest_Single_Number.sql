# Write your MySQL query statement below
SELECT 
    IFNULL(
        (SELECT num 
         FROM (
             SELECT `num`, COUNT(num) AS `count` 
             FROM MyNumbers
             GROUP BY `num`
             HAVING `count` = 1
             ORDER BY `num` DESC
             LIMIT 1
         ) AS subquery), 
        NULL
    ) AS `num`;
