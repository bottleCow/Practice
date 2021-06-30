drop table board;

-- 회원게시판에서는 작성자(대신 회원 id또는 이름), 암호, 이메일, ip가 필요 없음
create table board (
	num number primary key, -- key 번호
	writer varchar2(20) not null, -- 작성자
	subject varchar2(50) not null, -- 제목
	content varchar2(500) not null, -- 본문
	email varchar2(30) , -- 이메일
	readcount number default 0, -- 읽은 횟수
	password varchar2(12) not null, -- 암호
	ref number not null, -- 답변글끼리 그룹
	re_step number not null, -- ref내의 순서
	re_level number not null, -- 들여쓰기
	ip varchar2(20) not null, -- 작성자 ip
	reg_date date not null, -- 작성일
	del char(1) default 'n'
);


--답변글 테이블 생성
create table replyBoard (
	rno number primary key,
	bno number not null references board(num),
	replytext varchar2(500) not null,
	replyer varchar2(50) not null,
	regdate date not null,
	updatedate date not null,
	del char(1)
);

--board에서 마지막 번호 찾기
select * from board order by num desc;

--답변글 입력                                   (답변글 순서, board에서의 번호, 내용, 답변 작성자, 날짜, 날짜, 삭제여부)
insert into replyboard values(5,11,'raining', '게시11', sysdate,sysdate,'n'); --작성자 이름과 일치할 경우
insert into replyboard values(7,11,'raining22', '게시11', sysdate,sysdate,'n'); --작성자 이름과 일치할 경우
insert into replyboard values(6,11,'foggy', 'dontknow', sysdate,sysdate,'n'); --작성자 이름과 다를 경우

select * from replyBoard;