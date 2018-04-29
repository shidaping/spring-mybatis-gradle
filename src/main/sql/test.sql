create table user(
  id bigint auto_increment primary key,
  mobile varchar(20) unique comment '手机号',
  username varchar(50) unique comment '用户名',
  email varchar(100) unique comment '邮箱',
  encoded_password varchar(255) not null comment '密码',
  salt varchar(255) not null comment '盐',
  is_valid tinyint default 0 comment '验证',
  is_deleted tinyint default 0 comment '删除',
  created_at timestamp default '0000-00-00 00:00:00' comment '创建时间',
  updated_at timestamp default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '更新时间',
  created_by int comment '创建人id',
  updated_by int comment '修改人id'
) comment = '用户表';

create table user_game(
  id bigint auto_increment primary key,
  user_id bigint not null comment '游戏id',
  game_id bigint not null comment '游戏id',
  is_valid tinyint default 0 comment '验证',
  is_deleted tinyint default 0 comment '删除',
  created_at timestamp default '0000-00-00 00:00:00' comment '创建时间',
  updated_at timestamp default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '更新时间',
  created_by int comment '创建人id',
  updated_by int comment '修改人id',
  key(user_id)
) comment = '用户游戏表';

create table game(
  id bigint auto_increment primary key,
  name varchar(100) unique comment '游戏名称',
  logo varchar(255) not null comment 'logo',
  company int comment '公司',
  engine int comment '引擎',
  tags varchar(1000) comment '标签',
  description varchar(1000) comment '描述',
  method int comment '玩法',
  dimension int comment '维度',
  theme int comment '题材',
  market_time date comment '上市时间',
  is_valid tinyint default 0 comment '验证',
  is_deleted tinyint default 0 comment '删除',
  created_at timestamp default '0000-00-00 00:00:00' comment '创建时间',
  updated_at timestamp default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '更新时间',
  created_by int comment '创建人id',
  updated_by int comment '修改人id'
) comment = '游戏表';

create table game_img(
  id bigint auto_increment primary key,
  game_id bigint not null comment '游戏id',
  url varchar(100) not null comment '地址',
  is_valid tinyint default 0 comment '验证',
  is_deleted tinyint default 0 comment '删除',
  created_at timestamp default '0000-00-00 00:00:00' comment '创建时间',
  updated_at timestamp default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '更新时间',
  created_by int comment '创建人id',
  updated_by int comment '修改人id',
  key(game_id)
) comment = '游戏图';

create table article(
  id bigint auto_increment primary key,
  game_id bigint not null comment '游戏id',
  tags varchar(1000) comment '标签',
  category int comment '分类',
  title varchar(1000) not null comment '标题',
  content text not null comment '内容',
  is_valid tinyint default 0 comment '验证',
  is_deleted tinyint default 0 comment '删除',
  created_at timestamp default '0000-00-00 00:00:00' comment '创建时间',
  updated_at timestamp default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '更新时间',
  created_by int comment '创建人id',
  updated_by int comment '修改人id',
  key(game_id)
) comment = '文章攻略';

create table news(
  id bigint auto_increment primary key,
  game_id bigint not null comment '游戏id',
  category int comment '分类',
  tags varchar(1000) comment '标签',
  title varchar(1000) not null comment '标题',
  content text not null comment '内容',
  is_valid tinyint default 0 comment '验证',
  is_deleted tinyint default 0 comment '删除',
  created_at timestamp default '0000-00-00 00:00:00' comment '创建时间',
  updated_at timestamp default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '更新时间',
  created_by int comment '创建人id',
  updated_by int comment '修改人id',
  key(game_id)
) comment = '新闻';