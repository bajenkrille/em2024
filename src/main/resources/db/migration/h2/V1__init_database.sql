drop table if exists deltagare cascade;
drop table if exists match_tips;
drop table if exists matchen;
drop table if exists points;
drop table if exists deltagare_seq;

create table match_tips
(
    id bigint not null auto_increment primary key,
    hemma_mal     int,
    borta_mal     int,
    deltagare_id  bigint,
    matchen_id  bigint
);

create table deltagare
(
    id  bigint not null auto_increment primary key,
    first_name    varchar(255),
    last_name     varchar(255),
    nick_name     varchar(255),
    email         varchar(255),
    phone_number  varchar(255),
    password      varchar(255),
    has_paid      boolean,
    match_tips_id bigint,
    points_id      bigint,
    liga_id      bigint
);

create table matchen
(
    id      bigint not null auto_increment primary key,
    hemma_lag     varchar(255),
    borta_lag     varchar(255),
    hemma_mal     int,
    borta_mal     int,
    played      boolean,
    match_tips_id bigint
);

create table points
(
    id        bigint not null auto_increment primary key,
    points    int,
    match_tips_id  bigint,
    deltagare_id  bigint
);

create table liga
(
    id           bigint not null auto_increment primary key,
    liga_name     varchar(255),
    description  varchar(255),
    deltagare_id  bigint
);

create table deltagare_seq (
    next_val bigint
);

create table match_tips_seq (
    next_val bigint
);

create table points_seq (
    next_val bigint
);

create table matchen_seq (
    next_val bigint
);

create table liga_seq (
    next_val bigint
);

create sequence deltagare_seq start with 1 increment by 50;
create sequence match_tips_seq start with 1 increment by 50;
create sequence matchen_seq start with 1 increment by 50;
create sequence points_seq start with 1 increment by 50;
create sequence liga_seq start with 1 increment by 50;