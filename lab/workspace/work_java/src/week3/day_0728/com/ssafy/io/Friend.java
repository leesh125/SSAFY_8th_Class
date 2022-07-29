package week3.day_0728.com.ssafy.io;

import java.io.Serializable;

public class Friend implements Serializable{
	private String name;

	public Friend() {}
	
	public Friend(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Friend [name=" + name + "]";
	}
	
	
}
