DROP DATABASE IF EXISTS baking;
CREATE DATABASE baking CHARSET = UTF8;
USE baking;
create table user
(
    id           bigint primary key auto_increment,
    username     varchar(100),
    password     varchar(100),
    nickname     varchar(100),
    is_admin     int,
    created_time datetime,
    img_url      varchar(255)
) CHARSET = UTF8;



