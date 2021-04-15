--1 学生选课信息视图
create view StudentView
as
select Student.Sno,Student.Sname,Course.Cno,Course.Cname from Course, SC, Student
where Course.Cno=SC.Cno and Student.Sno=SC.Sno;

select * from StudentView;

--2 将学生的年龄转换成出生年份呈现给用户
create view StudentAgeView
as
select Student.Sno,Student.Sname,(year(getdate())-Student.Sage) '出生年份'
from
Student;

select * from StudentAgeView;
--3 将英文列名转换成中文列名
create view StudentChineseColumn
as
select Student.Sno '学号',
       Student.Sname '姓名',
	   Student.Ssex '性别',
	   Student.Sage '学生年龄',
	   Student.Sdept '所属部门'
from 
Student;

select * from StudentChineseColumn;
--4 对于表中的机密数据提供安全保护
create view StudentSecretView
as
select Student.Sno '学号',Student.Sname '姓名',Student.Ssex '性别',Student.Sdept '所属系'
from Student;

select * from StudentSecretView;
--5 查询学生选修课程成绩大于该课程平均分的选课信息
create view CourseAvgScore
as
(select Cno,avg(Grade) '平均分'
from
SC
group by Cno);

select SC.* from CourseAvgScore,SC
where SC.Cno=CourseAvgScore.Cno and SC.Grade>CourseAvgScore.平均分;
