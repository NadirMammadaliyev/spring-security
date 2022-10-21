create table table_for_test
(
    id serial not null
        constraint mail_user_pk
            primary key,
    user_name varchar(30),
    user_surname varchar(30),
    mail varchar(60),
    message varchar(100),
    count int
);
