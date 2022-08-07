package com.cis.test;


import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import com.cis.bo.College;
import com.cis.db.CollegeDB;
import com.cis.db.PoolDB;

public class TestTreeBuild {

	public static void main(String[] args) {
		
		// 1st Approach: Reading once for each table and Building Tree Recursively in Memory
		
	    // Get Current Time
	    LocalTime t1 = LocalTime.now(); 
	    
		College c1 = new College();
		PoolDB poolDB = new PoolDB();
	    if (!poolDB.loadCollege("RV College", c1)) {
	    	System.out.println("Failed to Load the Given College Name");
	    	return;
	    }
	    
	    if (!c1.getPool().loadPool(c1.getCollegeID())) {
	    	System.out.println("Failed to Load the Pool");
	    	return;
	    }
	    c1.buildTreeUsingPool();
	    
	    LocalTime t2 = LocalTime.now();  // Get Current Time
	    
	    //c1.printTree();
	    System.out.println(t1);
	    System.out.println(t2);
	    System.out.println(t1.until(t2, ChronoUnit.NANOS)); // Print the time in microseconds: t2 - t1
	 
	    
	    // Approach 2: Read from Database by traversing the entire tree
	    LocalTime t3 = LocalTime.now();  // Get Current Time
	    
		College c2 = new College();
		CollegeDB collegeDB = new CollegeDB();
	    if (!collegeDB.loadCollege("RV College", c2)) {
	    	System.out.println("Failed to Load the Given College Name");
	    	return;
	    }

		// Load from Database where children are read for each parent in a loop.
		if (!c2.loadCollegeTreeUsingBruteForce()) {
	    	System.out.println("Failed to Load the Given College using BruteForce approach.");
	    	return;
	    }

	    LocalTime t4 = LocalTime.now(); // Get Current Time
	    
	    //c2.printTree();
	    System.out.println(t3);
	    System.out.println(t4);
	    System.out.println(t3.until(t4, ChronoUnit.NANOS)); // Print the time in microseconds: t4 - t3
	    
	}

}
