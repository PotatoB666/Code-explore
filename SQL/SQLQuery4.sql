--1 ѧ��ѡ����Ϣ��ͼ
create view StudentView
as
select Student.Sno,Student.Sname,Course.Cno,Course.Cname from Course, SC, Student
where Course.Cno=SC.Cno and Student.Sno=SC.Sno;

select * from StudentView;

--2 ��ѧ��������ת���ɳ�����ݳ��ָ��û�
create view StudentAgeView
as
select Student.Sno,Student.Sname,(year(getdate())-Student.Sage) '�������'
from
Student;

select * from StudentAgeView;
--3 ��Ӣ������ת������������
create view StudentChineseColumn
as
select Student.Sno 'ѧ��',
       Student.Sname '����',
	   Student.Ssex '�Ա�',
	   Student.Sage 'ѧ������',
	   Student.Sdept '��������'
from 
Student;

select * from StudentChineseColumn;
--4 ���ڱ��еĻ��������ṩ��ȫ����
create view StudentSecretView
as
select Student.Sno 'ѧ��',Student.Sname '����',Student.Ssex '�Ա�',Student.Sdept '����ϵ'
from Student;

select * from StudentSecretView;
--5 ��ѯѧ��ѡ�޿γ̳ɼ����ڸÿγ�ƽ���ֵ�ѡ����Ϣ
create view CourseAvgScore
as
(select Cno,avg(Grade) 'ƽ����'
from
SC
group by Cno);

select SC.* from CourseAvgScore,SC
where SC.Cno=CourseAvgScore.Cno and SC.Grade>CourseAvgScore.ƽ����;
