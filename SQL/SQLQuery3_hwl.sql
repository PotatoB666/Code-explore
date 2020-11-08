--ʵ��2�ı�
create database BookDB;
--�����
create table BookClass (
	classNo char(3) constraint PK_BookClass_classNO primary key,
	className char(20) not null constraint UK_BookClass_className unique
);
--ͼ���
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
--���߱�
create table Reader (
	readerNO char(8) constraint PK_Reader_readerNO primary key,
	readerName char(8),
	sex char(2) constraint CK_Reader_sex check(sex='F' or sex='M'),
	identitycard char(18) not null constraint UK_Reader_identitycard unique,
	workUnit char(50),
	borrowCount smallint not null
);
--���ı�
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
--��������
insert into BookClass values ('001','������');
insert into BookClass values ('002','������');
insert into BookClass values ('003','�������');
--ͼ������
insert into Book values ('B200101001','001','���ξ���ѧ','����','�й������ѧ������','P1991010100010001',31.8,'19910101','19950111',100);
insert into Book values ('B200201001','002','��ѧӢ��','֣����','�����ѧ���о�������','P1992010100010001',35.2,'19920101','19960111',130);
insert into Book values ('B200301001','003','���ݿ�ϵͳԭ��','�⾩��','�廪��ѧ������','P1993010100010001',58.2,'19930101','19950111',160);
insert into Book values ('B200101002','001','΢�۾���ѧ','����','�ߵȽ���������','P1991010100010002',41.8,'19910102','19950112','110');
insert into Book values ('B200101003','001','��۾���ѧ','Ԭ��ʥ','�й��ƾ����ó�����','P1991010100010003',51.8,'19910103','19950113',120);
insert into Book values ('B200201002','002','����Ӣ��','������','�Ϻ�����ѧԺ������','P1992010100010002',45.2,'19920102','19960112',140);
insert into Book values ('B200201003','002','����Ӣ��2','�����','������ͨ��ѧ������','P1992010100010003',55.2,'19920103','19960113',150);
insert into Book values ('B200301002','003','��������','����','�㽭��ѧ������','P1993010100010002',38.2,'19930102','19950112',170);
insert into Book values ('B200301003','003','�˹�����','������','���ӹ�ҵ������','P1993010100010003',43.2,'19930103','19950113',180);
insert into Book values ('B200301004','003','�㷨��������','�»���','��ѧ������','P1993010100010004',58.2,'19930104','19950114',190);
--���߱����
insert into Reader values ('R2005001','��С��','F','412723199001014000','ͳһ�ɷ����޹�˾',0);
insert into Reader values ('R2006001','����','F','412723199003014000','���Ϲɷ����޹�˾',0);
insert into Reader values ('R2007001','�ߴ���','M','412723199005014000','�鶼�ɷ����޹�˾',0);
insert into Reader values ('R2008001','�»�','M','412723199111014000','�ϲ��е������ƹ�˾',0);
insert into Reader values ('R2009001','����','F','412723199208014000','��ʿ���Ƽ�����',0);
insert into Reader values ('R2005002','��¶','F','412723199002014000','��¡�ɷ����޹�˾',0);
insert into Reader values ('R2006002','����ǿ','M','412723199004014000','���´�ɷ����޹�˾',0);
insert into Reader values ('R2007002','����÷','F','412723199112014000','���缼��������˾',0);
insert into Reader values ('R2008002','����','M','412723199110014000','�Ϻ������о���',0);
insert into Reader values ('R2009002','����ƽ','M','412723199209014000','����Ԫ���޹�˾',0);
--���ı����
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

-- 3ʵ���Ĵ��������ݲ���
create database DB3;
--ѧ������
create table Student (
	Sno char(7) primary key,
	Sname char(10) not null,
	Ssex char(2) check(Ssex='��' or Ssex='Ů'),
	Sage smallint check(Sage>=15 and Sage<=45),
	Sdept char(20) default '�����ϵ'
);
--�γ���Ϣ����
create table Course (
	Cno char(10) primary key,
	Cname char(20) not null,
	Ccredit int check(Ccredit>0),
	Semster int check(Semster>0)
);
--ѧ��ѡ�α���
create table SC (
	Sno char(7) foreign key references Student(Sno),
	Cno char(10) foreign key references Course(Cno),
	Grade int check(Grade>=0 and Grade<=100),
	XKLB char(4) null,
	primary key(Sno,Cno)
);

--ѧ�������ݲ���
insert into Student values ('9512101','����','��',19,'�����ϵ');
insert into Student values ('9512102','����','��',20,'�����ϵ');
insert into Student values ('9512103','����','Ů',20,'�����ϵ');
insert into Student values ('9521101','����','��',22,'��Ϣϵ');
insert into Student values ('9521102','���','Ů',21,'��Ϣϵ');
insert into Student values ('9521103','�ź�','��',20,'��Ϣϵ');
insert into Student values ('9531101','ǮСƽ','Ů',18,'��ѧϵ');
insert into Student values ('9531102','������','��',19,'��ѧϵ');
--�γ̱����
insert into Course values ('C01','������Ļ�����',3,1);
insert into Course values ('C02','VB',2,3);
insert into Course values ('C03','���������',4,7);
insert into Course values ('C04','���ݿ����',6,6);
insert into Course values ('C05','�ߵ���ѧ',8,2);
insert into Course values ('C06','���ݽṹ',5,4);
--ѡ�α����
insert into SC values ('9512101','C01',90,'����');
insert into SC values ('9512101','C02',86,'ѡ��');
insert into SC values ('9512101','C06',62,'����');
insert into SC values ('9512102','C02',78,'ѡ��');
insert into SC values ('9512102','C04',66,'����');
insert into SC values ('9512102','C01',82,'ѡ��');
insert into SC values ('9512102','C05',92,'����');
insert into SC values ('9512102','C06',50,'����');
insert into SC values ('9512103','C02',68,'ѡ��');
insert into SC values ('9512103','C06',62,'����');
insert into SC values ('9531101','C01',80,'ѡ��');
insert into SC values ('9531101','C05',95,'����');
insert into SC values ('9531102','C05',85,'����');
--���ݲ���
update Student set Sdept='��Ϣϵ' where Sname='����';
update Course set Cname='���ݿ�ԭ����Ӧ��' where Cname='���ݿ����';
delete from SC where Grade<40;

--��ѯ

-- rj5
-- 1
select Reader.readerName,Borrow.borrowDate,Borrow.returnDate from Borrow,Reader where Reader.readerNO=Borrow.readerNO and bookNO='B200101002';
-- 2
select Borrow.bookNO,Book.bookName,Borrow.borrowDate,Borrow.returnDate 
from Borrow,Book,Reader 
where Borrow.bookNO=Book.bookNO and Borrow.readerNO=Reader.readerNO and Reader.readerName='����÷';
-- 3
select Reader.readerNO,Reader.readerName,Book.bookName,Borrow.borrowDate,Borrow.returnDate 
from Borrow,Book,Reader 
where Borrow.bookNO=Book.bookNO and Reader.readerNO=Borrow.readerNO and Borrow.returnDate is null;
-- 4
select Reader.readerNO,Reader.readerName,Book.bookName,Borrow.borrowDate,Borrow.returnDate 
from Reader,Book,Borrow 
where Reader.readerNO=Borrow.readerNO and Book.bookNO=Borrow.bookNO and Book.publishingName='�廪��ѧ������';
-- 5
select Borrow.readerNO,Reader.readerName,Book.bookNO,Book.bookName 
from Borrow,Reader,Book 
where Borrow.bookNO=Book.bookNO and Borrow.readerNO=Reader.readerNO and Borrow.borrowDate between '20100101' and '20111231';
-- 6
select 'ͼ������'=Book.classNO,'��߼۸�'=max(Book.price),'ƽ���۸�'=avg(Book.price) 
from Book 
group by Book.classNO 
order by max(Book.price) desc;
-- 7
select '�������'=sum(Book.shopNum) 
from Book 
group by Book.classNO 
having Book.classNO<'009';
-- 8
select '���߱��'=t.rn,'��������'=t.rm,'����ͼ���ܼ�'=sum(t.bp)
from (
select 'rn'=Reader.readerNO,'rm'=Reader.readerName,'bp'=Book.price 
from Reader,Book,Borrow 
where Reader.readerNO=Borrow.readerNO and Book.bookNO=Borrow.bookNO
) as t 
group by t.rn,t.rm
having sum(t.bp)>100
-- 9
select Reader.readerName,Reader.workUnit 
from Reader 
where Reader.readerNO not in(
select distinct Borrow.readerNO 
from Borrow
);
-- 10
select Reader.readerNO,Reader.readerName,Book.bookName,Borrow.borrowDate 
from Reader,Book,Borrow 
where Reader.readerNO=Borrow.readerNO and Book.bookNO=Borrow.bookNO and Reader.readerNO not in
(
select distinct Borrow.readerNO 
from Borrow
where Borrow.bookNO LIKE 'B2001*'
);