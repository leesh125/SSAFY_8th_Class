package week3.day_0727.collection.com.ssafy.collection;

import java.util.HashSet;
import java.util.Set;

public class SetTest2 {

	public static void main(String[] args) {
		
		Set<Person> set = new HashSet<>();
		set.add(new Person("김재환", 1));
		set.add(new Person("김재환", 2));
		set.add(new Person("김재환", 1));
		
		for (Person person : set) {
			person.printInfo();
		}
	}

}
