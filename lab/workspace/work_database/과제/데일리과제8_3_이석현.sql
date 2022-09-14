use world;
-- #1
select c.code, c.name 
from country c 
join city on c.code = city.countrycode 
where city.name='kabul';

-- #2
select name, language, percentage 
from countrylanguage cl 
join country on cl.countrycode=country.code 
where percentage=100 
order by name;

-- #3
select ct.name, countrylanguage.language, country.name 
from city ct 
join countrylanguage on ct.countrycode = countrylanguage.countrycode 
join country on ct.countrycode = country.code 
where ct.name='Amsterdam' 
order by countrylanguage.percentage desc 
limit 1;

-- #4
select ctry.name, capital, city.name as '수도', city.population as '수도인구' 
from country ctry join city on ctry.capital=city.id 
where left(ctry.name, length("United"))="United";

-- #5
select ctry.name, capital, ifnull(city.name, '수도없음') as '수도', ifnull(city.population, '수도없음') as '수도인구' 
from country ctry left join city on ctry.capital=city.id 
where left(ctry.name, length("United")) = "United";

-- #6
select count(c1.countrycode) 
from countrylanguage c1 
where c1.isofficial='T' and c1.percentage > (select c2.percentage from countrylanguage c2 where c2.countrycode='che' order by c2.percentage desc limit 1);

-- #7
select cl.language 
from countrylanguage cl 
join country c on cl.countrycode=c.code 
where c.name='south korea' 
and cl.isofficial='T';

-- #8
select ctry.name, ctry.code, count(ct.name) 
from city ct 
left join country ctry on ctry.code=ct.countrycode 
where left(ctry.name, length("Bo"))="Bo" 
group by ctry.code;

-- #9
select ctry.name, ctry.code, if(count(ct.name)=0, '단독', count(ct.name)) as '도시개수' 
from city ct 
right join country ctry on ctry.code=ct.countrycode 
where left(ctry.name, length("Bo"))="Bo" 
group by ctry.code;

-- 10번
select countrycode, name, population 
from city 
order by population desc 
limit 1;

-- 11번
select ctry.name, ctry.code, ct.name, ct.population 
from city ct 
join country ctry on ctry.code = ct.countrycode 
order by population asc 
limit 1;

-- 12번
select ct1.countrycode, ct1.name, ct1.population 
from city ct1 
where ct1.Population > (select ct2.population from city ct2 where ct2.name = 'Seoul');

-- 13번
select ct.countrycode, cl.language 
from city ct 
join countrylanguage cl on ct.countrycode = cl.countrycode 
where ct.name='San Miguel' 
and cl.isofficial='T';

-- 14번
select countrycode, max(population) 
from city
group by countrycode;

-- 15번
select countrycode,name,max(population)
from city
group by CountryCode;

-- 16번
select ci.countrycode,ci.name,co.name,max(ci.population)
from city ci, country co
where ci.CountryCode = co.code
group by CountryCode
order by ci.countrycode;

-- 17번
create view summary as
select ci.countrycode,ci.name ci_name, co.name co_name,max(ci.population)
from city as ci, country as co
where ci.CountryCode = co.code
group by ci.CountryCode
order by ci.countrycode;

-- 18번
select co.code,co.name,ci.name,ci.population
from country co, city ci
where co.code = ci.countrycode
and co.code = 'KOR'
limit 1;

select * from country where code='KOR';
select * from city where countrycode='KOR';