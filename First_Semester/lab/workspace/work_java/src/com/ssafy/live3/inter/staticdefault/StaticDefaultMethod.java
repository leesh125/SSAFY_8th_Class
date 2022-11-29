package com.ssafy.live3.inter.staticdefault;

interface Aircon {
    void makeCool();
    
    // TODO: 2. 건조기능을 추가해보자.
    default void dry() {
    	System.out.println("에어컨 건조 잘못하면 곰팡이 ㅠ");
    }
    // END:
    
    // TODO: 3.Aircon이 동작 방식에 대해 설명해보자.
    static void howto() {
    	System.out.println("냉매를 이용해서 공기를 차갑게");
    }
    // END:
    
}

class OldisButGoodies1 implements Aircon{
    @Override
    public void makeCool() {
        System.out.println("전체 냉각해줘");
    }
}

class OldisButGoodies2 implements Aircon{
    @Override
    public void makeCool() {
        System.out.println("집중 냉각해줘");
    }
}

// TODO: 1. 무풍 에어컨을 구현해보자.
class NoWind1 implements Aircon {
	
	@Override
	public void makeCool() {
		System.out.println("바람은 없지만 시원해!");
	}
	
	@Override
	public void dry() {
		System.out.println("종료버튼 클릭하면 건조 후 종료되도록");
	}
}
// END:

public class StaticDefaultMethod {
    public static void main(String[] args) {
    	Aircon.howto();
    	
        Aircon [] aircons = {new OldisButGoodies1(), new OldisButGoodies2()};
        for(Aircon aircon: aircons) {
            if(aircon==null) {
                continue;
            }
            aircon.makeCool();
        }
    }
}
