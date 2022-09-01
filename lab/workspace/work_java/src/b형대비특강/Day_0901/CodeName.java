package b형대비특강.Day_0901;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class CodeName {
	
	static class Student{
		private String name;
		private int score;
		public Student(String name, int score) {
			super();
			this.name = name;
			this.score = score;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getScore() {
			return score;
		}
		public void setScore(int score) {
			this.score = score;
		}
		@Override
		public String toString() {
			return this.name + " " + this.score;
		}
	}
	
	static String[] temp;
	static int minScore = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Student[] students = new Student[5];
		for(int i=0; i<5; i++) {
			temp = br.readLine().split(" ");
			String name = temp[0];
			int score = Integer.parseInt(temp[1]);
			
			students[i] = new Student(name,score);
			students[i].setName(name);
			students[i].setScore(score);
			if(minScore > score) minScore = score;
		}
		for(Student s: students) {
			if(s.getScore() == minScore) {
				bw.write(s.toString());
				break;
			}
		}
		bw.flush();
		bw.close();
		
	}

}
