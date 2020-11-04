create database DB3;
--学生表创建
create table Student (
	Sno char(7) primary key,
	Sname char(10) not null,
	Ssex char(2) check(Ssex='男' or Ssex='女'),
	Sage smallint check(Sage>=15 and Sage<=45),
	Sdept char(20) default '计算机系'
);
--课程信息表创建
create table Course (
	Cno char(10) primary key,
	Cname char(20) not null,
	Ccredit int check(Ccredit>0),
	Semster int check(Semster>0)
);
--学生选课表创建
create table SC (
	Sno char(7) foreign key references Student(Sno),
	Cno char(10) foreign key references Course(Cno),
	Grade int check(Grade>=0 and Grade<=100),
	XKLB char(4) null,
);

--学生表数据插入
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
--数据操纵
update Student set Sdept='信息系' where Sname='王敏';
update Course set Cname='数据库原理与应用' where Cname='数据库基础';
delete from SC where Grade<40;