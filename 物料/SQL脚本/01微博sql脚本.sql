DROP DATABASE IF EXISTS blog;
CREATE DATABASE blog CHARSET = UTF8;
USE blog;
CREATE TABLE user
(
    id       BIGINT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50),
    password VARCHAR(100),
    nickname VARCHAR(50),
    created  TIMESTAMP
) CHARSET = UTF8;

CREATE TABLE weibo
(
    id      BIGINT PRIMARY KEY AUTO_INCREMENT,
    content VARCHAR(255),
    created TIMESTAMP,
    user_id BIGINT
) CHARSET = UTF8;

CREATE TABLE comment
(
    id       BIGINT PRIMARY KEY AUTO_INCREMENT,
    content  VARCHAR(255),
    created  TIMESTAMP,
    user_id  BIGINT,
    weibo_id BIGINT
) CHARSET = UTF8;

INSERT INTO user
VALUES (100, 'Lucy', '123456', 'lucy', '1987-10-16 00:00:00');
INSERT INTO user
VALUES (101, 'Tom', '123456', 'tom', '1987-10-16 00:00:00');
INSERT INTO user
VALUES (102, 'Jim', '123456', 'jim', '1987-10-16 00:00:00');

INSERT INTO weibo
VALUES (200, 'lucy的第1条微博', '2000-01-01 00:00:00', 100);
INSERT INTO weibo
VALUES (201, 'lucy的第2条微博', '2000-01-01 00:00:00', 100);
INSERT INTO weibo
VALUES (202, 'tom的第1条微博', '2000-01-01 00:00:00', 101);
INSERT INTO weibo
VALUES (203, 'tom的第2条微博', '2000-01-01 00:00:00', 101);
INSERT INTO weibo
VALUES (204, 'tom的第3条微博', '2000-01-01 00:00:00', 101);

INSERT INTO comment
VALUES (300, 'lucy对第1条微博的评论', '2008-01-01 00:00:00', 100, 200);
INSERT INTO comment
VALUES (301, 'tom对第1条微博的评论', '2008-01-01 00:00:00', 101, 200);
INSERT INTO comment
VALUES (302, 'lucy对第2条微博的评论', '2008-01-01 00:00:00', 100, 201);
INSERT INTO comment
VALUES (303, 'tom对第2条微博的评论', '2008-01-01 00:00:00', 101, 201);
INSERT INTO comment
VALUES (304, 'jim对第2条微博的评论', '2008-01-01 00:00:00', 102, 201);



