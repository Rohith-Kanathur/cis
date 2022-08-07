package com.cis.test;


import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import com.cis.bo.College;
import com.cis.db.CollegeDB;
import com.cis.db.PoolDB;

public class TestTreeBuild {

	public static void main(String[] args) {
		// The below code for CollegeDB and PoolDB will utilize JDBC Initialization time which varies.
		// It takes more time to initialize for first time and then lesser for second time.
		// So to be fair, do not include the CollegeDB and PoolDB initialization code in profiling.
		College c1 = new College();
		CollegeDB collegeDB = new CollegeDB();
	    if (!collegeDB.loadCollege("RV College", c1)) {
	    	System.out.println("Failed to Load the Given College Name");
	    	return;
	    }

		College c2 = new College();
		PoolDB poolDB = new PoolDB();
	    if (!poolDB.loadCollege("RV College", c2)) {
	    	System.out.println("Failed to Load the Given College Name");
	    	return;
	    }
		
	    // Approach 1: Read from Database by traversing the entire tree - Brute Force Approach.	 
		{
		    LocalTime t1 = LocalTime.now();  // Get Current Time
	
			// Load from Database where children are read for each parent in a loop.
			if (!c1.loadCollegeTreeUsingBruteForce()) {
		    	System.out.println("Failed to Load the Given College using BruteForce approach.");
		    	return;
		    }
	
		    LocalTime t2 = LocalTime.now(); // Get Current Time
		    
		    //c1.printTree();
		    System.out.println(t1);
		    System.out.println(t2);
		    System.out.println(t1.until(t2, ChronoUnit.NANOS)); // Print the time in microseconds: t2 - t1
	    } // End of 1st Approach.
	
		// 2nd Approach: Reading once for each table and Building Tree Recursively in Memory - Optimized Approach.	    
	    {	
		    // Get Current Time
		    LocalTime t3 = LocalTime.now(); 
	
		    if (!c2.getPool().loadPool(c2.getCollegeID())) {
		    	System.out.println("Failed to Load the Pool");
		    	return;
		    }
	
		    c2.buildTreeUsingPool();
		    
		    LocalTime t4 = LocalTime.now();  // Get Current Time
		    
		    //c2.printTree();
		    System.out.println(t3);
		    System.out.println(t4);
		    System.out.println(t3.until(t4, ChronoUnit.NANOS)); // Print the time in microseconds: t3 - t4
	    } // End of 2nd Approach.
	    
	}
	
}
