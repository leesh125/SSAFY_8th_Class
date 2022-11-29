package week1.day_0714;

public class IfTest {

	public static void main(String[] args) {
		
		int year = 2022;
		int month = 3;
		int lastDay = 0;
		
		// month 월의 유효성 체크를 하여 1-12 월이 아닐 경우는 메소드의 실행을 끝낸다.
		if(month < 1 || month > 12) {
			System.out.println("1 ~ 12의 숫자를 입력하세요.");
			return;
		}else if(month == 2) {
			if((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
				lastDay = 29;
			}else {
				lastDay = 28;
			}
		}else if((month % 2 == 0 && month >= 8) || (month % 2 == 1 && month <= 7)) { // 그렇지 않을 경우에는 마지막 날짜를 구한다.
			lastDay = 31;
		}else {
			lastDay = 30;
		}

		System.out.println(month + "월의 마지막 날짜는 " + lastDay + "일 입니다.");			
		
		

	}

}
