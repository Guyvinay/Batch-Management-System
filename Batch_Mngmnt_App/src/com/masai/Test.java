package com.masai;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Test {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd?MM?yyyy");
		
		LocalDate dob = LocalDate.of(1985, 02, 20);//(yyyy-MM-dd)
		
		String st = dob.format(dtf);
		System.out.println(st);
		
////		System.out.println(dob.isLeapYear());
//		System.out.println(dob.atTime(2,02,02));
//		
		//	double s =(double) 3/2;
//		System.out.println( s );
//		ObjectInputStream oos = new ObjectInputStream(new FileInputStream("BatchFile.ser"));
//		Map<String , Batches> ma = null;
//		ma = (Map<String , Batches>) oos.readObject();
//		System.err.println(ma);
//		oos.close();
		
	}
}
