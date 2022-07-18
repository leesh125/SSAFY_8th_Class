package com.ssafy.live1.basic;

public class BP_15 {
    public static void main(String[] args) {

        int a = 10;
        int b = 20;
        System.out.println((a > b) & (b > 0));
        
        System.out.println((a += 10) > 15 | (b -= 10) > 15);
        System.out.println("a = " + a + ", b = " + b);

        a  =10;
        b = 20;
        System.out.println((a += 10) > 15 || (b -= 10) > 15); // 숏서킷 연산 : 앞에 결과로 비교가 끝나면 뒤에를 수행 안함
        System.out.println("a = " + a + ", b = " + b);
    }
}
