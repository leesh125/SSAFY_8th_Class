package b형대비특강.Day_0901;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Class_007 {

	static class Secret {
		private String code,point;
		private int time;
		
		private Secret(String code, String point, int time) {
			this.code = code;
			this.point = point;
			this.time = time;
		}
		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}
		public String getPoint() {
			return point;
		}
		public void setPoint(String point) {
			this.point = point;
		}
		public int getTime() {
			return time;
		}
		public void setTime(int time) {
			this.time = time;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] temp = br.readLine().split(" ");
		String code = temp[0]; String point = temp[1]; int time = Integer.parseInt(temp[2]);
		Secret secret = new Secret(code,point,time);
		bw.write("secret code : " + secret.getCode());
		bw.newLine();
		bw.write("meeting point : " + secret.getPoint());
		bw.newLine();
		bw.write("time : " + secret.getTime());
		bw.flush();
		bw.close();
	}

}
