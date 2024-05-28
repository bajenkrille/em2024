alter table deltagare add constraint match_tips_fk foreign key (match_tips_id) references match_tips(id);
alter table deltagare add constraint points_fk foreign key (points_id) references points(id);
alter table liga add constraint deltagare_fk foreign key (deltagare_id) references deltagare(id);
alter table matchen add constraint matchen_fk foreign key (match_tips_id) references match_tips(id);
alter table points add constraint points_match_tips_fk foreign key (match_tips_id) references match_tips(id);
