drop table if exists deltagare cascade;
drop table if exists match_tips;
drop table if exists deltagare_seq;

create table match_tips
(
    match_tips_id bigint not null auto_increment primary key,
    hemma_mal     int,
    borta_mal     int,
    deltagare_id  bigint
) engine = InnoDB;

create table deltagare
(
    deltagare_id  bigint not null auto_increment primary key,
    first_name    varchar(255),
    last_name     varchar(255),
    nick_name     varchar(255),
    email         varchar(255),
    phone_number  varchar(255),
    password      varchar(255),
    has_paid      boolean,
    match_tips_id bigint,
    poang_id      bigint,
    constraint match_tips_fk FOREIGN KEY (match_tips_id) references match_tips(match_tips_id)
) engine = InnoDB;

create table deltagare_seq (
    next_val bigint
) engine=InnoDB;

insert into deltagare_seq values ( 1 );