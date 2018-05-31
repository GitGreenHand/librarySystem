DROP TABLE borrowinfo;

create table borrowinfo(
       readerid varchar2(9) not null,
       bookno varchar2(8) not null,
       starttime varchar(10) not null,
       endtime varchar(10) not null,
       primary key(readerid, bookno),
       foreign key(readerid) references reader(readerid) on delete cascade,
       foreign key(bookno) references book(bookno) on delete cascade
);

insert into  borrowinfo values ('201400673','20170106','2017-08-15','2017-09-15');
insert into  borrowinfo values ('201400665','20170112','2017-06-21','2017-07-21');
insert into  borrowinfo values ('201400668','20170110','2017-02-21','2017-03-21');
insert into  borrowinfo values ('201400668','20170114','2017-04-05','2017-05-05');
insert into  borrowinfo values ('201400670','20170102','2017-02-11','2017-03-11');

commit;


select * from borrowinfo;
