package week3.day_0728.com.ssafy.xml;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class WeatherDAODom implements WeatherDAO{

	
	@Override
	public List<Weather> getWeatherList(String url) {
		return connectWeather(url);
	}
	
	private List<Weather> connectWeather(String url) {
		List<Weather> list = new ArrayList<>();
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); // 1. factory 생성
		try {
			DocumentBuilder builder = factory.newDocumentBuilder(); // 2. factory를 통해 builder 생성
			Document dom = builder.parse(new URL(url).openConnection().getInputStream()); // 3. parsing 하기
			
			Element root = dom.getDocumentElement(); // root Element (하나만 존재)
			NodeList nodeList = root.getElementsByTagName("data"); // 노드들의 리스트(<data> 태그의 리스트)
			
			for(int i=0; i<nodeList.getLength(); i++) {
				Weather w = new Weather();
				Node node = nodeList.item(i);
				
				NodeList kids = node.getChildNodes();
				for(int j=0; j<kids.getLength(); j++) {
					Node kid = kids.item(j);
					
					String name = kid.getNodeName();
					if(name.equals("tmef")) {
//						w.setDate(kid.getFirstChild().getNodeValue());
						w.setDate(kid.getTextContent());
					}else if(name.equals("wf")) {
						w.setWf(kid.getFirstChild().getNodeValue());
					}else if(name.equals("tmn")) {
						w.setTmn(kid.getFirstChild().getNodeValue());
					}else if(name.equals("tmx")) {
						w.setTmx(kid.getFirstChild().getNodeValue());
					} 
				}
				list.add(w);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
}
