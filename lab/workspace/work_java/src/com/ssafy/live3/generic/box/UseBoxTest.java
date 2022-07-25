package com.ssafy.live3.generic.box;

public class UseBoxTest {

    public static void main(String[] args) {
        useNormalBox();
        useGenericBox();
        useNumberBox();
    }

    private static void useNormalBox() {
        // TODO: NormalBox 타입의 객체를 생성하고 사용해보세요.
    	NormalBox nbox = new NormalBox();
    	// Object 처리 --> 뭐든지 담을 수 있다.
    	nbox.setSome(1);
    	nbox.setSome("hello");
    	
    	Object obj = nbox.getSome();
    	// compile ok, runtime error - runtime에 타입에 대한 체크
//    	Integer num = (Integer)obj;
    	if(obj instanceof String) {
    		String str = (String) obj;
    		System.out.println(str + " : " + str.length());
    	}
        // END:
    }

    private static void useGenericBox() {
        // TODO: GenericBox 타입의 객체를 생성하고 사용해보세요.
    	GenericBox<String> sbox = new GenericBox<>();
    	sbox.setSome("hello");
    	// sbox.setSome(1); // compile 시점에 타입에 대한 체크
    	String str = sbox.getSome();
    	System.out.println(str + " : " + str.length());
    	
    	GenericBox<Integer> ibox = new GenericBox<Integer>();
    	ibox.setSome(1);
    	
    	GenericBox<Object> obox= new GenericBox<>();
        // END:
    }

    private static void useNumberBox() {
        // TODO: NumberBox 타입의 객체를 생성하고 사용해보세요.
    	NumberBox<Number> numbox = new NumberBox<>();
    	numbox.addSome(1, 10L, 3.14);
    	
    	NumberBox<Integer> dbox= new NumberBox<>();
    	dbox.addSome(1, 3, 10);
        // END:
    }

}
