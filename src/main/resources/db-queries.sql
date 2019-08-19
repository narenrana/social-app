
--Get common friends
SELECT frnds.id, frnds.email, frnds.friend_email FROM FRIENDS  frnds where frnds.email='andy@example.com'
UNION
SELECT frnds.id, frnds.friend_email as email   , frnds.email  as friend_email  FROM FRIENDS  frnds where frnds.friend_email='andy@example.com'

SELECT frnds.id, frnds.email, frnds.friend_email FROM FRIENDS  frnds where frnds.email='andy@example5.com'
UNION
SELECT frnds.id, frnds.friend_email as email   , frnds.email  as friend_email  FROM FRIENDS  frnds where frnds.friend_email='andy@example5.com'

-- Note-  Use further intersection  in case to found common one

SELECT user1Friends.id as id, NULL as email , user1Friends.friend_email, user1Friends.created, user1Friends.last_updated
from (
         SELECT frnds.id, frnds.email, frnds.friend_email, frnds.created, frnds.last_updated
         FROM FRIENDS frnds
         where frnds.email = :firstEmail
         UNION
         SELECT frnds.id, frnds.friend_email as email, frnds.email as friend_email , frnds.created, frnds.last_updated
         FROM FRIENDS frnds
         where frnds.friend_email = :firstEmail
     ) user1Friends
         INNER JOIN (
    SELECT frnds.id, frnds.email, frnds.friend_email, frnds.created, frnds.last_updated
    FROM FRIENDS frnds
    where frnds.email = :secondEmail
    UNION
    SELECT frnds.id, frnds.friend_email as email, frnds.email as friend_email, frnds.created, frnds.last_updated
    FROM FRIENDS frnds
    where frnds.friend_email = :secondEmail
) user2Friends on user1Friends.friend_email = user2Friends.friend_email
