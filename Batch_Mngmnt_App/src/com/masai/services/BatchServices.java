package com.masai.services;

import java.util.Map;

import com.masai.entity.Batches;
import com.masai.exceptions.DataNotFoundException;
import com.masai.exceptions.DuplicateEntryException;
import com.masai.exceptions.EmptyListException;

public interface BatchServices {

	public String createNewBatch(Map<String , Batches> batches , Batches newBatch)throws DuplicateEntryException;
	
	public void adViewAllBatches(Map<String , Batches> batches)throws EmptyListException;
	
	public void deleteaBatch(String id , Map<String , Batches> batches) throws EmptyListException , DataNotFoundException;
	
}
