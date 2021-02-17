drop table deliveryMember;
select * from deliveryMember where id='test';
select * from deliveryMember;
select money from deliveryMember where id='test';
update deliveryMember set password='abc', email='asd',address='asd' where id = '123';
update deliveryMember set money=1000000 where id = 'test';
create table deliveryMember(
	id varchar2(20),
	password varchar2(15),
	name varchar2(50),
	email varchar2(50),
	address varchar2(100),
	money number(10) default 0,
	userkind varchar2(10),
	storeAddress varchar2(100) null
);
update deliveryMember set money=500000 where id = 'test';
insert into deliveryMember(id,password,name,email,address,userkind) values('test','test','test','test','test','user');
insert into deliveryMember(id,password,name,email,address,userkind) values('아이디','123','J','123','대전광역시 서구 갈마동 262-13번지 202호','user');
select id,password from deliveryMember where id='test' and password='test';
delete from deliveryMember where id='test' and password='test';