package org.catchingplagiarists;

public class Assignment {
	private String aName;
	private String fName;
	public Assignment(String assignmentName, String fileName){
		aName = assignmentName;
		fName = fileName;
	}
	public String getAssignmentName() {
		return aName;
	}
	public void setAssignmentName(String aName) {
		this.aName = aName;
	}
	public String getFileName() {
		return fName;
	}
	public void setFileName(String fName) {
		this.fName = fName;
	}
	
	
}
