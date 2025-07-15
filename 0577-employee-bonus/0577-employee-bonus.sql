# Write your MySQL query statement below
Select 
    e.name,
    b.bonus
From 
    Employee e
LEft JOIN 
    Bonus b on e.empId = b.empId
where
    b.bonus < 1000 OR bonus IS NULL