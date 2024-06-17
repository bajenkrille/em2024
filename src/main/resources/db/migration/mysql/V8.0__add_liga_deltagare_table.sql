drop table if exists liga_deltagare;
create table liga_deltagare
(
    liga_id bigint not null,
    deltagare_id bigint not null,
    primary key (liga_id, deltagare_id)
) engine = InnoDB;
alter table liga_deltagare add constraint liga_join_fk foreign key (liga_id) references liga(id) on delete cascade;
alter table liga_deltagare add constraint deltagare_join_fk foreign key (deltagare_id) references deltagare(id) on delete cascade;
