/* Employee Table */
create table Employee(EmployeeId int primary key auto_increment, EmployeeCode varchar(10), Name varchar(30), Password varchar(30), LastLoginDate date, isDeleted int);
insert into employee values(employeeid, '1001', 'Tester One', '123', CURDATE());
insert into employee values(employeeid, '1002', 'Tester Two', '456', CURDATE());
insert into employee values(employeeid, '1003', 'Tester Three', '789', CURDATE());
