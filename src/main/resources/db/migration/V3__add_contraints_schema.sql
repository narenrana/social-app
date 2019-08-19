ALTER TABLE friends ADD CONSTRAINT unique_friends_record  UNIQUE KEY (email, friend_email);
ALTER TABLE subscribe_friend_update ADD CONSTRAINT subscribe_friend_update_record  UNIQUE KEY (email, friend_email);
ALTER TABLE block_friend ADD CONSTRAINT block_friend_record  UNIQUE KEY  (email, blocked_email);