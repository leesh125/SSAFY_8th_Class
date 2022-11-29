package week6.day_0816;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MeetingRoomTest {

	static class Meeting implements Comparable<Meeting> {
		int start, end; // 회의 시작, 종료 시간

		private Meeting(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}
		
		@Override
		public int compareTo(Meeting o) { // 종료시간 기준 오름차순, 종료시간이 같다면 시작시간 기준 오름차순
			return this.end != o.end ? this.end-o.end : this.start-o.start;
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		Meeting[] meetings = new Meeting[N];
		
		for(int i=0; i<N; i++) {
			meetings[i] = new Meeting(sc.nextInt(), sc.nextInt());
		}
		
		List<Meeting> result = getSchedule(meetings);
		System.out.println(result.size());
		for(Meeting meeting: result) {
			System.out.println(meeting.start + " " + meeting.end);
		}

	}

	private static List<Meeting> getSchedule(Meeting[] meetings) {
		// 모든 회의를 종료시간 기준 오름차순, 종료시간이 같다면 시작시간 기준 오름차순
		List<Meeting> result = new ArrayList<Meeting>();
		Arrays.sort(meetings);
		result.add(meetings[0]); // 첫번째 회의는 스케쥴에 무조건 추가
		
		for(int i=1,size = meetings.length; i<size;i++) {
			if(result.get(result.size()-1).end <= meetings[i].start){
				result.add(meetings[i]);
			}
		}
		
		return result;
	}

}
