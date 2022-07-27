package week3.day_0726.com.ssafy.remotecontroller;

public interface ElectronicProduct {
	
	void turnOn(ElectronicProductImpl ep);
	void turnOff(ElectronicProductImpl ep);
	void volumeUp(ElectronicProductImpl ep);
	void volumeDown(ElectronicProductImpl ep);
}
