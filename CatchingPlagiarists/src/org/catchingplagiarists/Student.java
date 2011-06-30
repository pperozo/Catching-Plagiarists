package org.catchingplagiarists;
import java.util.*;
public class Student {
	private String lastn;
	private String firstn;
	private Class stuClass;
	private ArrayList<Assignment> assignments;
	public Student(String lastName, String firstName, Class studentClass){
		lastn = lastName;
		firstn = firstName;
		stuClass = studentClass;
		assignments = new ArrayList<Assignment>();
	}
	public String getLastName() {
		return lastn;
	}
	public void setLastName(String lastn) {
		this.lastn = lastn;
	}
	public String getFirstName() {
		return firstn;
	}
	public void setFirstName(String firstn) {
		this.firstn = firstn;
	}
	public Class getStudentClass() {
		return stuClass;
	}
	public void setStudentClass(Class stuClass) {
		this.stuClass = stuClass;
	}
	public ArrayList<Assignment> getAssignments(){
		return assignments;
	}
	public void addAssignment(Assignment a){
		assignments.add(a);
	}

	public void addAssignment(String aname, String fname){
		Assignment temp = new Assignment(aname, fname);
		assignments.add(temp);
	}
	public void addFile(String aname, String fName){
		for(Assignment a: assignments){
			if(a.getAssignmentName().equals(aname)) a.setFileName(fName);
		}
	}
	public void compareFiles(String assignment, Student other){
		String[] files = new String[2];
		for(Assignment a: this.getAssignments()){
			if(a.getAssignmentName().equals(assignment)){
				files[0] =a.getFileName();
			}
		}
		for(Assignment b: other.getAssignments()){
			if(b.getAssignmentName().equals(assignment)){
				files[1] =b.getFileName();
			}
		}
			NewHash compare = new NewHash(files, "somefilepath");	
			compare.countHits();
			compare.print();
			
		}
	//needs to be fixed doesn't do as intended
	public String toString(){
		String allAssignments = "";
		for(Assignment a: this.getAssignments()){
			
			allAssignments = allAssignments + stuClass.compareClassString(a.getAssignmentName());
		}
		return allAssignments;
		
	}
	}
	
	
	
	
	



