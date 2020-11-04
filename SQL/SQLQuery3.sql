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