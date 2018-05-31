DROP TABLE BOOK;

CREATE TABLE BOOK(
       bookno varchar2(8) primary key not null,
       bookname varchar2(50),
       author varchar2(50),
       publish varchar2(50),
       bookisbn varchar2(20), 
       bookprices number(5,2),
       bookstatus varchar2(9)      
); 

insert into book values('20170101','编译原理教程','刘铭','电子工业出版社','7121016814',69.00,'可借');

insert into book values('20170102','新视野大学英语读写教程','郑树棠','外语教学与研究出版社','7121018965',72.00,'非可借');

insert into book values('20170103','软件工程','张海藩','清华大学出版社','5698321487',102.65,'可借');

insert into book values('20170104','计算机网络','谢希仁','电子工业出版社','7121011237',39.00,'可借');

insert into book values('20170105','java程序设计','张桂株','北京邮电大学出版社','4569823176',62.00,'可借');

insert into book values('20170106','微机原理与接口技术','楼顺天','科学出版社','2316542165',49.00,'非可借');

insert into book values('20170107','计算机组成原理','白中英','科学出版社','2316549830',39.00,'可借');

insert into book values('20170110','编译原理教程','刘铭','电子工业出版社','7121016814',69.00,'非可借');

insert into book values('20170111','编译原理教程','刘铭','电子工业出版社','7121016814',69.00,'可借');

insert into book values('20170112','编译原理教程','刘铭','电子工业出版社','7121016814',69.00,'非可借');

insert into book values('20170113','编译原理教程','刘铭','电子工业出版社','7121016814',69.00,'可借');

insert into book values('20170114','编译原理教程','刘铭','电子工业出版社','7121016814',69.00,'非可借');



update book set bookname  = '软件工程' where bookno = 20170103;

commit;

select * from book;
