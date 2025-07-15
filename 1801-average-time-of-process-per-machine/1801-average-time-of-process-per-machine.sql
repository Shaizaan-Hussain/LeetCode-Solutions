# Write your MySQL query statement below
Select a.machine_id,
    ROUND(AVG(b.timestamp - a.timestamp), 3) AS processing_time 
From Activity a,
    Activity b
Where 
    a.machine_id = b.machine_id
AND 
    a.process_id = b.process_id
AND
    a.activity_type = 'start'
AND 
    b.activity_type = 'end'
Group By 
    machine_id;