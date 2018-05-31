

select * from all_tables where owner='HR';

create table Sadmin
 ( 
 
 id varchar2(20),
 S_password varchar2(20)
 
 )
 select * from Sadmin;
 drop table staff;
create table staff 
(
ST_id  varchar2(20) primary key ,
ST_name varchar2(20),
ST_sex varchar2(20),
ST_age int ,
ST_power int,
ST_password varchar2(20)
)
ALTER TABLE STAFF ADD ST_PASSWORD VARCHAR2(20);
alter table staff add ST_part  varchar2(20);
insert into staff values('111','tom','man','22',9 ,'123','������');

drop table Uniquetest;
create table Uniquetest
(
Unid int primary key ,
Unname varchar2(50) unique 
) 
select * from Uniquetest;
insert into Uniquetest values(1,'aa');
insert into Uniquetest values(2,'bb');
insert into Uniquetest values(3,'aa');

drop table offer;
create table offer
(
O_name varchar2(50)primary key ,
O_ad varchar2(50),
O_like char ,
O_phone char(11),
O_person varchar2(20)
)
alter table offer modify (O_like varchar2(20));
alter table offer add O_state int;
select * from offer for update;
select * from offer where  O_state=1;
select * from staff;

drop  table warehouse;

create table warehouse
(
W_id varchar2(20)primary key ,
W_ad varchar2(50),
W_size int,
W_phone char(11),
W_person varchar2(20),
W_space int,
W_state int 
)
--foreign key (W_person) references staff(ST_name)
)
create table part
(
P_id varchar2(20) primary key ,
P_name varchar2(20),
P_sp char,
P_price int,
P_offer varchar2(20)references offer(O_name),
P_time int ,
P_state int 
)
drop table part 
drop table store

create table mstore 
(
S_id varchar2(20) primary key,
S_P_id varchar2(20) references part (P_id),
S_W_id varchar2(20) references warehouse(W_id),
S_num int,
S_state int 
)

insert into mstore values('002','002','002',50,1); 
insert into mstore values('001','002','002',500,1);
select * from mstore where S_id='002'
select * from mstore where S_state=1 and S_W_id='002' and S_P_id='008';
select * from mstore where S_state=1 and S_W_id=? and S_P_id=?
select * from mstore  for update 
select * from O_House;

update mstore set S_num=100 where S_W_id ='002' and S_state=1 AND S_P_id='008';
create table I_house
(
I_Id varchar2(20) primary key,
I_W_id varchar2(20)references warehouse(W_id),
I_P_id varchar2(20)references part(P_id),
I_time date,
I_person varchar2(20),
I_price  int,
I_count int ,
I_sum int
)

drop table I_house
drop table O_house

create table O_house
(
O_Id varchar2(20)primary key,
O_W_id varchar2(20)references warehouse(W_id),
O_P_id varchar2(20)references part(P_id),
O_time date,
O_person varchar2(20),
O_price  int ,
O_count int, 
O_sum int
)

-- �������ݲ���
insert into Sadmin values('admin','123');select * from Sadmin;
delete from staff where st_id='003';
insert into staff(ST_id,St_Password) values('001','123');

insert into staff values('001','tom','man','22',9 ,'123');
insert into staff values('002','mary','man','23',9,'123');
insert into staff values('003','mike','man','23',9,'123');
insert into staff values('004','jury','women','22',9,'123');
insert into staff values('005','mile','women','25',9,'123');
insert into staff values('006','hibi','man','25',9,'123');
select * from staff FOR UPDATE;
delete  from  staff where ST_id='005'


insert into offer values('����','ʮ��','A','15926170536','tom');
insert into offer values('dongfeng','shiyan','A','15926170536','mike');
select * from offer;
update offer set O_ad='shiyan',O_like='great' ,O_phone='15926170536',O_person='yy' where O_name='xiapu';

insert into warehouse values('001','shiyan',300,'15926170536','tom',300,1);
select * from staff;
select * from warehouse;
insert into part values('001','����','A','258','����',10);
insert into part values('002','chelun','A','258','dongfeng',10,1);
insert into part values('004','chelun2','A','258','dongfeng',10,1);
insert into part values('006','chelun3','A','258','dongfeng',10,1);
insert into part values('007','chelun4','A','258','dongfeng',10,1);
insert into part values('008','chelun5','A','258','dongfeng',10,1);
insert into part values('009','chelun6','A','258','dongfeng',10);
insert into part values('010','chelun7','A','258','dongfeng',10);
insert into part values('011','chelun8','A','258','dongfeng',10);
insert into part values('012','chelun9','A','258','dongfeng',10);
insert into part values('013','chelun10','A','258','dongfeng',10);
insert into part values('014','chelun11','A','258','dongfeng',10);
insert into part values('015','chelun12','A','258','dongfeng',10);
insert into part values('016','chelun13','A','258','dongfeng',10);


delete from offer where o_name = '����'

select * from part for update;
select P_id from part;
select W_id from warehouse;
select * from store;
insert into store values('001','001','001',20); 
select * from Mstore;

insert into I_house values('002','002','002',to_date
('2005-01-01 13:14:20','yyyy-MM-dd HH24:mi:ss'),'mike',20,10,200);

select * from I_house;
select * from warehouse where w_id='002'and W_state=1;


insert into O_house values('001','001','001',to_date('2013-08-21','YYYY-MM-DD'),'tom',20,10);

select * from O_house;

select * from part where P_offer ='dongfeng';
select * from part where P_sp ='A';

select * from part for update;

select * from part where P_state=1;

--UPDATE ������ SET ������ = ��ֵ WHERE ������ = ĳֵ
update part set P_sp='E', P_time='20' where P_id='003';
update part set P_name=?,P_sp=? ,P_price=?,P_offer=?,P_time=? where P_id=? ;
commit;



select * from part
delete from part where p_id = '001';

--�������Լ��

alter table part disable constraint SYS_C004069;
alter table store disable constraint SYS_C004070;
alter table I_house disable constraint SYS_C004073;
alter table O_house disable constraint SYS_C004075;

--�ָ����Լ��

alter table part enable constraint SYS_C004069;
commit
alter table store enable constraint SYS_C004070;
alter table I_house enable constraint SYS_C004073;
alter table O_house enable constraint SYS_C004075;
rollback 
delete from part where P_id='001';

select constraint_type, table_name, status 
from user_constraints where table_name = 'PART';
select constraint_type, table_name, status from 
user_constraints where table_name = 'STORE';
select constraint_type, table_name, status from 
user_constraints where table_name = 'I_HOUSE';
select constraint_type, table_name, status from
 user_constraints where table_name = 'O_HOUSE';


select * from staff where ST_id='001';
select * from offer;
select * from staff 
select * from part;
select * from warehouse for update; 
select * from Mstore  where S_W_id='002'and s_state=1;
select P_price from part where P_id='002'and P_state=1
select * from I_house ;
select * from Mstore where S_W_id='002'and S_state=1  for update;
select * from Mstore where s_p_id ='007'and s_w_id='001'and s_state=1; 
select * from mstore where S_P_id='' and S_W_Id=? and S_state=1
select * from O_house ;
select P_id  from  part where P_state=1;
select W_id from warehouse where W_state=1
select * from warehouse where W_id='002' and W_state=1 for update;

create table testchart
(
tname varchar2(20),
tvalue int
);

select * from testchart;
insert into testchart values('����',3000);
insert into testchart values('��Ϊ',3500);
insert into testchart values('С��',2000);
insert into testchart values('����',1500);
insert into testchart values('ƻ��',6000);
insert into testchart values('OPPO',2500);

)
