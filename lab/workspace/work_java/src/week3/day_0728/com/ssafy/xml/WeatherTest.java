package week3.day_0728.com.ssafy.xml;

public class WeatherTest {

	public static void main(String[] args) {

//		WeatherDAO dao = new WeatherDAOSax();
		WeatherDAODom dao = new WeatherDAODom();
		String url = "https://www.kma.go.kr/weather/forecast/mid-term-rss3.jsp?stnId=109";
		dao.getWeatherList(url).forEach(System.out::println);;
	}

}
