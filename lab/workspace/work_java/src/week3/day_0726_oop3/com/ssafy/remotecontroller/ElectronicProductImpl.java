package week3.day_0726_oop3.com.ssafy.remotecontroller;

public abstract class ElectronicProductImpl{
	
	private int volume = 0;
	private int max_volume;
	private boolean isTurnOn = false;
	
	abstract public void turnOn();
	abstract public void turnOff();
	abstract public void volumeUp();
	abstract public void volumeDown();
	
	public ElectronicProductImpl() {}
	
	public ElectronicProductImpl(int max_volume) {
		this.setMax_volume(max_volume);
	}

	

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume += volume;
	}

	public boolean isTurnOn() {
		return isTurnOn;
	}

	public void setTurnOn(boolean isTurnOn) {
		this.isTurnOn = isTurnOn;
	}
	
	public int getMax_volume() {
		return max_volume;
	}
	
	public void setMax_volume(int max_volume) {
		this.max_volume = max_volume;
	}
	
}
