# Write your MySQL query statement below
SELECT 
    tweet_id
FROM 
    Tweets
WHERE
    Char_Length(content) > 15;