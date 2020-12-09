GRANT SELECT ON department
TO [王明];
GRANT SELECT ON employee
TO [王明];

GRANT DELETE,SELECT ON department
TO [李勇];
GRANT DELETE,SELECT ON employee
TO [李勇];

CREATE VIEW getINFO
AS 
	SELECT * FROM employee 
	WHERE ename=system_user;

GRANT SELECT ON getINFO TO PUBLIC;

CREATE VIEW getRewarding
AS
	SELECT * FROM 
	(SELECT max(erewarding) '最高工资' FROM employee) as t1,(SELECT avg(erewarding) '平均工资' FROM employee) as t2,
	(SELECT min(erewarding) '最低工资' FROM employee) as t3;

GRANT SELECT,UPDATE(erewarding) ON employee
TO [刘星];
GRANT ALTER ON employee
TO [张新];
GRANT SELECT,DELETE,UPDATE,INSERT ON employee TO [周平] WITH GRANT OPTION;
GRANT SELECT,DELETE,UPDATE,INSERT ON department TO [周平] WITH GRANT OPTION;

GRANT SELECT ON getRewarding TO [张兰];