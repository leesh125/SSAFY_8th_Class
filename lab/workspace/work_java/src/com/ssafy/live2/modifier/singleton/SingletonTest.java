package com.ssafy.live2.modifier.singleton;

class SingletonClass{
    // TODO:SingletonClass에 Singleton Design Pattern을 적용하시오.
	// stateless 한 클래스 - 상태를 가지지 않고 기능만 가지는 클래스
	private static SingletonClass sc = new SingletonClass();
	private SingletonClass() {}
	public static SingletonClass getSingletonClass() {
		return sc;
	}
    // END:
    public void sayHello() {
      System.out.println("Hello");
    }
    
  }

  public class SingletonTest {
    public static void main(String[] args) {
      // TODO:SingletonClass를 사용해보세요.
//    	SingletonClass sc = new SingletonClass();
    	SingletonClass sc = SingletonClass.getSingletonClass();
    	sc.sayHello();
    	
    	SingletonClass sc2 = SingletonClass.getSingletonClass();
    	sc2.sayHello();
    	
    	System.out.println(sc == sc2);
      // END:
    }
  }
