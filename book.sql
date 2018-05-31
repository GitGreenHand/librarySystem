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

insert into book values('20170101','����ԭ��̳�','����','���ӹ�ҵ������','7121016814',69.00,'�ɽ�');

insert into book values('20170102','����Ұ��ѧӢ���д�̳�','֣����','�����ѧ���о�������','7121018965',72.00,'�ǿɽ�');

insert into book values('20170103','�������','�ź���','�廪��ѧ������','5698321487',102.65,'�ɽ�');

insert into book values('20170104','���������','лϣ��','���ӹ�ҵ������','7121011237',39.00,'�ɽ�');

insert into book values('20170105','java�������','�Ź���','�����ʵ��ѧ������','4569823176',62.00,'�ɽ�');

insert into book values('20170106','΢��ԭ����ӿڼ���','¥˳��','��ѧ������','2316542165',49.00,'�ǿɽ�');

insert into book values('20170107','��������ԭ��','����Ӣ','��ѧ������','2316549830',39.00,'�ɽ�');

insert into book values('20170110','����ԭ��̳�','����','���ӹ�ҵ������','7121016814',69.00,'�ǿɽ�');

insert into book values('20170111','����ԭ��̳�','����','���ӹ�ҵ������','7121016814',69.00,'�ɽ�');

insert into book values('20170112','����ԭ��̳�','����','���ӹ�ҵ������','7121016814',69.00,'�ǿɽ�');

insert into book values('20170113','����ԭ��̳�','����','���ӹ�ҵ������','7121016814',69.00,'�ɽ�');

insert into book values('20170114','����ԭ��̳�','����','���ӹ�ҵ������','7121016814',69.00,'�ǿɽ�');



update book set bookname  = '�������' where bookno = 20170103;

commit;

select * from book;
