package com.masai;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Map;

import com.masai.entity.Batches;

public class Test {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
	
		ObjectInputStream oos = new ObjectInputStream(new FileInputStream("BatchFile.ser"));
		Map<String , Batches> ma = null;
		ma = (Map<String , Batches>) oos.readObject();
		System.err.println(ma);
		oos.close();
		
	}
}
