package week3.day_0727.collection.com.ssafy.collection;

import java.util.Iterator;
import java.util.TreeSet;

public class SetTest {

	public static void main(String[] args) {
		
//		HashSet<String> set = new HashSet<>();
		TreeSet<String> set = new TreeSet<>();
		set.add("김재환");
		set.add("김재환");
		set.add("이준호");
		set.add("우영우");
		
		System.out.println(set.size());
		
		Iterator<String> it = set.iterator();
		while(it.hasNext()) {
			String s = it.next();
			System.out.println(s);
		}
		
		for(String s: set) {
			System.out.println(s);
		}
	}

}
