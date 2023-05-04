package com.masai.services;

import java.util.Map;

import com.masai.entity.Faculty;
import com.masai.exceptions.DuplicateEntryException;
import com.masai.exceptions.EmptyListException;
import com.masai.exceptions.WrongCredsException;

public class FacultyServiceExcecut implements FacultyServices {

	@Override
	public void signUp(Faculty fac , Map<String , Faculty> faculty) throws DuplicateEntryException {
		// TODO Auto-generated method stub
		if(faculty.containsKey(fac.getFacId())) {
			throw new DuplicateEntryException("This user is Already Registered Entere a different User");
		}else {
			faculty.put(fac.getFacId(), fac);
		}
	}

	@Override
	public boolean login(String id , String name ,String mail , String password, Map<String, Faculty> faculty) throws WrongCredsException{
		// TODO Auto-generated method stub
		if(faculty.containsKey(id)) {
		
			if(faculty.get(id).getPassWord().equals(password)) {
				return true;
			}else {
				throw new WrongCredsException("You've Entered Wrong Credentials! Try Again...");
			}
			
		}
		else {
			throw new WrongCredsException("Faculty is not registered! Register First...");
		}
	}

	@Override
	public void adminViewAllFac(Map<String, Faculty> faculty) throws EmptyListException {
		// TODO Auto-generated method stub
		if(faculty!=null && faculty.size()>0) {
			for(Map.Entry<String , Faculty> ent : faculty.entrySet() ) {
				System.out.println(ent.getValue());
			}
		} else {
			throw new EmptyListException("Enpty Faculty List First Add Few Faculty");
		}
	}
	
}
