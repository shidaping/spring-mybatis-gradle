create table post(
	id int unsigned not null primary key auto_increment,
	title varchar(255) not null,
	content text not null,
	created_by int,
	created_at date,
	updated_by int,
	updated_at date,
	comment_count int default 0
);
create table post_comment(
  id int unsigned not null primary key auto_increment,
  content text not null,
  post_id int not null,
  created_by int,
  created_at date,
  updated_by int,
  updated_at date
);
create table project(
  id int unsigned not null primary key auto_increment,
  name varchar(1000) not null,
  description text not null,
  program_language varchar(255),
  created_by int,
  created_at date,
  updated_by int,
  updated_at date,
  comment_count int default 0
);
create table user(
  id int unsigned not null primary key auto_increment,
  user_name varchar(255) unique,
  mobile varchar(100) unique,
  email varchar(255) unique,
  user_type int default 1,
  password varchar(255) not null,
  salt varchar(255) not null,
  nickname varchar(255),
  true_name varchar(255),
  avatar varchar(255),
  score int default 0,
  level int default 0,
  created_by int,
  created_at date,
  updated_by int,
  updated_at date,
  comment_count int default 0
);