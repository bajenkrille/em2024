drop table if exists spelschema;
create table spelschema
(
    id bigint not null auto_increment primary key,
    date     varchar(255),
    time     varchar(255),
    location  varchar(255),
    matchen_id  bigint
) engine = InnoDB;

alter table spelschema add constraint spelschema_fk foreign key (matchen_id) references matchen(id);

alter table matchen add column spelschema_id bigint;

create table spelschema_seq (
    next_val bigint
) engine=InnoDB;