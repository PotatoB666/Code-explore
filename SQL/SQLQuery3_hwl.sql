-- 3实验表的创建和数据操纵
create database DB3;
-------------------------------------------------------------学生表创建
create table Student (
	Sno char(7) primary key,
	Sname char(10) not null,
	Ssex char(2) check(Ssex='男' or Ssex='女'),
	Sage smallint check(Sage>=15 and Sage<=45),
	Sdept char(20) default '计算机系'
);
---------------------------------------------------------课程信息表创建
create table Course (
	Cno char(10) primary key,
	Cname char(20) not null,
	Ccredit int check(Ccredit>0),
	Semster int check(Semster>0)
);
---------------------------------------------------------学生选课表创建
create table SC (
	Sno char(7) foreign key references Student(Sno),
	Cno char(10) foreign key references Course(Cno),
	Grade int check(Grade>=0 and Grade<=100),
	XKLB char(4) null,
	primary key(Sno,Cno)
);

----------------------------------------------------------学生表数据插入
insert into Student values ('9512101','李勇','男',19,'计算机系');
insert into Student values ('9512102','刘晨','男',20,'计算机系');
insert into Student values ('9512103','王敏','女',20,'计算机系');
insert into Student values ('9521101','张立','男',22,'信息系');
insert into Student values ('9521102','吴宾','女',21,'信息系');
insert into Student values ('9521103','张海','男',20,'信息系');
insert into Student values ('9531101','钱小平','女',18,'数学系');
insert into Student values ('9531102','王大力','男',19,'数学系');
--课程表插入
insert into Course values ('C01','计算机文化基础',3,1);
insert into Course values ('C02','VB',2,3);
insert into Course values ('C03','计算机网络',4,7);
insert into Course values ('C04','数据库基础',6,6);
insert into Course values ('C05','高等数学',8,2);
insert into Course values ('C06','数据结构',5,4);
--选课表插入
insert into SC values ('9512101','C01',90,'必修');
insert into SC values ('9512101','C02',86,'选修');
insert into SC values ('9512101','C06',62,'必修');
insert into SC values ('9512102','C02',78,'选修');
insert into SC values ('9512102','C04',66,'必修');
insert into SC values ('9512102','C01',82,'选修');
insert into SC values ('9512102','C05',92,'必修');
insert into SC values ('9512102','C06',50,'必修');
insert into SC values ('9512103','C02',68,'选修');
insert into SC values ('9512103','C06',62,'必修');
insert into SC values ('9531101','C01',80,'选修');
insert into SC values ('9531101','C05',95,'必修');
insert into SC values ('9531102','C05',85,'必修');
------------------------------------------------------------数据操纵
update Student set Sdept='信息系' where Sname='王敏';
update Course set Cname='数据库原理与应用' where Cname='数据库基础';
delete from SC where Grade<40;

----------------------------------------------------------------查询

-- 1
select Reader.readerName,Borrow.borrowDate,Borrow.returnDate from Borrow,Reader where Reader.readerNO=Borrow.readerNO and bookNO='B200101002';
-- 2
select Borrow.bookNO,Book.bookName,Borrow.borrowDate,Borrow.returnDate 
from Borrow,Book,Reader 
where Borrow.bookNO=Book.bookNO and Borrow.readerNO=Reader.readerNO and Reader.readerName='张晓梅';
-- 3
select Reader.readerNO,Reader.readerName,Book.bookName,Borrow.borrowDate,Borrow.returnDate 
from Borrow,Book,Reader 
where Borrow.bookNO=Book.bookNO and Reader.readerNO=Borrow.readerNO and Borrow.returnDate is null and Reader.workUnit='洪都股份有限公司';
-- 4
select Reader.readerNO,Reader.readerName,Book.bookName,Borrow.borrowDate,Borrow.returnDate 
from Reader,Book,Borrow 
where Reader.readerNO=Borrow.readerNO and Book.bookNO=Borrow.bookNO and Book.publishingName='清华大学出版社';
-- 5
select Borrow.readerNO,Reader.readerName,Book.bookNO,Book.bookName 
from Borrow,Reader,Book 
where Borrow.bookNO=Book.bookNO and Borrow.readerNO=Reader.readerNO and Borrow.borrowDate between '20100101' and '20111231';
-- 6
select '图书分类号'=Book.classNO,'最高价格'=max(Book.price),'平均价格'=avg(Book.price) 
from Book 
group by Book.classNO 
order by max(Book.price) desc;
-- 7
select '入库数量'=sum(Book.shopNum) 
from Book 
group by Book.classNO 
having Book.classNO<'009';
-- 8
select '读者编号'=t.rn,'读者姓名'=t.rm,'所借图书总价'=sum(t.bp)
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
-- 11
select Reader.readerNO,Reader.readerName,Borrow.borrowDate,Book.bookName 
from Reader,Borrow,Book 
where Reader.readerNO=Borrow.readerNO and Borrow.bookNO=Book.bookNO and Book.bookName in ('大学英语','商务英语');
-- 12
select distinct Reader.readerNO,Reader.readerName
from (
	select 'rn'=Borrow.readerNO 
	from Borrow,BookClass,Book 
	where Borrow.bookNO=Book.bookNO and Book.classNO=BookClass.classNo and BookClass.className not in ('经济类')
) as t,Reader 
where Reader.readerNO=t.rn;
-- 13
select Reader.readerNO,Reader.readerName,Reader.workUnit 
from Reader,Borrow 
where Borrow.bookNO in (
	select Borrow.bookNO 
	from Borrow,Reader
	where Borrow.readerNO=Reader.readerNO and Reader.readerName='张晓梅'
);
-- 14
select Reader.readerNO,Reader.readerName,Book.bookName,Borrow.borrowDate 
from Reader,Borrow,Book 
where Reader.readerNO=Borrow.readerNO and Book.bookNO=Borrow.bookNO and Book.classNO='002';
-- 15
select Borrow.readerNO 
from Borrow 
group by Borrow.readerNO 
having count(Borrow.bookNO)>=3 
order by Borrow.readerNO;
-- 16
select Reader.readerNO,Reader.readerName,SUBSTRING(Reader.identitycard,7,6) 
from (
	select top 1 'rn'=t1.readerNO 
	from (
		select 'readerNO'=Borrow.readerNO,'price'=Book.price from Borrow,Book where Borrow.bookNO=Book.bookNO
	)as t1 
	group by t1.readerNO 
	order by sum(t1.price) desc
) as t,Reader 
where t.rn=Reader.readerNO;
-- 17
update Book set Book.price=Book.price+Book.price*0.1 
where Book.classNO in (
	select BookClass.classNo from BookClass 
	where BookClass.className in ('经济类')
);
-- 18
select * from Borrow;
update Borrow set Borrow.returnDate=getdate() 
where Borrow.readerNO+Borrow.bookNO+convert(char(8),Borrow.borrowDate,112) in (
	select Borrow.readerNO+Borrow.bookNO+convert(char(8),Borrow.borrowDate,112) from Borrow,Reader 
	where Borrow.returnDate is null and Borrow.shouldDate < getdate() and Borrow.readerNO=Reader.readerNO and year(getdate()) - year(substring(Reader.identitycard,7,8)) between 25 and 35
);
