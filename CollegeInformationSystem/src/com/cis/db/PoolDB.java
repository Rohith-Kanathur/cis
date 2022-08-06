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
				   department.setDepartmentID(rs.getLong("DepartmentID"));
				   department.setName(rs.getString("Name"));
				   department.setCollegeID(rs.getLong("CollegeID"));
				   department.setParentTableNo(rs.getShort("ParentTableNo"));
				   department.setParentID(rs.getLong("ParentID"));
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
	
	public boolean loadFacultyList(long collegeID, ArrayList<Faculty> facultyList) {
		
		String sql = "select FacultyID, Name, Designation, CollegeID, ParentTableNo, ParentID, CreateDateTime, "
				   + "LastUpdateDateTime, LastUpdateUser "
				   + "from faculty where CollegeID = ? order by ParentTableNo, ParentID";
		
		// Load facultyList
		Faculty faculty = null;
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setLong(1, collegeID);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				   faculty = new Faculty();
				   faculty.setFacultyID(rs.getLong("FacultyID"));
				   faculty.setName(rs.getString("Name"));
				   faculty.setCollegeID(rs.getLong("CollegeID"));
				   faculty.setParentTableNo(rs.getShort("ParentTableNo"));
				   faculty.setParentID(rs.getLong("ParentID"));
				   faculty.setCreateDateTime(rs.getDate("CreateDateTime"));
				   faculty.setLastUpdateDateTime(rs.getDate("LastUpdateDateTime"));
				   faculty.setLastUpdateUser(rs.getString("LastUpdateUser"));
				   facultyList.add(faculty);
	           }
	           rs.close();
		}
		catch(Exception e) {
			return false;
		}
		
		return true;
	}
	

	public boolean loadCourseList(long collegeID, ArrayList<Course> courseList) {
		String sql = "select CourseID, Name, CollegeID, ParentTableNo, ParentID, CreateDateTime, "
				   + "LastUpdateDateTime, LastUpdateUser "
				   + "from courses where CollegeID = ? order by ParentTableNo, ParentID";
		
		// Load courseList
		Course course = null;
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setLong(1, collegeID);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				   course = new Course();
				   course.setCourseID(rs.getLong("CourseID"));
				   course.setName(rs.getString("Name"));
				   course.setCollegeID(rs.getLong("CollegeID"));
				   course.setParentTableNo(rs.getShort("ParentTableNo"));
				   course.setParentID(rs.getLong("ParentID"));
				   course.setCreateDateTime(rs.getDate("CreateDateTime"));
				   course.setLastUpdateDateTime(rs.getDate("LastUpdateDateTime"));
				   course.setLastUpdateUser(rs.getString("LastUpdateUser"));
	               courseList.add(course);
	           }
	           rs.close();
		}
		catch(Exception e) {
			return false;
		}
		
		return true;
	}

	public boolean loadCourseInstanceList(long collegeID, ArrayList<CourseInstance> courseInstanceList) {
		
		String sql = "select CourseInstanceID, StartDate, EndDate, CollegeID, ParentTableNo, ParentID, CreateDateTime, "
				   + "LastUpdateDateTime, LastUpdateUser "
				   + "from department where CollegeID = ? order by ParentTableNo, ParentID";
		
		// Load courseInstanceList
		CourseInstance courseInstance = null;
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setLong(1, collegeID);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				   courseInstance = new CourseInstance();
				   courseInstance.setCourseInstanceID(rs.getLong("CourseInstanceID"));
				   courseInstance.setStartDate(rs.getDate("StartDate"));
				   courseInstance.setEndDate(rs.getDate("EndDate"));
				   courseInstance.setCollegeID(rs.getLong("CollegeID"));
				   courseInstance.setParentTableNo(rs.getShort("ParentTableNo"));
				   courseInstance.setParentID(rs.getLong("ParentID"));
				   courseInstance.setCreateDateTime(rs.getDate("CreateDateTime"));
				   courseInstance.setLastUpdateDateTime(rs.getDate("LastUpdateDateTime"));
				   courseInstance.setLastUpdateUser(rs.getString("LastUpdateUser"));
				   courseInstanceList.add(courseInstance);
	           }
	           rs.close();
		}
		catch(Exception e) {
			return false;
		}
		
		return true;
	}

	public boolean loadStudentList(long collegeID, ArrayList<Student> studentList) {
		
		String sql = "select StudentID, Name, CollegeID, ParentTableNo, ParentID, CreateDateTime, "
				   + "LastUpdateDateTime, LastUpdateUser "
				   + "from courses where CollegeID = ? order by ParentTableNo, ParentID";
		
		// Load studentList
		Student student = null;
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setLong(1, collegeID);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				   student = new Student();
				   student.setStudentID(rs.getLong("StudentID"));
				   student.setName(rs.getString("Name"));
				   student.setCollegeID(rs.getLong("CollegeID"));
				   student.setParentTableNo(rs.getShort("ParentTableNo"));
				   student.setParentID(rs.getLong("ParentID"));
				   student.setCreateDateTime(rs.getDate("CreateDateTime"));
				   student.setLastUpdateDateTime(rs.getDate("LastUpdateDateTime"));
				   student.setLastUpdateUser(rs.getString("LastUpdateUser"));
				   studentList.add(student);
	           }
	           rs.close();
		}
		catch(Exception e) {
			return false;
		}
		
		return true;

	}

	public boolean loadAddressList(long collegeID, ArrayList<Address> addressList) {
		
		String sql = "select AddressID, StreetAddress, Area, City, State, Pincode, Country, " 
				   + "CollegeID, ParentTableNo, ParentID, CreateDateTime, "
				   + "LastUpdateDateTime, LastUpdateUser "
				   + "from address where AddressID = ? order by ParentTableNo, ParentID";
		
		// Load addressList
		Address address = null;
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setLong(1, collegeID);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				   address = new Address();
				   address.setAddressID(rs.getLong("AddressID"));
				   address.setStreetAddress(rs.getString("StreetAddress"));
				   address.setArea(rs.getString("Area"));
				   address.setCity(rs.getString("City"));
				   address.setState(rs.getString("State"));
				   address.setPinCode(rs.getString("PinCode"));
				   address.setCountry(rs.getString("Country"));
				   address.setCollegeID(rs.getLong("CollegeID"));
				   address.setParentTableNo(rs.getShort("ParentTableNo"));
				   address.setParentID(rs.getLong("ParentID"));
				   address.setCreateDateTime(rs.getDate("CreateDateTime"));
				   address.setLastUpdateDateTime(rs.getDate("LastUpdateDateTime"));
				   address.setLastUpdateUser(rs.getString("LastUpdateUser"));
				   addressList.add(address);
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
