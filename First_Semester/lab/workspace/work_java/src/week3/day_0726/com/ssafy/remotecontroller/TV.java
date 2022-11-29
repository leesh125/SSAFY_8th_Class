package week3.day_0726.com.ssafy.remotecontroller;

public class TV extends ElectronicProductImpl{

	public TV() {}

	public TV(int max_volume) {
		super(max_volume);
	}

	@Override
	public void turnOn() {
		this.setTurnOn(true);
		System.out.println("TV가 켜짐");
	}

	@Override
	public void turnOff() {
		this.setTurnOn(false);
		System.out.println("TV가 꺼짐");
	}

	@Override
	public void volumeUp() {
		if(this.isTurnOn()) {
			if(this.getVolume() + 1 > this.getMax_volume()) {
//			this.setVolume(this.getMax_volume());
				System.out.println("볼륨이 최대입니다. 볼륨:" + this.getVolume());
			}else {
				this.setVolume(1);
				System.out.println("현재 TV 볼륨 : " + this.getVolume());
			}
		}else {
			System.out.println("TV전원을 키고 하세요~!");
		}
	}

	@Override
	public void volumeDown() {
		if(this.isTurnOn()) {
			if(this.getVolume() - 1 < 0) {
				System.out.println("볼륨이 최소입니다. 볼륨: 0");
				this.setVolume(0);
			}else {
				this.setVolume(-1);
				System.out.println("현재 TV 볼륨 : " + this.getVolume());
			}
		}else {
			System.out.println("TV전원을 키고 하세요~!");
		}
	}

}
