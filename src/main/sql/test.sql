create table post(
  id int auto_increment primary key,
  content text,
  title varchar(1000)
);

create table user(
  id int auto_increment primary key,
  password varchar(255),
  
);