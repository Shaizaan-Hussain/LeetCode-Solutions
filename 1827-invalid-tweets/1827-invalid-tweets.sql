# Write your MySQL query statement below
select 
    tweet_id
From 
    Tweets
where
    Char_Length(content) > 15;