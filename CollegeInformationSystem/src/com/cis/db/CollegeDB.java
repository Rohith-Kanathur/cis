package com.cis.db;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.cis.bo.Address;
import com.cis.bo.College;
import com.cis.bo.Course;
import com.cis.bo.CourseInstance;
import com.cis.bo.Department;
import com.cis.bo.Faculty;
import com.cis.bo.Student;
import com.cis.test.TestTreeBuild;

public class CollegeDB {
	
	private String dbUrl = null;
	private String dbUsername = null;
	private String dbPassword = null;
	private String dbDriver = null;
	
	private Connection con = null;
	
	public CollegeDB() {
		
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

	public boolean loadDepartmentList(short parentTableNo, long parentID, ArrayList<Department> departmentList) {
		String sql = "select DepartmentID, Name, CollegeID, ParentTableNo, ParentID, CreateDateTime, "
				   + "LastUpdateDateTime, LastUpdateUser "
				   + "from department where ParentTableNo = ? and ParentID = ?";
		
		// Load departmentList
		Department department = null;
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setShort(1, parentTableNo);
			ps.setLong(2, parentID);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				   department = new Department();
				   department.setPrimaryKey(rs.getLong("DepartmentID"));
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
	
	public boolean loadFacultyList(short parentTableNo, long parentID, ArrayList<Faculty> facultyList) {
	       
		String sql = "select FacultyID, Name, Designation, CollegeID, ParentTableNo, ParentID, CreateDateTime, "
				   + "LastUpdateDateTime, LastUpdateUser "
				   + "from faculty where ParentTableNo = ? and ParentID = ?";
		
		// Load facultyList
		Faculty faculty = null;
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setShort(1, parentTableNo);
			ps.setLong(2, parentID);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				   faculty = new Faculty();
				   faculty.setPrimaryKey(rs.getLong("FacultyID"));
				   faculty.setFacultyID(rs.getLong("FacultyID"));
				   faculty.setName(rs.getString("Name"));
				   faculty.setCollegeID(rs.getLong("CollegeID"));
				   faculty.setDesignation(rs.getShort("Designation"));
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
	
	public boolean loadCourseList(short parentTableNo, long parentID, ArrayList<Course> courseList) {
		
		String sql = "select CourseID, Name, CollegeID, ParentTableNo, ParentID, CreateDateTime, "
				   + "LastUpdateDateTime, LastUpdateUser "
				   + "from courses where parentTableNo = ? and parentID = ?";
		
		// Load courseList
		Course course = null;
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setShort(1, parentTableNo);
			ps.setLong(2, parentID);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				   course = new Course();
				   course.setPrimaryKey(rs.getLong("CourseID"));
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
	
	public boolean loadCourseInstanceList(short parentTableNo, long parentID, ArrayList<CourseInstance> courseInstanceList) {
		
		String sql = "select CourseInstanceID, StartDate, EndDate, CollegeID, ParentTableNo, ParentID, CreateDateTime, "
				   + "LastUpdateDateTime, LastUpdateUser "
				   + "from courseinstances where ParentTableNo = ? and ParentID = ?";
		
		// Load courseInstanceList
		CourseInstance courseInstance = null;
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setShort(1, parentTableNo);
			ps.setLong(2, parentID);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				   courseInstance = new CourseInstance();
				   courseInstance.setPrimaryKey(rs.getLong("CourseInstanceID"));
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
	
	public boolean loadStudentList(short parentTableNo, long parentID, ArrayList<Student> studentList) {
		
		String sql = "select StudentID, Name, CollegeID, ParentTableNo, ParentID, CreateDateTime, "
				   + "LastUpdateDateTime, LastUpdateUser "
				   + "from student where ParentTableNo = ? and ParentID = ?";
		
		// Load studentList
		Student student = null;
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setShort(1, parentTableNo);
			ps.setLong(2,  parentID);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				   student = new Student();
				   student.setPrimaryKey(rs.getLong("StudentID"));
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
	
	public boolean loadAddress(short parentTableNo, long parentID, Address address) {
		
		String sql = "select AddressID, StreetAddress, Area, City, State, Pincode, Country, " 
				   + "CollegeID, ParentTableNo, ParentID, CreateDateTime, "
				   + "LastUpdateDateTime, LastUpdateUser "
				   + "from address where ParentTableNo = ? and ParentID = ?";
		
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setShort(1, parentTableNo);
			ps.setLong(2, parentID);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				   address.setPrimaryKey(rs.getLong("AddressID"));
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
	           }
	           rs.close();
		}
		catch(Exception e) {
			return false;
		}
		
		return true;
	}
	
	
	
	public boolean loadCollegeTreeUsingBruteForce(College college) {
		// Load College Address
		Address collegeAddress = new Address();
		college.setAddress(collegeAddress);
		if (!loadAddress(college.getTableNo(), college.getPrimaryKey(), collegeAddress))
			return false;
		
		// Load Departments
		ArrayList<Department> departmentList = new ArrayList<Department>();
		college.setDepartmentList(departmentList);
		if (!loadDepartmentList(college.getTableNo(), college.getPrimaryKey(), departmentList))
	       return false;
		
		for (int i = 0; i < departmentList.size(); i++) {
			Department department = departmentList.get(i);
			
			// Load Department Address
			Address departmentAddress = new Address();
			department.setAddress(departmentAddress);
			if (!loadAddress(department.getTableNo(), department.getPrimaryKey(), departmentAddress))
				return false;
			
			// Load Faculty
			ArrayList<Faculty> facultyList = new ArrayList<Faculty>();
			department.setFacultyList(facultyList);
			if (!loadFacultyList(department.getTableNo(), department.getPrimaryKey(), facultyList))
				return false;
			
			for (int j = 0; j < facultyList.size(); j++) {
				Faculty faculty = facultyList.get(j);
				
				// Load Faculty Address
				Address facultyAddress = new Address();
				faculty.setAddress(facultyAddress);
				if (!loadAddress(faculty.getTableNo(), faculty.getPrimaryKey(), facultyAddress))
					return false;
				
			} // End of loop for facultyList 
			
			// Load Courses
			ArrayList<Course> courseList = new ArrayList<Course>();
			department.setCourseList(courseList);
			if (!loadCourseList(department.getTableNo(), department.getPrimaryKey(), courseList))
				return false;
			
			for (int k = 0; k < courseList.size(); k++) {
				Course course = courseList.get(k);
				
				// Load CoursesInstances
				ArrayList<CourseInstance> courseInstanceList = new ArrayList<CourseInstance>();
				course.setCourseInstanceList(courseInstanceList);
				if (!loadCourseInstanceList(course.getTableNo(), course.getPrimaryKey(), courseInstanceList))
					return false;
				
				for (int l = 0; l < courseInstanceList.size(); l++) {
					CourseInstance courseInstance = courseInstanceList.get(l);
					
					// Load Students
					ArrayList<Student> studentList = new ArrayList<Student>();
					courseInstance.setStudentList(studentList);
					if (!loadStudentList(courseInstance.getTableNo(), courseInstance.getPrimaryKey(), studentList))
						return false;
					
					for (int m = 0; m < studentList.size(); m++) {
						Student student = studentList.get(m);
						
						// Load Student Address
						Address studentAddress = new Address();
						student.setAddress(studentAddress);
						if (!loadAddress(student.getTableNo(), student.getPrimaryKey(), studentAddress))
							return false;
						
					} // End of loop for studentList	
			
				} // End of loop for courseInstanceList
				
			} // End of loop for courseList 
			
		} // End of loop for DepartmentList
		
		return true;
	}
	
}
