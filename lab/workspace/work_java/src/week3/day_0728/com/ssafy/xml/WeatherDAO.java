package week3.day_0728.com.ssafy.xml;

import java.util.List;

public interface WeatherDAO {

	List<Weather> getWeatherList(String url);

}