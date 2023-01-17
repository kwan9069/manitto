create table user
(
    id            int(10) primary key,
    username      varchar(30)  not null,
    password      varchar(255) not null,
    name          varchar(30)  not null,
    email         varchar(30)  not null,
    random_name   varchar(30)  not null,
    aware_role    boolean      not null,
    prev_donator  boolean      not null,
    prev_reveiver boolean      not null,
    is_admin      boolean      not null
);
create table match
(
    id        int(10) primary key,
    match_ymd date    not null,
    round     int(10) not null,
    archived  boolean not null,
    result    boolean not null
);

create table user_match
(
    user_id     int(10) not null,
    match_id    int(10) not null,
    is_donator  boolean not null,
    is_receiver boolean not null,
    constraint add foriegn key user_id reference user id,
    constraint add foriegn key match_id reference match id
);

create table mission
(
    id             int(10) primary key,
    match_id       int(10) not null,
    task           text not null,
    recommendation int(10) not null,
    constraint add foriegn key match_id reference match id
);

create table penalty
(
    id             int(10) primary key,
    match_id       int(10) not null,
    task           text not null,
    recommendation int(10) not null,
    constraint add foriegn key match_id reference match id
);

create table comment
(
    id       int(10) primary key,
    match_id int(10) not null,
    writer   varchar(30) not null,
    constraint add foriegn key match_id reference match id
);

show
tables