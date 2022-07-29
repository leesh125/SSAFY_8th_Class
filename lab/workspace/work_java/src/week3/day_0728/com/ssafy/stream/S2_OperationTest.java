package week3.day_0728.com.ssafy.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class S2_OperationTest {

	public static void main(String[] args) {
		
		
//		Stream<String> names = Stream.of("john", "tomas","jane", "smith");
		String[] arr = {"john", "tomas","jane", "smith"};
		{
			Stream<String> names = Arrays.stream(arr);
			// 이름에 s가 들어있는 사람들만 추출해서 몇명인지 출력
			long count = names.filter(e -> e.contains("s")).count();
			System.out.println(count);
		}
		
		{
			// 이름뒤에 's를 붙이는 가공후 모두 출력
			Arrays.stream(arr).map(e -> e.concat("'s")).forEach(System.out::println);			
		}
		
		{
			// 이름에 s가 들어있는 사람들만 추출해서 몇명인지 출력
			// 이름뒤에 's를 붙이는 가공후 모두 출력
			Arrays.stream(arr).filter(e -> e.contains("s"))
				  .map(e-> e.concat("'s"))
				  .forEach(System.out::println);
		}
		
		{
			Person[] persons = {new Person("김재환", 27),
								new Person("박보검", 30),
								new Person("강태오", 22)};
			int sum = Arrays.stream(persons).mapToInt(e -> e.getAge()).sum();
			System.out.println(sum);
			
			int max = Arrays.stream(persons).mapToInt(e->e.getAge()).max().getAsInt();
			System.out.println(max);
			
			// 나이가 20세 이상인 사람들의 리스트를 반환
			List<Person> result = Stream.of(persons).filter(e->e.getAge()>=23)
													.collect(Collectors.toList());
			result.forEach(System.out::println);
			
			List<String> resultName = Stream.of(persons).filter(e->e.getAge()>=23)
														.map(e -> e.getName())
														.collect(Collectors.toList());
			resultName.forEach(System.out::println);
		}
	}

}
