
create table store(
	storeNo number(10) primary key,
	storeName varchar2(50),
	storePhone varchar(15),
	address varchar(100),
	longitude number(20,10),
	latitude number(20,10),
	imgUrl varchar(100),
	foodcode varchar(10)
);

delete from food where foodName='연어샐러드';
create sequence storeNo_seq start with 1 increment by 1;


drop table store;
drop table food;


select * from store;
select storeNo from store;
select storeNo from store where storeName = '스시은인';


drop sequence storeNo_seq;

DELETE FROM store WHERE storeNo = 7;
delete from food where storeNo =7;

select * from store;

insert into store(storeNo,storeName,storePhone,address,longitude,latitude,imgUrl,foodcode)
values(storeNo_seq.nextVal,'버거킹','1599-0505','대전광역시 중구 용두동 29-5', 36.3251767, 127.4091049,'./image/burgerking.jpg','a');

insert into store(storeNo,storeName,storePhone,address,longitude,latitude,imgUrl,foodcode)
values(storeNo_seq.nextVal,'계동치킨','042-528-9920','대전광역시 중구 태평1동 263-12', 36.3233664	,127.3908232,'./image/kyedong.jpg','b');

insert into store(storeNo,storeName,storePhone,address,longitude,latitude,imgUrl,foodcode)
values(storeNo_seq.nextVal,'뽕뜨락피자','042-528-9920','대전광역시 중구 태평1동 330-20',36.3233658,127.3907803,'./image/bbong.jpg','c');

insert into store(storeNo,storeName,storePhone,address,longitude,latitude,imgUrl,foodcode)
values(storeNo_seq.nextVal,'롯데리아','042-535-8491','대전광역시 중구 태평동 408-11', 36.3233651, 127.3907374,'./image/lotteria.jpg','a');

insert into store(storeNo,storeName,storePhone,address,longitude,latitude,imgUrl,foodcode)
values(storeNo_seq.nextVal,'일이공생돈까스','042-226-9784','대전광역시 중구 중앙로121번길 16', 36.3284393,127.4209602,'./image/ilegongseng.jpg','d');





insert into store(storeNo,storeName,storePhone,address,longitude,latitude,imgUrl,foodcode)
values(storeNo_seq.nextVal,'우리의오늘','042-523-0927','대전광역시 중구 오류동 186-5', 36.3272331,127.4030312,'./image/uriye.jpg','o');

insert into store(storeNo,storeName,storePhone,address,longitude,latitude,imgUrl,foodcode)
values(storeNo_seq.nextVal,'연어가','042-254-4050','대전광역시 중구 용두동 24-1', 36.3248312,127.4088288,'./image/yeoneoga.jpg','m,n');

insert into store(storeNo,storeName,storePhone,address,longitude,latitude,imgUrl,foodcode)
values(storeNo_seq.nextVal,'다루마 ','042-534-3144','대전광역시 중구 오류동 151-8 크럭스빌주상복합', 36.322953, 127.41075,'./image/daruma.jpg','p');

insert into store(storeNo,storeName,storePhone,address,longitude,latitude,imgUrl,foodcode)
values(storeNo_seq.nextVal,'스시은인','042-527-3430','대전 중구 오류동 149-4', 36.3237341,127.4094578,'./image/yunin.jpg','o,m');






insert into store(storeNo,storeName,storePhone,address,longitude,latitude,imgUrl,foodcode)
values(storeNo_seq.nextVal,'청해루 24시','042-257-6591','대전광역시 중구 문화동 1-36', 36.3199421,127.4123182,'./image/junghwaru.jpg','i,j');

insert into store(storeNo,storeName,storePhone,address,longitude,latitude,imgUrl,foodcode)
values(storeNo_seq.nextVal,'상하이 중화요리','042-489-5888','대전광역시 서구 탄방동 1042', 36.3395617,127.3922031,'./image/sanghi.jpg','i,j,k');

insert into store(storeNo,storeName,storePhone,address,longitude,latitude,imgUrl,foodcode)
values(storeNo_seq.nextVal,'중화루','042-527-0522','대전광역시 중구 오류동 171-32', 36.3226096,127.4040366,'./image/junghwaru.jpg','i,j');

insert into store(storeNo,storeName,storePhone,address,longitude,latitude,imgUrl,foodcode)
values(storeNo_seq.nextVal,'북경뚝배기짬뽕','042-537-6889','대전광역시 중구 태평2동 349-3', 36.3295284,127.3965968,'./image/bukgyong.jpg','i,j');

insert into store(storeNo,storeName,storePhone,address,longitude,latitude,imgUrl,foodcode)
values(storeNo_seq.nextVal,'용두동 차이나','042-255-3002','대전광역시 중구 용두동 136-6', 36.3320726,127.4017366,'./image/china.jpg','i,j');

insert into store(storeNo,storeName,storePhone,address,longitude,latitude,imgUrl,foodcode)
values(storeNo_seq.nextVal,'북경대반점','042-526-1188','대전광역시 서구 용문동 231-37', 36.3218565,127.3766843,'./image/bukgyongdae.jpg','i,j');

insert into store(storeNo,storeName,storePhone,address,longitude,latitude,imgUrl,foodcode)
values(storeNo_seq.nextVal,'옛날전통짜장','042-527-4493','대전광역시 중구 태평2동 379-32', 36.2983243,127.3155501,'./image/yetnal.jpg','i,j');





insert into store(storeNo,storeName,storePhone,address,longitude,latitude,imgUrl,foodcode)
values(storeNo_seq.nextVal,'토마토도시락','042-471-5529','대전광역시 서구 둔산1동 1417', 36.350379,127.387252,'./image/tomato.jpg','e');

insert into store(storeNo,storeName,storePhone,address,longitude,latitude,imgUrl,foodcode)
values(storeNo_seq.nextVal,'놀부부대찌개-대전중앙로','042-253-8837','대전광역시 중구 은행동 170-6', 36.327566,127.42851,'./image/nolboo.jpg','h');

insert into store(storeNo,storeName,storePhone,address,longitude,latitude,imgUrl,foodcode)
values(storeNo_seq.nextVal,'민이철판곱창볶음','042-487-5288','대전광역시 서구 탄방동 821', 36.346291,127.390738,'./image/mini.jpg','f,g');

insert into store(storeNo,storeName,storePhone,address,longitude,latitude,imgUrl,foodcode)
values(storeNo_seq.nextVal,'남다른대구막창','042-471-5529','대전광역시 중구 오류동 159-10', 36.322105,127.408403,'./image/namda.jpg','f,g');

insert into store(storeNo,storeName,storePhone,address,longitude,latitude,imgUrl,foodcode)
values(storeNo_seq.nextVal,'진짜닭불고기','042-535-7366','대전광역시 중구 태평1동 257-16', 36.327966,127.399494,'./image/sukbul.jpg','f');






create table food(
	storeNo number(10) references store(storeNo),
	foodKind number(5),	
	foodName varchar2(50),
	price number(10)
);
drop table food;
drop table store;
select * from food;
select * from store;

select * from food where foodName LIKE '%고기%';

insert into food values(2,1,'와퍼세트',8200 );
insert into food values(2,1,'롱치킨버거',6900 );
insert into food values(2,1,'와사비크랩',6000 );
insert into food values(2,1,'치즈와퍼',3900 );

insert into food values(3,1,'한마리치킨',16000);
insert into food values(3,1,'양념파닭',18000);
insert into food values(3,1,'반반',17000);
insert into food values(3,1,'날개치킨',18000 );

insert into food values(4,1,'모모스테키',24900 );
insert into food values(4,1,'코코쉬림프',24900 );
insert into food values(4,1,'리치킨BBQ',16900 );
insert into food values(4,1,'맵뜨락',24900 );

insert into food values(5,1,'모짜새우버거세트',6700 );
insert into food values(5,1,'불고기버거세트',5400 );
insert into food values(5,1,'핫크리스피버거세트',3900 );
insert into food values(5,1,'치즈와퍼',3900 );

insert into food values(6,1,'돈까스',7000 );
insert into food values(6,1,'카레돈까스',9000 );
insert into food values(6,1,'냉모밀',5000 );
insert into food values(6,1,'생선까스',7000 );




insert into food values(7,2,'일본식규동',6000 );
insert into food values(7,2,'새우버터카레',8000 );
insert into food values(7,2,'오꼬노미야끼',16000 );
insert into food values(7,2,'치즈규동',7000 );

insert into food values(8,2,'연어회 대',47000 );
insert into food values(8,2,'연어회 중', 36000 );
insert into food values(8,2,'연어회 소',25000 );
insert into food values(8,2,'연어초밥',10000 );

insert into food values(9,2,'산낙지',20000 );
insert into food values(9,2,'삼치구이',15000 );
insert into food values(9,2,'꼬막찜',15000 );
insert into food values(9,2,'키조개철판',20000 );

insert into food values(10,2,'모듬초밥',15000 );
insert into food values(10,2,'스페셜초밥',25000 );
insert into food values(10,2,'연어덮밥',10000 );
insert into food values(10,2,'회덮밥',10000 );




insert into food values(11,3,'해물쟁반짜장',13000 );
insert into food values(11,3,'해물쟁반짬뽕',13000 );
insert into food values(11,3,'짜장면',5000 );
insert into food values(11,3,'짬뽕',6000 );

insert into food values(12,3,'짬뽕',6000 );
insert into food values(12,3,'간짜장',6000 );
insert into food values(12,3,'우동',6000 );
insert into food values(12,3,'홍합짬뽕',8000 );

insert into food values(13,3,'짜장면',5000 );
insert into food values(13,3,'간짜장',6000 );
insert into food values(13,3,'짬뽕',6000 );
insert into food values(13,3,'삼선짬뽕',8000 );

insert into food values(14,3,'짬뽕',6000 );
insert into food values(14,3,'간짜장',6000 );
insert into food values(14,3,'해물쟁반짜장',13000 );
insert into food values(14,3,'해물쟁반짬뽕',13000 );

insert into food values(15,3,'우동',5500 );
insert into food values(15,3,'짜장면',4500 );
insert into food values(15,3,'짬뽕',5500 );
insert into food values(15,3,'탕수육(소)',13000 );

insert into food values(16,3,'짬뽕',6000 );
insert into food values(16,3,'우동',6000 );
insert into food values(16,3,'간짜장',6000 );
insert into food values(16,3,'삼선짱뽕',8000 );

insert into food values(17,3,'웰빙 짜장면',5000);
insert into food values(17,3,'불타는 짜장면',5500);
insert into food values(17,3,'짬뽕',6000);
insert into food values(17,3,'불타는 짬뽕',6500);



insert into food values(18,4,'데리와퍼참치',3800 );
insert into food values(18,4,'제육덮밥',3000 );
insert into food values(18,4,'야채참치비',3800 ); --
insert into food values(18,4,'치킨가라아게',3900 );


insert into food values(19,4,'통핑놀부세트',15000 );
insert into food values(19,4,'놀부부대세트',21000 );
insert into food values(19,4,'통핑치즈세트',23000 );
insert into food values(19,4,'소곱창부대전',27500 ); --

insert into food values(20,4,'야채곱창2인',17000 );
insert into food values(20,4,'마늘곱창볶',17000 );--
insert into food values(20,4,'연탄빨간불',8000 ); --
insert into food values(20,4,'주먹밥',3000 );

insert into food values(21,4,'소금막창구이(소)',20000 );
insert into food values(21,4,'간장불고기(소)',17000 );
insert into food values(21,4,'날치알주먹밥',3000 );
insert into food values(21,4,'고추장불고기2인',17000 );

insert into food values(22,4,'계란찜',4000 );
insert into food values(22,4,'산더미닭불고기',15000 );
insert into food values(22,4,'치즈닭불고기',17000 );
insert into food values(22,4,'직화통뼈닭발',10000 );









select * from food;

-----------------------------------------------------------------------------------------------
