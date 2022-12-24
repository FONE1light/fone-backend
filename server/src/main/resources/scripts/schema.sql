DROP TABLE IF EXISTS users;

CREATE TABLE users
(
    id            bigint NOT NULL AUTO_INCREMENT,
    job           varchar(100),
    interests     varchar(50),
    nickname      varchar(100),
    birthday      varchar(100),
    gender        varchar(100),
    profile_url   varchar(100),
    phone_number  varchar(50),
    email         varchar(20),
    provider_type varchar(10),
    primary key (id)
);
