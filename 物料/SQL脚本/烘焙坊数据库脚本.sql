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
drop table if exists category;
create table category
(
    id        bigint primary key auto_increment,
    name      varchar(100),
    level     int,
    parent_id int,
    type      int
);
insert into category(name, level, parent_id, type)
values ('烘焙食谱', 1, 0, 1),
       ('面包', 2, 1, 1),
       ('蛋挞', 2, 1, 1),
       ('欧包', 2, 1, 1),
       ('烘焙视频', 1, 0, 2),
       ('土司教学', 2, 5, 2),
       ('法棍教学', 2, 5, 2),
       ('行业资讯', 1, 0, 3),
       ('商家资讯', 2, 8, 3),
       ('美食资讯', 2, 8, 3);
drop table if exists content;
create table content
(
    id            bigint primary key auto_increment,
    title         varchar(255),
    img_url       varchar(255),
    video_url     varchar(255),
    content       text,
    type          int,
    view_count    int,
    comment_count int,
    brief         varchar(50),
    category_id   bigint,
    user_id       bigint,
    update_by     bigint,
    create_time   datetime,
    update_time   datetime
);
drop table if exists banner;
create table banner
(
    id          bigint primary key auto_increment,
    img_url     varchar(255),
    create_time datetime
);
INSERT INTO baking.banner
VALUES (null, '/banner1.jpg', '2024/01/15'),
       (null, '/banner2.jpg', '2024/01/15'),
       (null, '/banner3.jpg', '2024/01/15')


