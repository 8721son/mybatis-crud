# mybatis-crud

CREATE TABLE user(
    id int auto_increment primary key,
    username varchar(100) not null unique,
    password varchar(100) not null,
    email varchar(100), 
    userProfile varchar(200) default '/images/man.png',
    createDate timestamp
) engine=InnoDB default charset=utf8;

CREATE TABLE board(
    id int auto_increment primary key,
    userId int,
    title varchar(100) not null,
    content longtext,
    createDate timestamp,
    foreign key (userId) references user (id) 
) engine=InnoDB default charset=utf8;
