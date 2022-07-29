package com.ssafy.live3.inter.module;

public class LazerPrinter implements Printer {
	@Override
	public void print(String fileName) {
		System.out.println("laser printer: " + fileName);
		
	}
}
