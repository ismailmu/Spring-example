INSERT INTO users(email,name,password)
values('admin@btpn.com','admin','7c4a8d09ca3762af61e59520943dc26494f8941b'); -- 123456
INSERT INTO users(email,name,password)
values('user@btpn.com','user','7c4a8d09ca3762af61e59520943dc26494f8941b'); -- 123456

INSERT INTO roles(role_name,user_id)
values('ADMIN',1);
INSERT INTO roles(role_name,user_id)
values('USER',2);