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


insert into reader values('201400651','李勇','男',19,'计算机141','计算机系','不可借书');
insert into reader values('201400652','刘晨','男',20,'计算机141','计算机系','不可借书');
insert into reader values('201400653','王敏','女',20,'计算机141','计算机系','不可借书');
insert into reader values('201400654','张立','男',22,'计算机141','计算机系','不可借书');

insert into reader values('201400655','吴宾','女',21,'计算机142','计算机系','可以借书');
insert into reader values('201400656','张海','男',20,'计算机142','计算机系','可以借书');
insert into reader values('201400657','钱小平','女',18,'计算机142','计算机系','可以借书');
insert into reader values('201400658','王大力','男',19,'计算机141','计算机系','可以借书');
insert into reader values('201400659','张健','男',19,'计算机141','计算机系','可以借书');
insert into reader values('201400660','张齐朴','男',19,'计算机143','计算机系','可以借书');
insert into reader values('201400661','何世焱','男',19,'计算机141','计算机系','可以借书');
insert into reader values('201400662','乔勇','男',19,'计算机143','计算机系','可以借书');
insert into reader values('201400663','余天璞','男',19,'计算机142','计算机系','可以借书');
insert into reader values('201400664','郑德祥','男',19,'计算机143','计算机系','可以借书');
insert into reader values('201400666','杜达林','男',19,'计算机142','计算机系','可以借书');
insert into reader values('201400667','方科','男',19,'计算机141','计算机系','可以借书');
insert into reader values('201400669','蔡基利','男',19,'自动化141','自动化系','可以借书');
insert into reader values('201400671','刘大伟','男',19,'软件141','计算机系','可以借书');
insert into reader values('201400672','杨丽','女',19,'外语142','外语系','可以借书');
insert into reader values('201400674','李四','男',21,'计算机141','计算机系','可以借书');

insert into reader values('201400665','沈忱','男',19,'计算机141','计算机系','可以借书');
insert into reader values('201400668','崔昌瑞','男',19,'计算机143','计算机系','可以借书');
insert into reader values('201400670','陈礼锐','男',19,'软件141','计算机系','可以借书');
insert into reader values('201400673','肖克','男',19,'计算机141','计算机系','可以借书');

select * from reader;
COMMIT;

