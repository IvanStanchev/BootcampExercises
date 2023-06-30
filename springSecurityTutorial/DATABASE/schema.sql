CREATE DATABASE IF NOT EXISTS `jwt_security`;
USE `jwt_security`;

CREATE TABLE user
(
    id        INT PRIMARY KEY AUTO_INCREMENT,
    firstname VARCHAR(255) NOT NULL,
    lastname  VARCHAR(255) NOT NULL,
    email     VARCHAR(255) NOT NULL,
    password  VARCHAR(255) NOT NULL,
    role      VARCHAR(255) NOT NULL
);

CREATE TABLE note
(
    id            INT PRIMARY KEY AUTO_INCREMENT,
    last_modified DATETIME     NOT NULL,
    content       VARCHAR(255) NOT NULL,
    user_id       INT          NOT NULL,
    FOREIGN KEY (user_id) REFERENCES user (id)
);
