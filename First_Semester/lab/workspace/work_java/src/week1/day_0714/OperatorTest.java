package week1.day_0714;

public class OperatorTest {

	public static void main(String[] args) {
		int i = 10;
//		int j = ++i; // i = i + 1,	int j = i;
		int j = i++; // int j = i, 	i = i + 1 
		
		System.out.println(i + "," + j);

		int k = 10;
		System.out.println(++k);
		
		int a = 10;
		a += 1; // a++, ++a
		System.out.println(a);
		a *= 2;
		System.out.println(a);
	}

}
