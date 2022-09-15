-- 사번이 100인 사원의 사번, 이름, 급여, 부서이름
select e.employee_id, e.first_name, e.salary, d.department_name
from employees e 
join departments d 
on e.department_id = d.department_id
where e.employee_id = 100;

-- inner join
-- seattle 사번, 이름, 부서이름, 주소
select e.employee_id, e.first_name, d.department_name, l.street_address
from employees e, departments d, locations l
where city = 'Seattle'
and e.department_id = d.department_id
and d.location_id = l.location_id;

select e.employee_id, e.first_name, d.department_name, l.street_address
from employees e join departments d 
on e.department_id = d.department_id
join locations l
on d.location_id = l.location_id
where city = 'Seattle';

-- using
select e.employee_id, e.first_name, e.salary, d.department_name
from employees e  join departments d 
using (department_id)
where e.employee_id = 100;

-- natural join
select e.employee_id, e.first_name, e.salary, d.department_name
from employees e natural join departments d 
where e.employee_id = 100;

-- 부서번호가 10인 부서의 부서번호, 부서이름, 도시
select d.department_name, l.street_address
from departments d natural join locations l
where d.department_id = '10';


-- 회사에 근무하는 모든 사원의 사번, 이름, 부서이름
-- 회사에 근무하는 사원수 
-- 107명
select count(employee_id)
from employees;

-- 회사에 근무하는 모든 사원의 사번, 이름, 부서이름
-- 106명 >> 문제 발생..
select e.employee_id, e.first_name, d.department_name
from employees e join departments d
on e.department_id = d.department_id;

-- 부서가 없는(부서번호가 null) 사원 검색
select *
from employees
where department_id is null;

-- 해결
select e.employee_id, e.first_name, ifnull(d.department_name, '대기발령')
from employees e left join departments d
on e.department_id = d.department_id;


-- 회사에 존재하는 모든 부서의 부서이름과 부서에서 근무하는 사원의 사번, 이름
-- 회사의 부서수 >> 27
select count(distinct department_id)
from departments;
-- 사원이 근무하는 부서수 >> 11
select count(distinct department_id)
from employees;

-- 사원이 없는 부서의 정보는 출력이 않됨.
select d.department_name, e.employee_id, e.first_name
from employees e join departments d
on e.department_id = d.department_id;

-- 해결
select d.department_name, e.employee_id, e.first_name
from employees e right outer join departments d
on e.department_id = d.department_id;

select ifnull(d.department_name, '대기발령'), e.employee_id, e.first_name 
from employees e left join departments d
on e.department_id = d.department_id
union
select d.department_name, e.employee_id, e.first_name
from employees e right outer join departments d
on e.department_id = d.department_id;

-- self join
-- 모든 사원의 사번, 이름, 매니저사번, 매니저이름
select e1.employee_id, e1.first_name, e1.manager_id, e2.first_name
from employees e1 join employees e2
on e1.manager_id = e2.employee_id;

select e1.employee_id, e1.first_name, e1.manager_id, ifnull(e2.first_name, '사장님')
from employees e1 left join employees e2
on e1.manager_id = e2.employee_id;

-- None-Equi join
-- 모든 사원의 사번, 이름, 급여, 급여등급
select e.employee_id, e.first_name, e.salary, s.grade
from employees e join salgrades s
where e.salary between s.losal and s.hisal;


-- 사번이 101인 사원의 근무 이력.
-- 근무 당시의 정보를 아래를 참고하여 출력.
-- 출력 컬럼명 : 사번, 이름, 부서이름, 직급이름, 시작일, 종료일
-- 날짜의 형식은 00.00.00
select e.employee_id as '사번', e.first_name as '이름', d.department_name as '부서이름', 
	   j.job_title as '직급이름', date_format(jh.start_date, '%y.%m.%d') as '시작일', date_format(jh.end_date, '%y.%m.%d') as '종료일'
from employees e join departments d
on e.department_id = d.department_id
join job_history jh
on d.department_id = jh.department_id
join jobs j
on jh.job_id = j.job_id
where e.employee_id = 101;


-- 위의 정보를 출력 하였다면 위의 정보에 현재의 정보를 출력.
-- 현재 근무이력의 시작일은 이전 근무이력의 종료일 + 1일로 설정.
-- 종료일은 null로 설정.
select a.employee_id 사번, a.first_name 이름, a.department_name 부서이름, a.job_title 직급, a.sd 시작일, a.ed 종료일
from(
	select e.employee_id, e.first_name, d.department_name, 
		   j.job_title, date_format(jh.start_date, '%y.%m.%d') sd, date_format(jh.end_date, '%y.%m.%d') ed
	from employees e join job_history jh
	on e.employee_id = jh.employee_id
	join departments d
	on jh.department_id = d.department_id
	join jobs j
	on jh.job_id = j.job_id
	where e.employee_id = 101
	union
	select e.employee_id as '사번', e.first_name as '이름', d.department_name as '부서이름', 
		   j.job_title as '직급이름', ( select date_format(date_add(max(end_date), interval 1 day) ,'%y.%m.%d')
									from job_history
									where employee_id = 101) , null
	from employees e join departments d
	on e.department_id = d.department_id
	join jobs j
	on j.job_id = e.job_id
	where e.employee_id = 101
    ) a;
