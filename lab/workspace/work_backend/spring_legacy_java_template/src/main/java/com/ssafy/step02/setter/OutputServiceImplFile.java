package com.ssafy.step02.setter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class OutputServiceImplFile implements OutputService {
	
	private static OutputServiceImplFile instance = new OutputServiceImplFile();
	
	public OutputServiceImplFile getInstance(){
		if(instance == null) {
			instance = new OutputServiceImplFile();
		}
		return instance;
	}

	public void output(String msg) {
		PrintWriter out = null;
		try {
			out = new PrintWriter(new FileWriter("msg.txt",true), true);
			out.println(msg);
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(out != null) out.close();
		}
	}

}
