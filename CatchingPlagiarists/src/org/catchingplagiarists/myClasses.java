package org.catchingplagiarists;
import java.util.*;

public class myClasses {
	private ArrayList<Class> classes;
	public myClasses(){
		classes = new ArrayList<Class>();
		
	}
	
	
	public ArrayList<Class> getClasses() {
		return classes;
	}

	public void addClass(Class c){
		classes.add(c);
	}
	public void addClass(String classname){
		Class temp = new Class(classname);
		classes.add(temp);
	}
	
	public void addAssignmentToAll(String assignmentName){
		for(Class c: this.getClasses()){
			c.addAssignmentToClass(assignmentName);
		}
	}
	public String compareAllClasses(String aname){
		int allStudents = 0;
		for(Class c: this.getClasses()){
			allStudents+= c.getStudents().size();
		}
		String[] files = new String[allStudents];
		int count = 0;
		for(Class c: this.getClasses()){
		
			for(Student s: c.getStudents()){
				ArrayList<Assignment> temp = s.getAssignments();
				for(Assignment a: temp){
					if(a.getAssignmentName().equals(aname)){
						files[count] = a.getFileName();
						count++;
					}
				}
			}
		}
		NewHash counter = new NewHash(files, "someDirPath");
		counter.countHits();
		return counter.toStringTops();
		
	}
}
