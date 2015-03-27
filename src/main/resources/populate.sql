insert into contact (first_name,last_name,birth_date) values ('John','Smith','1981-02-15');
insert into contact (first_name,last_name,birth_date) values ('Mary','Kay','1986-04-25');
insert into contact (first_name,last_name,birth_date) values ('John','Lenon','1951-01-05');
insert into contact (first_name,last_name,birth_date) values ('Joe','Malkovich','1976-12-12');
insert into hobby (hobby_id,hobby_descr) values ('Programming','Like programming');
insert into hobby (hobby_id,hobby_descr) values ('Swimming','Like swimming');
insert into hobby (hobby_id,hobby_descr) values ('Chess','Like to play chess');
insert into hobby (hobby_id,hobby_descr) values ('Photo','Like to make photo');
insert into hobby (hobby_id,hobby_descr) values ('Football','Like to play and watching football');
insert into contact_hobby (contact_id,hobby_id) values (1,'Programming');
insert into contact_hobby (contact_id,hobby_id) values (1,'Swimming');
insert into contact_hobby (contact_id,hobby_id) values (2,'Programming');
insert into contact_hobby (contact_id,hobby_id) values (3,'Swimming');
insert into contact_hobby (contact_id,hobby_id) values (3,'Football');
insert into contact_friendship (contact_id, friend_id) values (1,3);
insert into contact_friendship (contact_id, friend_id) values (1,4);
insert into contact_friendship (contact_id, friend_id) values (2,1);
insert into contact_friendship (contact_id, friend_id) values (2,3);
insert into contact_friendship (contact_id, friend_id) values (3,4);
insert into contact_friendship (contact_id, friend_id) values (4,2);
insert into place (place_id,place_descr) values ('Karavan','TC Karavan');
insert into place (place_id,place_descr) values ('Daffi','TC Daffi');
insert into place (place_id,place_descr) values ('Most-city','TC Most-City');
insert into place (place_id,place_descr) values ('Library','Just some library');
insert into contact_place (contact_id,place_id) values (1,'Karavan');
insert into contact_place (contact_id,place_id) values (3,'Karavan');
insert into contact_place (contact_id,place_id) values (4,'Karavan');
insert into contact_place (contact_id,place_id) values (1,'Daffi');
insert into contact_place (contact_id,place_id) values (2,'Daffi');
insert into contact_place (contact_id,place_id) values (3,'Daffi');
insert into contact_place (contact_id,place_id) values (2,'Most-city');
insert into contact_place (contact_id,place_id) values (4,'Most-city');
insert into contact_detail (contact_id,detail_type,detail_data) values (1,'skype','skypelogin1');
insert into contact_detail (contact_id,detail_type,detail_data) values (1,'mob. tel.','+380661234567');
insert into contact_detail (contact_id,detail_type,detail_data) values (1,'mob. tel.','+380673774567');
insert into contact_detail (contact_id,detail_type,detail_data) values (2,'skype','skypelogin2');
insert into contact_detail (contact_id,detail_type,detail_data) values (2,'mob. tel.','+380501234567');
insert into contact_detail (contact_id,detail_type,detail_data) values (3,'skype','skypelogin1');
insert into contact_detail (contact_id,detail_type,detail_data) values (3,'mob. tel.','+380951234567');
insert into contact_detail (contact_id,detail_type,detail_data) values (4,'skype','skypelogin1');