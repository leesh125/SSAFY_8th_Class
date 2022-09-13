select abs(-2), abs(0), abs(2);

select round(1526.159), round(1526.159,0), round(1526.159,1), round(1526.159,2), round(1526.159,-1), round(1526.159,-2);

select ascii('0'), ascii('A'), ascii('a')
from dual;

select concat(first_name, ' ', last_name)
from employees;

select employee_id, hire_date, date_format(hire_date, '%y-%m.%d %h:%i:%s')
from employees;

select count(employee_id), sum(salary), avg(salary), max(salary), min(salary)
from employees;