drop table if exists mission;
drop table if exists penalty;
drop table if exists reward;
drop table if exists comment;
drop table if exists user_matching;
drop table if exists matching;
drop table if exists user;

create table user
(
    id               int(10) primary key auto_increment,
    username         varchar(30)           not null,
    password         varchar(255)          not null,
    name             varchar(30)           not null,
    email            varchar(30) unique    not null,
    random_name      varchar(30)           not null,
    aware_role       boolean default false not null,
    prev_contributor boolean default false not null,
    prev_receiver    boolean default false not null,
    is_admin         boolean default false not null
);
create table matching
(
    id        int(10) primary key auto_increment,
    match_ymd date    default now() not null,
    round     int(10)               not null,
    archived  boolean default false not null,
    result    boolean default null
);

create table user_matching
(
    user_id        int(10)               not null,
    is_contributor boolean default false not null,
    is_receiver    boolean default false not null,
    match_id       int(10)               not null,
    constraint foreign key (user_id) references user (id),
    constraint foreign key (match_id) references matching (id)
);

create table mission
(
    id             int(10) primary key auto_increment,
    task           text              not null,
    recommendation int(10) default 0 not null,
    match_id       int(10)           not null,
    constraint foreign key (match_id) references matching (id)
);

create table reward
(
    id             int(10) primary key auto_increment,
    task           text              not null,
    recommendation int(10) default 0 not null,
    match_id       int(10)           not null,
    constraint foreign key (match_id) references matching (id)
);

create table penalty
(
    id             int(10) primary key auto_increment,
    task           text              not null,
    recommendation int(10) default 0 not null,
    match_id       int(10)           not null,
    constraint foreign key (match_id) references matching (id)
);

create table comment
(
    id       int(10) primary key auto_increment,
    writer   varchar(30)            not null,
    content  text                   not null,
    write_at datetime default now() not null,
    match_id int(10)                not null,
    constraint foreign key (match_id) references matching (id)
);
show tables;
