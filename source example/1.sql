create table db_test.employee
(
    empno   double not null,
    epname  char(20),
    title   char(10) default 'Sawon',
    manager double,
    salary  double,
    dno     double,
    primary key (empno),
    foreign key (manager) references employee (empno) on delete cascade
);



create table db_test.department(
  deptno double not null,
  deptname char(10),
  floor double,
  primary key(deptno)
);

insert into db_test.department values (1, 'Salaryman', 8);
insert into db_test.department values (2, 'Planner', 10);
insert into db_test.department values (3, 'Depart', 9);
insert into db_test.department values (4, 'Cashier', 7);

desc db_test.department;
desc db_test.employee;

select * from db_test.employee;

insert into db_test.employee values (1003,'HaSanaKvun', 'Gwazang', 4377, 3000000, 2);
insert into db_test.employee values (1365,'KanaHanSol', 'Sawon', 3426, 1500000, 1);
insert into db_test.employee values (2106,'SonaJaeMin', 'Daeri', 1003, 2500000, 2);
insert into db_test.employee values (3011,'KimInSub', 'Buzang', 4377, 4000000, 3);
insert into db_test.employee values (3426,'JeongKiWon', 'Gwazang', 4377, 3000000, 1);
insert into db_test.employee values (3427,'HanZinSub', 'Sawon', 3011, 1500000,3 );
insert into db_test.employee values (4377,'KwonHunHvuona', 'Sazang',null , 5000000, 2);

select * from db_test.employee where salary>=3000000;

select empno, epname from db_test.employee where salary>=3000000;

select count(*) from db_test.employee where salary>=3000000;

desc db_test.employee;

select * from db_test.employee where employee.epname like 'K%' and employee.salary>=3000000;

desc db_test.department;

select * from db_test.department;

select *from db_test.employee;

alter table db_test.department add TITLE char(10);

update db_test.department set TITLE = 'Coporation';
select * from db_test.employee where title='Sawon';

update db_test.employee set salary = salary*2 where title='Sawon';

select * from db_test.employee where title='Gwazang' and dno=2;