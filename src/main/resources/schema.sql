CREATE TABLE "user"
(
    "id"            long auto_increment primary key,
    "match_id"      long    not null,
    "username"      varchar not null,
    "password"      varchar not null,
    "email"         varchar not null,
    "is_admin"      varchar not null,
    "aware-role"    boolean not null,
    "num_of_part"   int     not null,
    "done_choice"   boolean not null,
    "prev_donator"  boolean not null,
    "prev_receiver" boolean not null,
    "random_name"   varchar
);

CREATE TABLE "match"
(
    "id"        long primary key,
    "donator"   long     not null,
    "receiver"  long     not null,
    "match_ymd" datetime not null,
    "result"    boolean  not null,
    "mission"   varchar  not null,
    "penalty"   varchar  not null,
    "atchived"  boolean  not null,
    "round"     int      not null,
    "activated" boolean  not null,
);

CREATE TABLE "mission"
(
    "id"       long primary key,
    "task"     varchar not null,
    "selected" boolean not null,
    "match_id" long,
);

CREATE TABLE "penalty"
(
    "id"       long primary key,
    "task"     varchar not null,
    "selected" boolean not null,
    "match_id" long,
);

CREATE TABLE "comment"
(
    "id"       long primary key,
    "content"  text    not null,
    "writer"   varchar not null,
    "match_id" long    not null,
    "user_id"  long    not null,
);

