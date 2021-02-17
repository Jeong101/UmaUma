drop table worldCup;

create table worldCup(
	foodKind varchar2(20),
	foodNo number(16),
	imgUrl varchar2(100),
	foodCode varchar2(10)
);

select * from worldCup;

insert into worldCup values('햄버거',1,'./categoryimg/hamburger.jpg','a');
insert into worldCup values('치킨',2,'./categoryimg/chicken.jpg','b');
insert into worldCup values('피자',3,'./categoryimg/pizza.jpg','c');
insert into worldCup values('돈까스',4,'./categoryimg/donkkas.jpg','d');
insert into worldCup values('도시락',5,'./categoryimg/ventto.jpg','e');
insert into worldCup values('고기',6,'./categoryimg/gogi.jpg','f');
insert into worldCup values('가정식백반',7,'./categoryimg/bakvan.jpg','g');
insert into worldCup values('찌게/탕',8,'./categoryimg/jjige.jpg','h');
insert into worldCup values('짜장면',9,'./categoryimg/jjajang.jpg','i');
insert into worldCup values('짬뽕',10,'./categoryimg/jjambbong.jpg','j');
insert into worldCup values('탕수육',11,'./categoryimg/tang.jpg','k');
insert into worldCup values('우동',12,'./categoryimg/udong.jpg','l');
insert into worldCup values('초밥',13,'./categoryimg/susi.jpg','m');
insert into worldCup values('회',14,'./categoryimg/sasimi.jpg','n');
insert into worldCup values('덮밥',15,'./categoryimg/dubbab.jpg','o');
insert into worldCup values('해산물',16,'./categoryimg/haesan.jpg','p');