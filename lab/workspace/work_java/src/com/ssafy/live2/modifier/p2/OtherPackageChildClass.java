package com.ssafy.live2.modifier.p2;

import com.ssafy.live2.modifier.p1.Parent;
//TODO: Parent를 상속받고 Parent의 member들에 접근해보세요.
 public class OtherPackageChildClass extends Parent{
	 public void method() {
		 this.publicVar = 10;
		 this.protectVar = 10;
//		 this.defaultVar = 10; // default = package
//		 this.privVar = 10;
//		 this.someVar = 10;
	 }
    // END:
}
