-- https://www.tensortonic.com/study-plans/sql-basics/sql/sql-basic-select
SELECT product_name AS name, 
    category, (unit_price * units_in_stock) AS inventory_value
FROM products;

