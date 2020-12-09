GRANT SELECT ON department
TO [����];
GRANT SELECT ON employee
TO [����];

GRANT DELETE,SELECT ON department
TO [����];
GRANT DELETE,SELECT ON employee
TO [����];

CREATE VIEW getINFO
AS 
	SELECT * FROM employee 
	WHERE ename=system_user;

GRANT SELECT ON getINFO TO PUBLIC;

CREATE VIEW getRewarding
AS
	SELECT * FROM 
	(SELECT max(erewarding) '��߹���' FROM employee) as t1,(SELECT avg(erewarding) 'ƽ������' FROM employee) as t2,
	(SELECT min(erewarding) '��͹���' FROM employee) as t3;

GRANT SELECT,UPDATE(erewarding) ON employee
TO [����];
GRANT ALTER ON employee
TO [����];
GRANT SELECT,DELETE,UPDATE,INSERT ON employee TO [��ƽ] WITH GRANT OPTION;
GRANT SELECT,DELETE,UPDATE,INSERT ON department TO [��ƽ] WITH GRANT OPTION;

GRANT SELECT ON getRewarding TO [����];