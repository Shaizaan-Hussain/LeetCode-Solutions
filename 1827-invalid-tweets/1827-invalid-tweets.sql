# Write your MySQL query statement below
Select 
    tweet_id
From 
    Tweets
Where
    Char_Length(content) > 15;