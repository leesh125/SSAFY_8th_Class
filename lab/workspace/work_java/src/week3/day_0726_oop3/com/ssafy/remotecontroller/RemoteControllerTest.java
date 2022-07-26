package week3.day_0726_oop3.com.ssafy.remotecontroller;

public class RemoteControllerTest {

	public static void main(String[] args) {
		RemoteController rc = new RemoteControllerImpl();
		TV tv = new TV(100);
		SetTopBox stb = new SetTopBox(200);
//		tv.turnOn();
//		tv.volumeDown();
//		tv.volumeUp();
		rc.turnOn(tv);
		rc.turnOn(stb);
		
		rc.volumeDown(tv);
		
		for(int i=0; i<50; i++) {
			rc.volumeUp(stb);
		}
		for(int i=0; i<101; i++) {
			rc.volumeUp(tv);
		}
		for(int i=0; i<102; i++) {
			rc.volumeDown(tv);
		}

	}

}
