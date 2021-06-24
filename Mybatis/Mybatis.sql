create table member4 (
	id varchar2(20) primary key,
	email varchar2(30),
	password varchar2(30),
	name varchar2(30),
	fileName varchar2(50),
	del char(1) default 'n',
	regdate date
);

-- 하나의 Id에 사진이 여러개 저장되는 table 생성
create table memberPhoto (
	num number(10) primary key,
	id varchar2(20) references member4(id), --foreign key
	fileName varchar2(50)
);

-- memberPhoto primary key에 자동으로 1씩 증가
create sequence memberPhoto_seq;

select * from member4;
select * from memberPhoto;