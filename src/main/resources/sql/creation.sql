CREATE SCHEMA IF NOT EXISTS AWESOME_SCHEMA;
drop table  if exists AWESOME_SCHEMA.USERLIST;
CREATE TABLE AWESOME_SCHEMA.USERLIST
(USER_ID NUMBER,
USER_NAME VARCHAR(100),
user_birthday date,
user_active boolean);


INSERT INTO AWESOME_SCHEMA.USERLIST (USER_ID, USER_NAME, user_birthday, user_active) values(1, 'FIRST_US',to_date('01.02.2000', 'dd.mm.yyyy'), TRUE);
INSERT INTO AWESOME_SCHEMA.USERLIST (USER_ID, USER_NAME, user_birthday, user_active) values(2, 'SECOND_US', to_date('01.03.1999','dd.mm.yyyy'), FALSE);
INSERT INTO AWESOME_SCHEMA.USERLIST(USER_ID, USER_NAME, user_birthday, user_active) values(3, 'THIRD_US', to_date('01.04.1998','dd.mm.yyyy'), TRUE);
INSERT INTO AWESOME_SCHEMA.USERLIST(USER_ID, USER_NAME, user_birthday, user_active) values(4, 'FORTH_US', to_date('01.05.1997','dd.mm.yyyy'), TRUE);
