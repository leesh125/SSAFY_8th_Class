package week3.day_0726_oop3.com.ssafy.exception;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class MyUtil {
	
//	public static void logging(String msg) {
//		PrintWriter out = null;
//		try {
//			out = new PrintWriter(new FileWriter("log.txt", true));
//			out.print(msg);
//		}catch(IOException e) {
//			e.printStackTrace();
//		}finally {
//			if(out != null) out.close();
//		}
//		
//	}
	
	public static void logging(String msg) throws IOException {
		PrintWriter out = null;
		try {
			out = new PrintWriter(new FileWriter("log.txt", true));
			out.print(msg);
		}finally {
			if(out != null) out.close();
		}
		
	}
	
	public static String readLog() {
		String log = null;
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("log2.txt"));
			log = br.readLine();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			System.out.println("finally.....");
			if(br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return log;
	}
	
	public static int division(int a, int b) {
		
		int result = a/b;
		return result;
	}
}