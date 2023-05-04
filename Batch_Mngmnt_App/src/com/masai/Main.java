package com.masai;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Map;
import java.util.Scanner;

import com.masai.entity.Address;
import com.masai.entity.Batches;
import com.masai.entity.Faculty;
import com.masai.exceptions.DuplicateEntryException;
import com.masai.exceptions.EmptyListException;
import com.masai.exceptions.InvalidArugumentException;
import com.masai.exceptions.InvalidDetailsException;
import com.masai.exceptions.WrongCredsException;
import com.masai.services.FacultyServiceExcecut;
import com.masai.services.FacultyServices;
import com.masai.utility.AdminCred;
import com.masai.utility.CheckFileAv;
import com.masai.utility.GenerateFacID;

public class Main {

	//Admin Activity
	
	public static void adminActivity(Scanner sc,Map<String , Batches> batches , Map<String , Faculty> faculty) throws InvalidDetailsException, EmptyListException {
//		System.out.println(batches);
		adminLoginMethod(sc);
		FacultyServices fac = new FacultyServiceExcecut();
		int opt = 0;
		do {
				System.out.println("Press '1' to view all faculty");
				opt = sc.nextInt();
				
				switch(opt) {
				case 1 : 
					adminViewAllFaculties(faculty , fac);
				}
				
		}while(opt<=1);
		
	}
	public static void adminViewAllFaculties(Map<String , Faculty> faculty , FacultyServices fac) throws EmptyListException {
		fac.adminViewAllFac(faculty);
	}

	
	public static void adminLoginMethod(Scanner sc ) throws InvalidDetailsException  {
		System.out.println("Enter Your UserName");
		String userName = sc.next();
		System.out.println("Enter Your PassWord");
		String pass = sc.next();
		
		if(userName.equals(AdminCred.userName) && pass.equals(AdminCred.passWord)) {
			System.out.println("Admin SuccessFully Logged In.");
		} else {
			throw new InvalidDetailsException("Entered Credentials are not in place.");
		  }
		}
	
	public static void facultyActivity(Scanner sc  , Map<String , Faculty> faculty , Map<String , Batches> batches) throws WrongCredsException {
		// TODO Auto-generated method stub
		FacultyServices  facService = new FacultyServiceExcecut();
		System.out.println("enter Details");
		System.out.println("ID");
		String id = sc.next();
		System.out.println("Name");
		String name = sc.next();
		System.out.println("email");
		String email = sc.next();
		System.out.println("Password");
		String pass = sc.next();
		facultyLogin(id , name , email, pass ,faculty ,facService);
	    System.out.println(" Faculty "+ name+" SuccessFully Logged In...");	
		
	}
	
	public static void facultyLogin(String id , String name , String email , String pass  , Map<String , Faculty> faculty , FacultyServices facService) throws WrongCredsException {
		facService.login(id,name, email , pass , faculty);
	}
	
	public static void facultySignup(Scanner sc , Map<String , Faculty> faculty ) throws DuplicateEntryException {
		
		System.out.println("Enter Following details");
		System.out.println("Username");
		String userName = sc.next();
		System.out.println("password");
		String password = sc.next();
		System.out.println("City");
		String city = sc.next();
		System.out.println("State");
		String state = sc.next();
		System.out.println("ZipCode");
		String zip = sc.next();
		System.out.println("Landmark");
		String landmark = sc.next();
		Address address = new Address(city ,state , zip , landmark);
		System.out.println("email");
		String email = sc.next();
		Faculty fac = new Faculty(userName,password,address,email );
		
		FacultyServices facSer = new FacultyServiceExcecut();
		
		facSer.signUp(fac,faculty);
		
	}
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		
		Map<String , Batches> batches = CheckFileAv.batchFile();
		Map<String , Faculty> faculty = CheckFileAv.facultyFile();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Welcome to Kate School's Batch Management");
		
		try {
			int pref = 0;
			do {
				System.out.println("Enter Your Preferences What do you want ,"+"\n" + " '1'_-_->For Admin Login"+"\n" + " '2' _-_-> For Faculty Login ,"+"\n" + " '3' _-_-> For Faculty SignUp ,"+ " '0'_-_-> For Existing the System. " + "\n");
				
				pref = sc.nextInt();
				
				switch(pref) {
				case 1 : adminActivity(sc,batches,faculty);
				break;
				case 2 : facultyActivity(sc , faculty , batches);
				break;
				case 3 : facultySignup(sc , faculty);
				break;
				case 0 : System.out.println("Successfully Existed from the System");
				break;
				default : throw new InvalidArugumentException("Please Select a Valid one");
				
				}
			}
			while(pref!=0);
			
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
		  try {
				ObjectOutputStream batchSt = new ObjectOutputStream(new FileOutputStream("BatchFile.ser"));
				batchSt.writeObject(batches);
				ObjectOutputStream facultySt = new ObjectOutputStream(new FileOutputStream("Faculty.ser"));
				facultySt.writeObject(faculty);
				batchSt.close();
				facultySt.close();
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}