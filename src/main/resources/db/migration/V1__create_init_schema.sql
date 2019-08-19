


CREATE TABLE  `friends` (

    `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` varchar(20),
    `email` varchar(50),
    `friend_email` varchar(50),
    `created` timestamp default CURRENT_TIMESTAMP,
    `last_updated` timestamp default CURRENT_TIMESTAMP

)ENGINE=InnoDB DEFAULT CHARSET=UTF8;



CREATE TABLE  `subscribe_friend_update` (
    `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `email` varchar(50),
    `friend_email` varchar(50),
    `created` timestamp default CURRENT_TIMESTAMP,
    `last_updated` timestamp default CURRENT_TIMESTAMP

)ENGINE=InnoDB DEFAULT CHARSET=UTF8;



CREATE TABLE  `block_friend` (
    `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `email` varchar(50),
    `blocked_email` varchar(50),
    `created` timestamp default CURRENT_TIMESTAMP,
    `last_updated` timestamp default CURRENT_TIMESTAMP

)ENGINE=InnoDB DEFAULT CHARSET=UTF8;

