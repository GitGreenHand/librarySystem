drop table managers;


CREATE TABLE managers(
       managerid  varchar2(5) primary key not NULL,
       managerpwd varchar2(6)
       
);

insert into managers values ('aaaaa','123456');
insert into managers values ('bbbbb','123456');
insert into managers values ('ccccc','123456');
insert into managers values ('ddddd','123456');
insert into managers values ('eeeee','56789');
insert into managers values ('fffff','56789');
insert into managers values ('ggggg','56789');
insert into managers values ('admin','56789');

select * from managers;

commit;
