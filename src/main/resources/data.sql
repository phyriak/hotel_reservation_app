INSERT INTO `user` (username, password, user_type, phone, active) VALUES ('Roman', 'xyz','ROLE_ADMIN',616111666, true);
INSERT INTO `user` (username, password, user_type, phone, active) VALUES ('Wieslawa', 'xyz','ROLE_CLIENT',616111666, true);
INSERT INTO `user` (username, password, user_type, phone, active) VALUES ('Zbyszek', 'xyz','ROLE_CLIENT',616111666, true);
INSERT INTO `user` (username, password, user_type, phone, active) VALUES ('Leszek', 'xyz','ROLE_CLIENT',616111666, true);
INSERT INTO `user` (username, password, user_type, phone, active) VALUES ('Karolina', 'xyz','ROLE_CLIENT',616111666, true);
INSERT INTO `user` (username, password, user_type, phone, active) VALUES ('Mieszko', 'xyz','ROLE_CLIENT',616111666, true);
INSERT INTO `user` (username, password, user_type, phone, active) VALUES ('Zosia', 'xyz','ROLE_CLIENT',616111666, true);




INSERT INTO room (room_type, price, rate) VALUES ('ONE_PERSON',100,3);
INSERT INTO room (room_type, price, rate) VALUES ('ONE_PERSON',100,3);
INSERT INTO room (room_type, price, rate) VALUES ('ONE_PERSON',150,5);
INSERT INTO room (room_type, price, rate) VALUES ('ONE_PERSON',150,5);
INSERT INTO room (room_type, price, rate) VALUES ('TWO_PERSON',200,4);
INSERT INTO room (room_type, price, rate) VALUES ('TWO_PERSON',200,4);
INSERT INTO room (room_type, price, rate) VALUES ('TWO_PERSON',300,5);


INSERT INTO additional_service_pack (service_pack_id) VALUES (1);

INSERT INTO additional_service (name_s, price, ADDITIONAL_SERVICE_LIST_SERVICE_PACK_ID) VALUES ('breakfast',10,1);
INSERT INTO additional_service (name_s, price, ADDITIONAL_SERVICE_LIST_SERVICE_PACK_ID) VALUES ('parking',15,1);

INSERT INTO room_order (user_user_id,room_room_id, from_date, to_date, total_price, additional_service_pack_service_pack_id,additional_information) VALUES (1, 1,'2020-06-01 12:00:00','2020-06-07 12:00:00',700, 1,'Gosc z psem');
