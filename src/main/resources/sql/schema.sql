drop table if exists action;
drop table if exists comment;
drop table if exists user_match;
drop table if exists `match`;
drop table if exists user;

create table user
(
    id               int(10) primary key auto_increment,
    username         varchar(30) unique         not null,
    password         varchar(255)               not null,
    name             varchar(30)                not null,
    email            varchar(30) unique         not null,
    random_name      varchar(30) default null,
    role             varchar(30) default 'none' not null,
    aware_role       boolean     default false  not null,
    prev_contributor boolean     default false  not null,
    prev_receiver    boolean     default false  not null,
    is_admin         boolean     default false  not null
);
create table `match`
(
    id        int(10) primary key auto_increment,
    title     varchar(50)           not null,
    match_ymd date    default now() not null,
    round     int(10)               not null,
    archived  boolean default false not null,
    result    boolean default null
);

create table user_match
(
    id             int(10) primary key auto_increment,
    user_id        int(10)               not null,
    match_id       int(10)               not null,
    is_contributor boolean default false not null,
    is_receiver    boolean default false not null,
    constraint foreign key (user_id) references user (id) on delete set null,
    constraint foreign key (match_id) references `match` (id)
);

create table action
(
    id             int(10) primary key auto_increment,
    type           int(10)           not null,
    match_id       int(10)           not null,
    task           text              not null,
    recommendation int(10) default 0 not null,
    constraint foreign key (match_id) references `match` (id)
);

create table comment
(
    id       int(10) primary key auto_increment,
    user_id  int(10)                not null,
    match_id int(10)                not null,
    writer   varchar(30)            not null,
    content  text                   not null,
    write_at datetime default now() not null,
    edited   boolean  default false not null,
    constraint foreign key (user_id) references user (id) on delete set null,
    constraint foreign key (match_id) references `match` (id)
);

show tables;


