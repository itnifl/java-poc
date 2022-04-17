use ticketsales;

-- drop table orders;
-- drop table ticket;
-- drop table event;
-- drop table user;
-- drop table accessRole;


CREATE TABLE accessRole ( 
    id INT NOT NULL PRIMARY KEY,
    role VARCHAR(12) NOT NULL
);

CREATE TABLE user (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(65) NOT NULL,
    loginId VARCHAR(25) NOT NULL,
    password VARCHAR(25) NOT NULL, 
    access_role INT NOT NULL,
    FOREIGN KEY (access_role) REFERENCES accessRole (id)
);

 CREATE TABLE event (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,      
    created_by_user_id INT NOT NULL,
    name VARCHAR(65) NOT NULL,
    event_description VARCHAR(655) NOT NULL,
    FOREIGN KEY (created_by_user_id) REFERENCES user (id)    
);

CREATE TABLE ticket (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    event_id INT NOT NULL,
    created_by_user_id INT NOT NULL,
    name VARCHAR(65) NOT NULL,
    price DOUBLE NOT NULL,
    description VARCHAR(265) DEFAULT NULL,
    FOREIGN KEY (event_id) REFERENCES event (id),
    FOREIGN KEY (created_by_user_id) REFERENCES user (id) 
);

CREATE TABLE orders (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    orderId INT NOT NULL,        
    userId INT NOT NULL,
    ticketId INT NOT NULL, 
    FOREIGN KEY (userId) REFERENCES user (id),
    FOREIGN KEY (ticketId) REFERENCES ticket (id)
);

INSERT INTO accessRole  (Id, Role) VALUES (1, 'CUSTOMER');
INSERT INTO accessRole  (Id, Role) VALUES (2, 'USER');