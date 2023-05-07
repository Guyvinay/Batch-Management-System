package com.masai.entity;

import java.io.Serializable;
import java.time.LocalDate;

import com.masai.utility.GenerateFacID;

public class Batches implements Serializable{

	private String id;
	private String courseName;
	private int noOfSeats;
	private String startDate;
	private int duration;
//	public Batches( String courseName, int noOfSeats, String startDate, int duration) {
//		super();
//		this.id = courseName+"_"+GenerateFacID.generateID();
//		this.courseName = courseName;
//		this.noOfSeats = noOfSeats;
//		this.startDate = startDate;
//		this.duration = duration;
//	}
	public Batches(String id , String courseName  , int noOfSeats  , String startDate , int duration) {
		super();
		this.id = id;
		this.courseName = courseName;
		this.noOfSeats = noOfSeats;
		this.startDate = startDate;
		this.duration = duration;
	}
	public Batches() {
       super();		
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public int getNoOfSeats() {
		return noOfSeats;
	}
	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	@Override
	public String toString() {
		return "Batche [id=" + id + ", courseName=" + courseName + ", noOfSeats=" + noOfSeats + ", startDate="
				+ startDate + ", duration=" + duration + "]";
	}
	
}
