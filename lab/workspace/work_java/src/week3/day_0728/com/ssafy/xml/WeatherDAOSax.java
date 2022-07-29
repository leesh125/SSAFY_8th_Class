package week3.day_0728.com.ssafy.xml;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class WeatherDAOSax implements WeatherDAO {

	private static List<Weather> list;
	
	@Override
	public List<Weather> getWeatherList(String url) {
		connectWeather(url);
		return list;
	}
	
	private void connectWeather(String url) {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		
		try {
			SAXParser parser = factory.newSAXParser();
			parser.parse(new URL(url).openConnection().getInputStream(), new SAXHandler());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static class SAXHandler extends DefaultHandler{
		
		Weather w;
		StringBuilder sb;
		
		@Override
		public void startDocument() throws SAXException {
			list = new ArrayList<Weather>();
			sb = new StringBuilder();
		}

		@Override
		public void startElement(String uri, String localName, String qName, Attributes attributes)
				throws SAXException {
			if(qName.equals("data")) {
				w = new Weather();
				list.add(w);
			}
		}
		
		@Override
		public void endElement(String uri, String localName, String qName) throws SAXException {
			if(w != null) {
				if(qName.equals("tmEf")) {
					w.setDate(sb.toString());
				}else if(qName.equals("wf")) {
					w.setWf(sb.toString());
				}else if(qName.equals("tmn")) {
					w.setTmn(sb.toString());
				}else if(qName.equals("tmx")) {
					w.setTmx(sb.toString());
				}
			}
			sb.setLength(0);
		}
		
		@Override
		public void endDocument() throws SAXException {
			super.endDocument();
		}

		@Override
		public void characters(char[] ch, int start, int length) throws SAXException {
			sb.append(ch, start, length);
		}

		
		
	}

}
