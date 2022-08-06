package com.cis.bo;

import java.util.ArrayList;
import java.util.Date;

public class Course extends CisBo{
	
	private long courseID;
	private String name;
	private ArrayList<CourseInstance> courseInstanceList;

	public Course() {
		courseInstanceList = new ArrayList<CourseInstance>();
	}

	public long getCourseID() {
		return courseID;
	}

	public void setCourseID(long courseID) {
		this.courseID = courseID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<CourseInstance> getCourseInstanceList() {
		return courseInstanceList;
	}

	public void setCourseInstanceList(ArrayList<CourseInstance> courseInstanceList) {
		this.courseInstanceList = courseInstanceList;
	}
	
	public boolean addCourseInstance(CourseInstance courseInstance) {
		
		for (int i = 0; i < courseInstanceList.size(); i++) {
			int flag1 = courseInstanceList.get(i).getStartDate().compareTo(courseInstance.getStartDate());
			int flag2 = courseInstanceList.get(i).getEndDate().compareTo(courseInstance.getEndDate()); 
			
			if ((flag1 == 0) && (flag2 == 0))	// A course instance with same start date and end dates exists.
				return false;					// Therefore it cannot be added.		
		}
		
		courseInstanceList.add(courseInstance);
		return true;
	}
	
	public boolean removeCourseInstance(Date startDate, Date endDate) {
		
		CourseInstance courseInstance = null;
		for (int i = 0; i < courseInstanceList.size(); i++) {
			
			int flag1 = courseInstanceList.get(i).getStartDate().compareTo(startDate);
			int flag2 = courseInstanceList.get(i).getEndDate().compareTo(endDate); 
			
			if ((flag1 == 0) && (flag2 == 0)) {	
				courseInstance = courseInstanceList.get(i);
				break;
			}
		}
		
		if (courseInstance != null) {
			courseInstanceList.remove(courseInstance);
			return true;
		}
		
		return false;
	}
	
}
