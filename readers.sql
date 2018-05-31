DROP TABLE reader;

CREATE TABLE reader(    
  readerid VARCHAR2(9) PRIMARY  KEY not null,
  readername VARCHAR2(18) not null,
  readersex VARCHAR2(3) not null,
  readerage SMALLINT,
  readerclass VARCHAR2(50),
  readerdept VARCHAR2(50),
  readerpermitted varchar(12)
);


insert into reader values('201400651','����','��',19,'�����141','�����ϵ','���ɽ���');
insert into reader values('201400652','����','��',20,'�����141','�����ϵ','���ɽ���');
insert into reader values('201400653','����','Ů',20,'�����141','�����ϵ','���ɽ���');
insert into reader values('201400654','����','��',22,'�����141','�����ϵ','���ɽ���');

insert into reader values('201400655','���','Ů',21,'�����142','�����ϵ','���Խ���');
insert into reader values('201400656','�ź�','��',20,'�����142','�����ϵ','���Խ���');
insert into reader values('201400657','ǮСƽ','Ů',18,'�����142','�����ϵ','���Խ���');
insert into reader values('201400658','������','��',19,'�����141','�����ϵ','���Խ���');
insert into reader values('201400659','�Ž�','��',19,'�����141','�����ϵ','���Խ���');
insert into reader values('201400660','������','��',19,'�����143','�����ϵ','���Խ���');
insert into reader values('201400661','������','��',19,'�����141','�����ϵ','���Խ���');
insert into reader values('201400662','����','��',19,'�����143','�����ϵ','���Խ���');
insert into reader values('201400663','�����','��',19,'�����142','�����ϵ','���Խ���');
insert into reader values('201400664','֣����','��',19,'�����143','�����ϵ','���Խ���');
insert into reader values('201400666','�Ŵ���','��',19,'�����142','�����ϵ','���Խ���');
insert into reader values('201400667','����','��',19,'�����141','�����ϵ','���Խ���');
insert into reader values('201400669','�̻���','��',19,'�Զ���141','�Զ���ϵ','���Խ���');
insert into reader values('201400671','����ΰ','��',19,'���141','�����ϵ','���Խ���');
insert into reader values('201400672','����','Ů',19,'����142','����ϵ','���Խ���');
insert into reader values('201400674','����','��',21,'�����141','�����ϵ','���Խ���');

insert into reader values('201400665','���','��',19,'�����141','�����ϵ','���Խ���');
insert into reader values('201400668','�޲���','��',19,'�����143','�����ϵ','���Խ���');
insert into reader values('201400670','������','��',19,'���141','�����ϵ','���Խ���');
insert into reader values('201400673','Ф��','��',19,'�����141','�����ϵ','���Խ���');

select * from reader;
COMMIT;

