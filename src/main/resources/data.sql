DROP TABLE IF EXISTS user_role;
DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS role;
DROP TABLE IF EXISTS meter;

CREATE TABLE user
(
    id       INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(250) NOT NULL,
    password VARCHAR(250) NOT NULL,
    enabled  BOOLEAN
);

INSERT INTO user (username, password, enabled)
VALUES ('admin', '$2a$10$e6H1Jgrft/scpmpzbMFO0uqF1gxqop73l5wOlwF30Aem6Tty1nI2G', true),
       ('azhwani', '$2a$10$kWWOnNOiToOxcIQ7UJ.cB.XFAflYvMS5BPASR1eqqojc6H9ELWUfC', true),
       ('guest', '$2a$10$SNsPkXTh0ryc82.D2HRJqOcY8sYh/TPnJW8WLqrERWkOq01ViWaCq', true);

CREATE TABLE role
(
    id   INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(250) NOT NULL
);

INSERT INTO role (name)
VALUES ('USER'),
       ('ADMIN'),
       ('MANAGER');


CREATE TABLE user_role
(
    user_id INTEGER NOT NULL,
    role_id INTEGER NOT NULL,
    FOREIGN KEY (user_id) REFERENCES user (id),
    FOREIGN KEY (role_id) REFERENCES role (id),
    PRIMARY KEY (user_id, role_id)
);

INSERT INTO user_role (user_id, role_id)
VALUES (1, 2),
       (2, 1),
       (2, 2),
       (2, 3),
       (3, 1);

CREATE TABLE meter
(
    id   LONG AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(250) NOT NULL
);

INSERT INTO meter (name)
VALUES ('meter1'),
       ('meter2'),
       ('meter3');
