package com.masai.services;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Map;

import com.masai.entity.Batches;
import com.masai.exceptions.DataNotFoundException;
import com.masai.exceptions.DuplicateEntryException;
import com.masai.exceptions.EmptyListException;

public class BatchServiceExecut implements BatchServices{

	@Override
	public String createNewBatch(Map<String , Batches> batches ,  Batches newBatch) throws DuplicateEntryException {
		if(!batches.containsKey(newBatch.getId())) {
			batches.put(newBatch.getId(), newBatch);
			ObjectOutputStream batchSt;
			try {
				batchSt = new ObjectOutputStream(new FileOutputStream("BatchFile.ser"));
				batchSt.writeObject(batches);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			throw new DuplicateEntryException("This Batch has already been created , create a new one");
		}
			
		// TODO Auto-generated method stub
		return "SuccessFully Created";
	}

	@Override
	public void adViewAllBatches(Map<String , Batches> batches) throws EmptyListException {
		// TODO Auto-generated method stub
		if(!batches.isEmpty()) {
			for(Map.Entry<String, Batches> b : batches.entrySet()) {
				System.out.println(b);
			}
		}else {
			throw new  EmptyListException("No Any Batches is present, first create one...");
		}
	}

	@Override
	public void deleteaBatch(String id , Map<String , Batches> batches) throws EmptyListException, DataNotFoundException{
		if(batches.size()==0) throw new EmptyListException("No Any Batches is present, first create one...");
		if(batches.containsKey(id)) {
			batches.remove(id);
		}else {
			throw new DataNotFoundException("Given id is not present in the database");
		}
		
	}
}
