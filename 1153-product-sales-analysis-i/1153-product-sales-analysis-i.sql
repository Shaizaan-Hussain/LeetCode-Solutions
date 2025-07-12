# Write your MySQL query statement below
Select
product_name,
year,
price
From Sales
Join Product on Sales.product_id = Product.product_id;
