SELECT p.product_name, s.year, s.price
FROM Product p
LEFT JOIN Sales s ON p.product_id = s.product_id
WHERE s.year IS NOT NULL AND s.price IS NOT NULL;