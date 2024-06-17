alter table liga add constraint liga_deltagare_fk foreign key (deltagare_id) references deltagare(id);
