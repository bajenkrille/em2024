alter table points add constraint points_deltagare_fk foreign key (deltagare_id) references deltagare(id);
