CREATE TABLE  `User` (

                         `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
                         `name` varchar(20),
                         `email` varchar(50),
                         `created` timestamp default CURRENT_TIMESTAMP,
                         `last_updated` timestamp default CURRENT_TIMESTAMP

)ENGINE=InnoDB DEFAULT CHARSET=UTF8;