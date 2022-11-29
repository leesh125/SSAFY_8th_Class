-- 3번
select code,name,continent,Region
from country
where code = 'KOR';

-- 4번
select code,name,GNP,GNPOld,GNPOld/GNP as 'gnp변동량'
from country
where GNPOld/GNP > 0
order by GNPOld/GNP;

-- 5번
select distinct continent
from country
order by length(continent);

-- 6번
select concat(name,'은 ', region, '에 속하며 인구는 ', population, '명 이다.') as 정보
from country
where continent = 'Asia';

-- 7번
select name, continent, gnp, population
from country
where IndepYear is not null
and Population >= 10000
order by Population;

-- 8번
select code, name, population
from country
where Population >= 100000000
and Population <= 200000000
order by population desc;

-- 9번
select code, name, indepyear
from country
where IndepYear in (800,1810,1811,1901)
order by indepyear desc, code desc;

-- 10번
select code, name, region
from country
where region like '%Asia%'
and substr(name,2,1) = 'o';

-- 11번
select char_length('홍길동') as 한글, length('hong') as 영문;

-- 12번
select code, name, GovernmentForm
from country
where length(name) >= 10
and GovernmentForm like '%Republic%'
order by length(name) desc;

-- 13번
select code, name
from country
where substr(code,1,1) in ('A','E','I','O','U')
order by name
limit 2,3;

-- 14번
select name, concat(left(name,2),rpad('',length(name)-2,'*'),right(name,2)) as guess
from country;

-- 15번
select distinct replace(region,' ','_') as 지역들
from country;

-- 16번
select name, SurfaceArea, Population, round(surfacearea/population,3) as '1인당 점유면적'
from country
where population != 0
and -- 3번
select code,name,continent,Region
from country
where code = 'KOR';

-- 4번
select code,name,GNP,GNPOld,GNPOld/GNP as 'gnp변동량'
from country
where GNPOld/GNP > 0
order by GNPOld/GNP;

-- 5번
select distinct continent
from country
order by length(continent);

-- 6번
select concat(name,'은 ', region, '에 속하며 인구는 ', population, '명 이다.') as 정보
from country
where continent = 'Asia';

-- 7번
select name, continent, gnp, population
from country
where IndepYear is not null
and Population >= 10000
order by Population;

-- 8번
select code, name, population
from country
where Population >= 100000000
and Population <= 200000000
order by population desc;

-- 9번
select code, name, indepyear
from country
where IndepYear in (800,1810,1811,1901)
order by indepyear desc, code desc;

-- 10번
select code, name, region
from country
where region like '%Asia%'
and substr(name,2,1) = 'o';

-- 11번
select char_length('홍길동') as 한글, length('hong') as 영문;

-- 12번
select code, name, GovernmentForm
from country
where length(name) >= 10
and GovernmentForm like '%Republic%'
order by length(name) desc;

-- 13번
select code, name
from country
where substr(code,1,1) in ('A','E','I','O','U')
order by name
limit 2,3;

-- 14번
select name, concat(left(name,2),rpad('',length(name)-2,'*'),right(name,2)) as guess
from country;

-- 15번
select distinct replace(region,' ','_') as 지역들
from country;

-- 16번
select name, SurfaceArea, Population, round(surfacearea/population,3) as '1인당 점유면적'
from country
where population != 0
and round(surfacearea/population,3) != 0.000
order by round(surfacearea/population,3);