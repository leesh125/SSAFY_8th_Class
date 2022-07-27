package week3.day_0726.com.ssafy.remotecontroller;

public class SetTopBox extends ElectronicProductImpl{

	public SetTopBox() {}

	public SetTopBox(int max_volume) {
		super(max_volume);
	}
	
	@Override
	public void turnOn() {
		this.setTurnOn(true);
		System.out.println("셋톱박스가 켜짐");
	}

	@Override
	public void turnOff() {
		this.setTurnOn(false);
		System.out.println("셋톱박스가 꺼짐");
	}

	@Override
	public void volumeUp() {
		if(this.isTurnOn()) {
			if(this.getVolume() + 5 > this.getMax_volume()) {
//			this.setVolume(this.getMax_volume());
				System.out.println("볼륨이 최대입니다. 볼륨:" + this.getVolume());
			}else {
				this.setVolume(5);
				System.out.println("현재 셋톱 볼륨 : " + this.getVolume());
			}
		}else {
			System.out.println("셋톱전원을 키고 하세요~!");
		}
	}

	@Override
	public void volumeDown() {
		if(this.isTurnOn()) {
			if(this.getVolume() - 5 < 0) {
				System.out.println("볼륨이 최소입니다. 볼륨:0");
				this.setVolume(0);
			}else {
				this.setVolume(-5);
				System.out.println("현재 셋톱 볼륨 : " + this.getVolume());
			}
		}else {
			System.out.println("셋톱전원을 키고 하세요~!");
		}
	}

}
