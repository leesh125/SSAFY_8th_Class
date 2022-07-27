package week3.day_0726.com.ssafy.remotecontroller;

public class RemoteControllerImpl implements RemoteController {

	@Override
	public void turnOn(ElectronicProductImpl ep) {
		ep.turnOn();
	}

	@Override
	public void turnOff(ElectronicProductImpl ep) {
		ep.turnOff();
	}

	@Override
	public void volumeUp(ElectronicProductImpl ep) {
		ep.volumeUp();
	}

	@Override
	public void volumeDown(ElectronicProductImpl ep) {
		ep.volumeDown();
	}

}
