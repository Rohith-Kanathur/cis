package com.cis.db;

import com.cis.bo.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PoolDB {
	
	private String dbUrl = "jdbc:mysql://localhost:3306/cis";
	private String dbUname = "root";
	private String dbPassword = "rohith";
	private String dbDriver = "com.mysql.cj.jdbc.Driver";
	
	public PoolDB() {
	}
	
	public void loadDriver(String dbDriver) {
		try {
			Class.forName(dbDriver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(dbUrl, dbUname, dbPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		return con;
	}
	
	public boolean loadDepartmentList(long collegeID, ArrayList<Department> departmentList) {
		
		loadDriver(dbDriver);
		Connection con = getConnection();
		
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
		// Load facultyList
		try {
			// select FacultyID, Name, Designation, CollegeID, ParentTableNo, ParentID, CreateDateTime, LastUpdateDateTime, LastUpdateUser 
			// from faculty where CollegeID=collegeID Order By ParentTableNo, ParentID
		}
		catch(Exception e) {
	
			return false;
		}
		
		return true;
		
	}
	
	public boolean loadCollege(String name, College college) {
		// Load college
		try {
			// select CollegeID, Name, CreateDateTime, LastUpdateDateTime, LastUpdateUser 
			// from college where Name=name
			
		}
		catch(Exception e) {
	
			return false;
		}
		
		return true;
	}

	public boolean loadCourseList(long collegeID, ArrayList<Course> courseList) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean loadCourseInstanceList(long collegeID, ArrayList<CourseInstance> courseInstanceList) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean loadStudentList(long collegeID, ArrayList<Student> studentList) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean loadAddressList(long collegeID, ArrayList<Address> addressList) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
