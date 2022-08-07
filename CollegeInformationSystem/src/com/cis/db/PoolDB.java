package com.cis.db;

import com.cis.bo.*;
import com.cis.test.TestTreeBuild;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

public class PoolDB {
	
	private String dbUrl = null;
	private String dbUsername = null;
	private String dbPassword = null;
	private String dbDriver = null;
	
	private Connection con = null;
	
	public PoolDB() {
		
		try (InputStream input = TestTreeBuild.class.getClassLoader().getResourceAsStream("db.properties")) {
            Properties prop = new Properties();

            // load a properties file
            prop.load(input);

            // get the property value and print it out
            dbUrl = prop.getProperty("dbUrl");
            dbUsername = prop.getProperty("dbUsername");
            dbPassword = prop.getProperty("dbPassword");
            dbDriver = prop.getProperty("dbDriver");
 
        } catch (IOException ex) {
            ex.printStackTrace();
        }
		
		loadDriver(dbDriver); 
		con = getConnection();
	}
	
	public void loadDriver(String dbDriver) {
		try {
			// The constructor of the class gets called and static block of code in this class
			// is executed when the class is loaded into memory. This code will Register the
			// JDBC Driver class within JAVA. So Java knows the JDBC Driver.
			Class.forName(dbDriver); 
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		try {
			// DriverManager will use a JDBC Driver that is previously registered with Java.
			// See the comments in above code loadDriver() for understanding how the JDBC driver 
			// is registered with Java.
			con = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		return con;
	}
	
	public boolean loadDepartmentList(long collegeID, ArrayList<Department> departmentList) {
		String sql = "select DepartmentID, Name, CollegeID, ParentTableNo, ParentID, CreateDateTime, "
				   + "LastUpdateDateTime, LastUpdateUser "
				   + "from department where CollegeID = ? order by ParentTableNo, ParentID";
		
		// Load departmentList
		Department department = null;
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setLong(1, collegeID);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				   department = new Department();
				   department.setPrimaryKey(rs.getLong("DepartmentID"));
				   department.setDepartmentID(rs.getLong("DepartmentID"));
				   department.setName(rs.getString("Name"));
				   department.setCollegeID(rs.getLong("CollegeID"));
				   
				   short parentTableNo = rs.getShort("ParentTableNo");
				   department.setParentTableNo(parentTableNo);
				   long parentID = rs.getLong("ParentID");
				   department.setParentID(parentID);
				   
				   department.setCreateDateTime(rs.getDate("CreateDateTime"));
				   department.setLastUpdateDateTime(rs.getDate("LastUpdateDateTime"));
				   department.setLastUpdateUser(rs.getString("LastUpdateUser"));
				   
                  departmentList.add(department);
	           }
	           rs.close();
		}
		catch(Exception e) {
			return false;
		}
		
		return true;
	}
	
	public boolean loadFacultyList(long collegeID, HashMap<Short, HashMap<Long, ArrayList<Faculty>>> facultyMaps) {
		String sql = "select FacultyID, Name, Designation, CollegeID, ParentTableNo, ParentID, CreateDateTime, "
				   + "LastUpdateDateTime, LastUpdateUser "
				   + "from faculty where CollegeID = ? order by ParentTableNo, ParentID";
		
		// Load facultyList
		Faculty faculty = null;
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setLong(1, collegeID);
			
			short prevParentTableNo = -1;
			long prevParentID = -1;
			ArrayList<Faculty> facultyList = null;

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				   faculty = new Faculty();
				   faculty.setPrimaryKey(rs.getLong("FacultyID"));
				   faculty.setFacultyID(rs.getLong("FacultyID"));
				   faculty.setName(rs.getString("Name"));
				   faculty.setCollegeID(rs.getLong("CollegeID"));
				   faculty.setDesignation(rs.getShort("Designation"));
			   
				   short parentTableNo = rs.getShort("ParentTableNo");
				   faculty.setParentTableNo(parentTableNo);
				   long parentID = rs.getLong("ParentID");
				   faculty.setParentID(parentID);
				   if ((prevParentTableNo != parentTableNo) || (prevParentID != parentID)) {		
					   prevParentTableNo = parentTableNo;
					   prevParentID = parentID;
					   
					   HashMap<Long, ArrayList<Faculty>> hm = facultyMaps.get(parentTableNo);
					   if (hm == null) { // If the input map does NOT have the inner map, create the inner map and set it.
						   hm = new HashMap<Long, ArrayList<Faculty>>();
						   facultyMaps.put(parentTableNo, hm);
					   }
						   
					   ArrayList<Faculty> al = hm.get(parentID); // If the inner map does NOT have the arrayList, create the arrayList and set it.
					   if (al == null) {
						   facultyList = new ArrayList<Faculty>(); // Create a new list as one of the order by clause value changes.
						   hm.put(parentID, facultyList);
					   }
					   else
						   facultyList = al; // If arrayList is created previously, use it. Should NOT come here due to OrderBy clause, defensive code stays.
				   }
				   
				   faculty.setCreateDateTime(rs.getDate("CreateDateTime"));
				   faculty.setLastUpdateDateTime(rs.getDate("LastUpdateDateTime"));
				   faculty.setLastUpdateUser(rs.getString("LastUpdateUser"));

				   if (facultyList != null)
				      facultyList.add(faculty);
				   else
					   System.out.println("Should Not Happen: Invalid Faculty List");
	           }
	           rs.close();
		}
		catch(Exception e) {
			return false;
		}
		
		return true;
	}
	

	public boolean loadCourseList(long collegeID, HashMap<Short, HashMap<Long, ArrayList<Course>>> courseMaps) {
		String sql = "select CourseID, Name, CollegeID, ParentTableNo, ParentID, CreateDateTime, "
				   + "LastUpdateDateTime, LastUpdateUser "
				   + "from courses where CollegeID = ? order by ParentTableNo, ParentID";
		
		// Load courseList
		Course course = null;
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setLong(1, collegeID);
			
			short prevParentTableNo = -1;
			long prevParentID = -1;
			ArrayList<Course> courseList = null;

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				   course = new Course();
				   course.setPrimaryKey(rs.getLong("CourseID"));
				   course.setCourseID(rs.getLong("CourseID"));
				   course.setName(rs.getString("Name"));
				   course.setCollegeID(rs.getLong("CollegeID"));
				   
				   short parentTableNo = rs.getShort("ParentTableNo");
				   course.setParentTableNo(parentTableNo);
				   long parentID = rs.getLong("ParentID");
				   course.setParentID(parentID);
				   if ((prevParentTableNo != parentTableNo) || (prevParentID != parentID)) {		
					   prevParentTableNo = parentTableNo;
					   prevParentID = parentID;
					   
					   HashMap<Long, ArrayList<Course>> hm = courseMaps.get(parentTableNo);
					   if (hm == null) { // If the input map does NOT have the inner map, create the inner map and set it.
						   hm = new HashMap<Long, ArrayList<Course>>();
						   courseMaps.put(parentTableNo, hm);
					   }
						   
					   ArrayList<Course> al = hm.get(parentID); // If the inner map does NOT have the arrayList, create the arrayList and set it.
					   if (al == null) {
						   courseList = new ArrayList<Course>(); // Create a new list as one of the order by clause value changes.
						   hm.put(parentID, courseList);
					   }
					   else
						   courseList = al; // If arrayList is created previously, use it. Should NOT come here due to OrderBy clause, defensive code stays.
				   }
				   
				   course.setCreateDateTime(rs.getDate("CreateDateTime"));
				   course.setLastUpdateDateTime(rs.getDate("LastUpdateDateTime"));
				   course.setLastUpdateUser(rs.getString("LastUpdateUser"));
				   
				   if (courseList != null)
	                  courseList.add(course);
				   else
					   System.out.println("Should Not Happen: Invalid Course List");
	           }
	           rs.close();
		}
		catch(Exception e) {
			return false;
		}
		
		return true;
	}

	public boolean loadCourseInstanceList(long collegeID, HashMap<Short, HashMap<Long, ArrayList<CourseInstance>>> courseInstanceMaps) {
		String sql = "select CourseInstanceID, StartDate, EndDate, CollegeID, ParentTableNo, ParentID, CreateDateTime, "
				   + "LastUpdateDateTime, LastUpdateUser "
				   + "from courseinstances where CollegeID = ? order by ParentTableNo, ParentID";
		
		// Load courseInstanceList
		CourseInstance courseInstance = null;
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setLong(1, collegeID);
			
			short prevParentTableNo = -1;
			long prevParentID = -1;
			ArrayList<CourseInstance> courseInstanceList = null;

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				   courseInstance = new CourseInstance();
				   courseInstance.setPrimaryKey(rs.getLong("CourseInstanceID"));
				   courseInstance.setCourseInstanceID(rs.getLong("CourseInstanceID"));
				   courseInstance.setStartDate(rs.getDate("StartDate"));
				   courseInstance.setEndDate(rs.getDate("EndDate"));
				   courseInstance.setCollegeID(rs.getLong("CollegeID"));

				   short parentTableNo = rs.getShort("ParentTableNo");
				   courseInstance.setParentTableNo(parentTableNo);
				   long parentID = rs.getLong("ParentID");
				   courseInstance.setParentID(parentID);
				   if ((prevParentTableNo != parentTableNo) || (prevParentID != parentID)) {		
					   prevParentTableNo = parentTableNo;
					   prevParentID = parentID;
					   
					   HashMap<Long, ArrayList<CourseInstance>> hm = courseInstanceMaps.get(parentTableNo);
					   if (hm == null) { // If the input map does NOT have the inner map, create the inner map and set it.
						   hm = new HashMap<Long, ArrayList<CourseInstance>>();
						   courseInstanceMaps.put(parentTableNo, hm);
					   }
						   
					   ArrayList<CourseInstance> al = hm.get(parentID); // If the inner map does NOT have the arrayList, create the arrayList and set it.
					   if (al == null) {
						   courseInstanceList = new ArrayList<CourseInstance>(); // Create a new list as one of the order by clause value changes.
						   hm.put(parentID, courseInstanceList);
					   }
					   else
						   courseInstanceList = al; // If arrayList is created previously, use it. Should NOT come here due to OrderBy clause, defensive code stays.
				   }
				   
				   courseInstance.setCreateDateTime(rs.getDate("CreateDateTime"));
				   courseInstance.setLastUpdateDateTime(rs.getDate("LastUpdateDateTime"));
				   courseInstance.setLastUpdateUser(rs.getString("LastUpdateUser"));
				   
				   if (courseInstanceList != null)
				      courseInstanceList.add(courseInstance);
				   else
					   System.out.println("Should Not Happen: Invalid CourseInstance List");
	           }
	           rs.close();
		}
		catch(Exception e) {
			return false;
		}
		
		return true;
	}

	public boolean loadStudentList(long collegeID, HashMap<Short, HashMap<Long, ArrayList<Student>>> studentMaps) {
		String sql = "select StudentID, Name, CollegeID, ParentTableNo, ParentID, CreateDateTime, "
				   + "LastUpdateDateTime, LastUpdateUser "
				   + "from student where CollegeID = ? order by ParentTableNo, ParentID";
		
		// Load studentList
		Student student = null;
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setLong(1, collegeID);
			
			short prevParentTableNo = -1;
			long prevParentID = -1;
			ArrayList<Student> studentList = null;

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				   student = new Student();
				   student.setPrimaryKey(rs.getLong("StudentID"));
				   student.setStudentID(rs.getLong("StudentID"));
				   student.setName(rs.getString("Name"));
				   student.setCollegeID(rs.getLong("CollegeID"));  
				   
				   short parentTableNo = rs.getShort("ParentTableNo");
				   student.setParentTableNo(parentTableNo);
				   long parentID = rs.getLong("ParentID");
				   student.setParentID(parentID);
				   if ((prevParentTableNo != parentTableNo) || (prevParentID != parentID)) {		
					   prevParentTableNo = parentTableNo;
					   prevParentID = parentID;
					   
					   HashMap<Long, ArrayList<Student>> hm = studentMaps.get(parentTableNo);
					   if (hm == null) { // If the input map does NOT have the inner map, create the inner map and set it.
						   hm = new HashMap<Long, ArrayList<Student>>();
						   studentMaps.put(parentTableNo, hm);
					   }
						   
					   ArrayList<Student> al = hm.get(parentID); // If the inner map does NOT have the arrayList, create the arrayList and set it.
					   if (al == null) {
						   studentList = new ArrayList<Student>(); // Create a new list as one of the order by clause value changes.
						   hm.put(parentID, studentList);
					   }
					   else
						   studentList = al; // If arrayList is created previously, use it. Should NOT come here due to OrderBy clause, defensive code stays.
				   }
				   
				   student.setCreateDateTime(rs.getDate("CreateDateTime"));
				   student.setLastUpdateDateTime(rs.getDate("LastUpdateDateTime"));
				   student.setLastUpdateUser(rs.getString("LastUpdateUser"));
				   
				   if (studentList != null)
				      studentList.add(student);
				   else
					   System.out.println("Should Not Happen: Invalid Student List");
	           }
	           rs.close();
		}
		catch(Exception e) {
			return false;
		}
		
		return true;

	}

	public boolean loadAddressList(long collegeID, HashMap<Short, HashMap<Long, Address>> addressMaps) {
		String sql = "select AddressID, StreetAddress, Area, City, State, Pincode, Country, " 
				   + "CollegeID, ParentTableNo, ParentID, CreateDateTime, "
				   + "LastUpdateDateTime, LastUpdateUser "
				   + "from address where CollegeID = ? order by ParentTableNo, ParentID";
		
		// Load addressList
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setLong(1, collegeID);
			
			Address address = null;

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				   address = new Address();
				   
				   address.setPrimaryKey(rs.getLong("AddressID"));
				   address.setAddressID(rs.getLong("AddressID"));
				   address.setStreetAddress(rs.getString("StreetAddress"));
				   address.setArea(rs.getString("Area"));
				   address.setCity(rs.getString("City"));
				   address.setState(rs.getString("State"));
				   address.setPinCode(rs.getString("PinCode"));
				   address.setCountry(rs.getString("Country"));
				   address.setCollegeID(rs.getLong("CollegeID"));
				   
				   short parentTableNo = rs.getShort("ParentTableNo");
				   address.setParentTableNo(parentTableNo);
				   long parentID = rs.getLong("ParentID");
				   address.setParentID(parentID);				   
				   
				   address.setCreateDateTime(rs.getDate("CreateDateTime"));
				   address.setLastUpdateDateTime(rs.getDate("LastUpdateDateTime"));
				   address.setLastUpdateUser(rs.getString("LastUpdateUser"));

				   HashMap<Long, Address> hm = addressMaps.get(parentTableNo);
				   if (hm == null) { // If the input map does NOT have the inner map, create the inner map and set it.
					   hm = new HashMap<Long, Address>();
					   addressMaps.put(parentTableNo, hm);
				   }					   
				   hm.put(parentID, address);
	           }
	           rs.close();
		}
		catch(Exception e) {
			return false;
		}
		
		return true;
	}
	
	public boolean loadCollege(String name, College college) {
		
		String sql = "select CollegeID, Name, CreateDateTime, LastUpdateDateTime, LastUpdateUser "
				   + "from college where Name = ?";
		
		// Load college
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, name);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				   college.setPrimaryKey(rs.getLong("CollegeID"));
				   college.setCollegeID(rs.getLong("CollegeID"));
				   college.setName(rs.getString("Name"));
				   college.setCreateDateTime(rs.getDate("CreateDateTime"));
				   college.setLastUpdateDateTime(rs.getDate("LastUpdateDateTime"));
				   college.setLastUpdateUser(rs.getString("LastUpdateUser"));
	           }
	           rs.close();
		}
		catch(Exception e) {
			return false;
		}
		
		return true;
	}
}
