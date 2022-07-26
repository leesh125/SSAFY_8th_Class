package week3.day_0726_oop3.com.ssafy.remotecontroller;

public interface RemoteController {
	void turnOn(ElectronicProductImpl ep);
	void turnOff(ElectronicProductImpl ep);
	void volumeUp(ElectronicProductImpl ep);
	void volumeDown(ElectronicProductImpl ep);
}
