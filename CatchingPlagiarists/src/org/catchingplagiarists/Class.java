package org.catchingplagiarists;

import java.util.ArrayList;

public class Class {
	private String className;
	private ArrayList<Student> students;
	public Class(String cName){
		className = cName;
		students = new ArrayList<Student>();
		
	}
	
	public String getClassName(){
		return className;
	}
	public void addStudent(Student s){
		students.add(s);
	}
	
	public ArrayList<Student> getStudents() {
		return students;
	}
	public Student getStudent(String lname, String fname){
		for(Student s: this.getStudents()){
			if(s.getFirstName().equals(fname) && s.getLastName().equals(lname)) return s;
		}
		return null;
	}

	public void addStudent(String lName, String fName, Class stuClass){
		Student temp = new Student(lName, fName, stuClass);
		students.add(temp);
	}
	public void addAssignmentToClass(String aName){
		for(Student s: students){
			s.addAssignment(aName, "");
		}
	}
	public void addFile(String aname, String file, Student stu){
		stu.addFile(aname, file);
	}
	public void addFile(String aname, String file, String fname, String lname){
		for(Student stu: students){
			if(stu.getFirstName().equals(fname)
					&& stu.getStudentClass().equals(lname)) stu.addFile(aname, file);
		}
	}
	
	public void compareClass(String aname){
		String[] files = new String[getStudents().size()];
		int count = 0;
		for(Student s: this.getStudents()){
			ArrayList<Assignment> temp = s.getAssignments();
			for(Assignment a: temp){
				if(a.getAssignmentName().equals(aname)){
					files[count] = a.getFileName();
					count++;
				}
			}
			NewHash counter = new NewHash(files, "someDirPath");
			counter.countHits();
			counter.printTop();
		}
	}
	public String compareClassString(String aname){
		String[] files = new String[getStudents().size()];
		int count = 0;
		for(Student s: this.getStudents()){
			ArrayList<Assignment> temp = s.getAssignments();
			for(Assignment a: temp){
				if(a.getAssignmentName().equals(aname)){
					files[count] = a.getFileName();
					count++;
				}
			}
		}
			NewHash counter = new NewHash(files, "someDirPath");
			counter.countHits();
			return counter.toStringTops();
		
		
	}
	
}
