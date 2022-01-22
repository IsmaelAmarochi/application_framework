INSERT INTO ROLES VALUES ('1', 'ADMIN_ROLE');
INSERT INTO ROLES VALUES ('2', 'USER_ROLE');

INSERT INTO USERS VALUES ('1', 'user@gmail.com', 'Jhon', 'Doe', 'user');
INSERT INTO USERS VALUES ('2', 'admin@gmail.com', 'Jane', 'Doe', 'admin');

INSERT INTO USER_ROLE VALUES ('1', '2');
INSERT INTO USER_ROLE VALUES ('2', '1');