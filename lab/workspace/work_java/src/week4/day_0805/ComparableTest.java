package week4.day_0805;

import java.util.Arrays;
import java.util.Comparator;

public class ComparableTest {

	public static void main(String[] args) {
		
		Person[] persons = {
				new Person("김재환", 27),
				new Person("이동욱", 16),
				new Person("강태오", 25)
		};
		
		System.out.println(Arrays.toString(persons));
		Arrays.sort(persons);
		System.out.println(Arrays.toString(persons));
		
		Arrays.sort(persons, new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
//				return Integer.compare(o1.getAge(), o2.getAge());
				return o1.getAge() - o2.getAge(); // 나이 오름차순
			}
		});
		System.out.println(Arrays.toString(persons));
		Arrays.sort(persons, (o1, o2) -> o1.getName().compareTo(o2.getName())); // 람다식
		System.out.println(Arrays.toString(persons));
		Arrays.sort(persons, (o1, o2) -> o1.getAge() - o2.getAge()); // 람다식
		System.out.println(Arrays.toString(persons));
	}

}
