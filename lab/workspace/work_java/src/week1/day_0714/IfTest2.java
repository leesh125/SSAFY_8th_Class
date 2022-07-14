package week1.day_0714;

public class IfTest2 {

	public static void main(String[] args) {
		
		int year = 2022;
		int month = 12;
		int lastDay = 0;
		
		// month 월의 유효성 체크를 하여 1-12 월이 아닐 경우는 메소드의 실행을 끝낸다.
		if(month < 1 || month > 12) {
			System.out.println("1 ~ 12의 숫자를 입력하세요.");
			return;
		}
		
		
		switch(month) {
		case 1:case 3:case 5:case 7:case 8:case 10:case 12:
			lastDay = 31;
			break;
		case 4:case 6:case 9:case 11:
			lastDay = 30;
			break;				
		default:
			if((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) lastDay = 29;
			else lastDay = 28;
		}
		
		
		System.out.println(month + "월의 마지막 날짜는 " + lastDay + "일 입니다.");			
		
		

	}

}
