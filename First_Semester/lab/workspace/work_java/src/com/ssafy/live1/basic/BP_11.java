package com.ssafy.live1.basic;

public class BP_11 {

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        byte b1 = 10;
        byte b2 = 20;
        // TODO: 다음에서 발생하는 오류를 읽고 원인을 말한 후 수정하시오.
//         byte b3 = b1 + b2;
        int b3 = b1 + b2;
        // 원인: 산술 이항 연산자는 연산 전에 피 연산자의 타입을 일치시킨다. 
        // 		 피연산자의 크기가 4byte(int) 미만이면 int로 변경한 후 연산 진행

        int i1 = 10;
        long l1 = 20;
        // TODO: 다음에서 발생하는 오류를 읽고 원인을 말한 후 수정하시오.
//         int i2 = i1 + l1; 
        long i2 = i1 + l1;
        // 원인: 묵시적 형변환으로 int(i1)는 long으로 됨, 따라서 i2도 long으로 선언해야 함
         
        // TODO: 다음에서 발생하는 오류를 읽고 원인을 말한 후 수정하시오.
//         float f1 = 10.0;
        float f1 = 10.0f;
//         float f2 = f1 + 20.0;
         float f2 = f1 + 20.0f;
         // 
    }

}
