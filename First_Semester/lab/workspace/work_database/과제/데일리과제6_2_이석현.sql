-- 1번
select date_format(now(), '%Y-%m-%d') as '오늘', 
		dayofyear(now()) as '올해 지난 날', 
        date_format(date_add(now(),interval 100 day), '%Y-%m-%d') as '100일이 지난 후';

-- 2번
select name, continent, lifeExpectancy,
		case when lifeExpectancy > 80
			 then '장수국가'
             when lifeExpectancy > 60
             then '일반국가'
             else '단명국가'
		end '구분'
from country
where LifeExpectancy is not null
order by LifeExpectancy;

-- 3번
select name, gnp, gnpold,
		ifnull(gnp-gnpold,'신규') as 'gnp 향상'
from country
order by name;

-- 4번
select weekday('2020-05-05'),
	   case when weekday('2020-05-05') in(1,2)
			then '행복'
			else '불행'
		end '행복여부';
        
-- 5번
select count(*) as '전체',
	   count(IndepYear) as '독립 연도 보유'
from country;

-- 6번
select sum(LifeExpectancy) as '합계',
		round(avg(LifeExpectancy),2) as '평균',
       max(LifeExpectancy) as '최대',
       min(LifeExpectancy) as '최소'
from country;

-- 7번
select continent, count(continent) as '국가 수', sum(Population) as '인구 합'
from country
group by continent
order by count(continent) desc
limit 7;

-- 8번
select continent, sum(SurfaceArea) as '표면적 합'
from country
group by continent
order by sum(SurfaceArea) desc
limit 3;

-- 9번
select continent, sum(GNP) as 'gnp 합'
from country
where Population >= 50000000
group by continent
order by sum(gnp);

-- 10번
select continent, sum(GNP) as 'gnp 합'
from country
where Population >= 50000000
group by continent
having sum(gnp) >= 5000000
order by sum(gnp);

-- 11번
select IndepYear, count(IndepYear) as '독립 국가 수'
from country
group by IndepYear
having count(indepyear) >= 10;

-- 12번
select c1.continent, c1.name, c1.gnp, 
	   (select avg(gnp) from country) as '전 세계 평균', 
       c2.a as '대륙 평균'
from country c1 join (
					select continent, avg(gnp) as a from country group by continent
				 ) as c2
where c1.continent = c2.continent
group by c1.continent
order by c1.continent;