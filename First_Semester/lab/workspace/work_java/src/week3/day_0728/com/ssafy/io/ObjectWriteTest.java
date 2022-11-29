package week3.day_0728.com.ssafy.io;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ObjectWriteTest {

	public static void main(String[] args) {
//		try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("person.dat"))){
//			out.writeObject(new Person("김재환", 27, new Friend("김태희")));
//			out.flush();
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
		try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("person.dat"))){
			Person p = (Person)in.readObject();
			System.out.println(p);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
