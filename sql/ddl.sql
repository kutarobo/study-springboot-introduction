-- 회원 테이블 생성 및 데이터 추가
drop table if exists member CASCADE;

create table member (
    id  bigint generated by default as identity,
    name varchar(255),
    primary key (id)
);

insert into member (name) values ('spring')
insert into member (name) values ('spring2')