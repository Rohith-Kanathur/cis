package com.cis.test;


import com.cis.bo.College;
import com.cis.db.PoolDB;

public class TestTreeBuild {

	public static void main(String[] args) {
		College college = new College();
		PoolDB poolDB = new PoolDB();
	    if (!poolDB.loadCollege("RV College", college))
	    {
	    	System.out.println("Failed to Load the Given College Name");
	    	return;
	    }
	    
	    System.out.println(college.getCollegeID());
	    System.out.println(college.getName());
	    System.out.println(college.getCreateDateTime());
	    System.out.println(college.getLastUpdateDateTime());
	    System.out.println(college.getLastUpdateUser());
	    
	    /*
	    // Get Current Time
	    LocalTime t1 = LocalTime.now(); 
	    
	    college.getPool().loadPool(college.getCollegeID());
	    college.buildTreeUsingPool();
	    
	    // Get Current Time
	    LocalTime t2 = LocalTime.now();
	    */
	}

}
