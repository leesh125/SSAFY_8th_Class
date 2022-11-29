package week3.day_0728.com.ssafy.xml;

public class Weather {
	private String date;
	private String tmn;
	private String tmx;
	private String wf;

	public Weather() {
		super();
	}
	
	public Weather(String date, String tmn, String tmx, String wf) {
		super();
		this.date = date;
		this.tmn = tmn;
		this.tmx = tmx;
		this.wf = wf;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTmn() {
		return tmn;
	}

	public void setTmn(String tmn) {
		this.tmn = tmn;
	}

	public String getTmx() {
		return tmx;
	}

	public void setTmx(String tmx) {
		this.tmx = tmx;
	}

	public String getWf() {
		return wf;
	}

	public void setWf(String wf) {
		this.wf = wf;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("날짜: ");
		builder.append(date + "시");
		builder.append("     ");
		builder.append("온도: ");
		builder.append(String.format("%3s ~%2s도", tmn, tmx));
		builder.append("     ");
		builder.append("구름양: ");
		builder.append(wf);
		builder.append("     ");
		return builder.toString();
	}
}
