package b형대비특강.Day_0901;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class NextLevel {

	static class User {
		private String username;
		private int level;
		
		public User() {
			this.username = "codetree";
			this.level = 10;
		}
		
		public User(String username, int level) {
			this.username = username;
			this.level = level;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public int getLevel() {
			return level;
		}
		public void setLevel(int level) {
			this.level = level;
		}
		
		@Override
		public String toString() {
			return "user " + this.username + " lv " + this.level;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] temp = br.readLine().split(" ");
		String username = temp[0]; int level = Integer.parseInt(temp[1]);
		User user1 = new User();
		User user2 = new User(username, level);
		bw.write(user1.toString());
		bw.newLine();
		bw.write(user2.toString());
		bw.flush();
		bw.close();
	}

}
