package week2.day_0720;

import java.util.Arrays;

public class PersonArrayTest {

	public static void main(String[] args) {
		Person[] persons = new Person[2];
//		System.out.println(Arrays.toString(persons));
		
		persons[0] = new Person("김재환", 26);
		persons[1] = new Person("이동욱", 16);
		
		for(int i=0; i<persons.length; i++) {
			persons[i].printInfo();
		}
		
		for(Person p: persons) {
			p.printInfo();
		}
	}

}
