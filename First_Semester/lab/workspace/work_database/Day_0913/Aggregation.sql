use ssafydb;

select sum(salary), sum(salary*commission_pct), round(avg(salary),2), count(*)
from employees;

select count(department_id)
from employees;

select *
from employees
where department_id is null;

select department_id, max(salary), min(salary)
from employees
group by department_id;

select department_id, avg(salary)
from employees
group by department_id
having avg(salary) >= 7000;

select @@sql_mode;

SET SESSION sql_mode = 'NO_ENGINE_SUBSTITUTION,STRICT_TRANS_TABLES,ONLY_FULL_GROUP_BY'; 

select employee_id, first_name
from employees
union
select department_name, department_id 
from departments;

drop table test;
create table test(
	val varchar(10)
);

start transaction;

insert into test
values('a');

insert into test
values('b');

insert into test
values('c');

savepoint f1;

commit;

select *
from test;

insert into test
values('d');

insert into test
values('e');

savepoint f2;

insert into test
values('f');

rollback to f2;

select *
from test;

select @@autocommit;

set autocommit = 0;