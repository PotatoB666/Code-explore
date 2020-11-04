--分类表
create table BookClass (
	classNo char(3) constraint PK_BookClass_classNO primary key,
	className char(20) not null constraint UK_BookClass_className unique
);
--图书表
create table Book (
	bookNO char(10) constraint PK_Book_bookNO primary key,
	classNO char(3) constraint FK_Book_classNO foreign key references BookClass(classNO),
	bookName char(40) not null,
	authorName char(8),
	publishingName char(20),
	publishingNO char(17) constraint UK_Book_publishingNO unique,
	price decimal(7,2),
	publishingDate date,
	shopDate date,
	shopNum int
);
--读者表
create table Reader (
	readerNO char(8) constraint PK_Reader_readerNO primary key,
	readerName char(8),
	sex char(2) constraint CK_Reader_sex check(sex='F' or sex='M'),
	identitycard char(18) not null constraint UK_Reader_identitycard unique,
	workUnit char(50),
	borrowCount smallint not null
);
--借阅表
create table Borrow (
	readerNO char(8),
	bookNO char(10),
	borrowDate date,
	shouldDate date,
	returnDate date,
	constraint PK_Borrow_readerNO_bookNO_borrowDate primary key(readerNO,bookNO,borrowDate),
	constraint FK_Borrow_readerNO foreign key(readerNO) references Reader(readerNO),
	constraint FK_Borrow_bookNO foreign key(bookNO) references Book(bookNO),
);
--分类表插入
insert into BookClass values ('001','经济类');
insert into BookClass values ('002','外语类');
insert into BookClass values ('003','计算机类');
--图书表插入
insert into Book values ('B200101001','001','政治经济学','宋涛','中国人民大学出版社','P1991010100010001',31.8,'19910101','19950111',100);
insert into Book values ('B200201001','002','大学英语','郑树棠','外语教学与研究出版社','P1992010100010001',35.2,'19920101','19960111',130);
insert into Book values ('B200301001','003','数据库系统原理','吴京慧','清华大学出版社','P1993010100010001',58.2,'19930101','19950111',160);
insert into Book values ('B200101002','001','微观经济学','张蕊','高等教育出版社','P1991010100010002',41.8,'19910102','19950112','110');
insert into Book values ('B200101003','001','宏观经济学','袁明圣','中国财经经济出版社','P1991010100010003',51.8,'19910103','19950113',120);
insert into Book values ('B200201002','002','商务英语','马升烨','上海外语学院出版社','P1992010100010002',45.2,'19920102','19960112',140);
insert into Book values ('B200201003','002','商务英语2','江宇佳','西安交通大学出版社','P1992010100010003',55.2,'19920103','19960113',150);
insert into Book values ('B200301002','003','组网技术','万征','浙江大学出版社','P1993010100010002',38.2,'19930102','19950112',170);
insert into Book values ('B200301003','003','人工智能','费翔林','电子工业出版社','P1993010100010003',43.2,'19930103','19950113',180);
insert into Book values ('B200301004','003','算法设计与分析','陈慧南','科学出版社','P1993010100010004',58.2,'19930104','19950114',190);
--读者表插入
insert into Reader values ('R2005001','张小娟','F','412723199001014000','统一股份有限公司',0);
insert into Reader values ('R2006001','刘凤','F','412723199003014000','联合股份有限公司',0);
insert into Reader values ('R2007001','高代鹏','M','412723199005014000','洪都股份有限公司',0);
insert into Reader values ('R2008001','陈辉','M','412723199111014000','南昌市电脑研制公司',0);
insert into Reader values ('R2009001','李虹冰','F','412723199208014000','富士康科技集团',0);
insert into Reader values ('R2005002','张露','F','412723199002014000','兴隆股份有限公司',0);
insert into Reader values ('R2006002','喻自强','M','412723199004014000','万事达股份有限公司',0);
insert into Reader values ('R2007002','张晓梅','F','412723199112014000','世界技术开发公司',0);
insert into Reader values ('R2008002','张良','M','412723199110014000','上海生物研究室',0);
insert into Reader values ('R2009002','韩福平','M','412723199209014000','合生元有限公司',0);
--借阅表插入
insert into Borrow values ('R2005001','B200101001','20110901','20111001',null);
insert into Borrow values ('R2006001','B200101001','20110907','20111007','20111005');
insert into Borrow values ('R2007001','B200201001','20110913','20111013','20111010');
insert into Borrow values ('R2008001','B200301001','20110915','20111015','20111013');
insert into Borrow values ('R2009001','B200301001','20110918','20111018',null);
insert into Borrow values ('R2005001','B200101002','20110902','20111002','20111001');
insert into Borrow values ('R2005001','B200101003','20110903','20111003',null);
insert into Borrow values ('R2005002','B200101001','20110904','20111004','20111003');
insert into Borrow values ('R2005002','B200101002','20110905','20111005',null);
insert into Borrow values ('R2005002','B200101003','20110906','20111006','20111008');
insert into Borrow values ('R2006001','B200101002','20110908','20111008','20111006');
insert into Borrow values ('R2006001','B200101003','20110909','20111009','20111012');
insert into Borrow values ('R2009002','B200201001','20110910','20111010','20111008');
insert into Borrow values ('R2006002','B200201002','20110911','20111011','20111008');
insert into Borrow values ('R2006002','B200201003','20110912','20111012','20111008');
insert into Borrow values ('R2007001','B200201002','20110914','20111014',null);
insert into Borrow values ('R2007001','B200201003','20110915','20111015','20111010');
insert into Borrow values ('R2009002','B200201001','20110916','20111016','20111014');
insert into Borrow values ('R2007002','B200201002','20110917','20111017','20111014');
insert into Borrow values ('R2007002','B200201003','20110917','20111017','20111014');
--查询
select readerName,workUnit,identitycard from Reader where SUBSTRING(identitycard,7,8)>='19910101' and substring(identitycard,7,8)<='19911231';
select readerNO,readerName,sex from Reader where workUnit='富士康科技集团';
select * from Book where CHARINDEX('数据库',bookName)!=0;
select bookNO,shopDate from Book where authorName='袁明圣' and price >= 40.00;
select bookNO,publishingDate,shopDate,bookName from Book where shopDate>='1995-01-01' and shopDate<='1996-12-31' order by shopDate asc;
