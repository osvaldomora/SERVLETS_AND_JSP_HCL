package ola.com.booking.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ola.com.booking.ConectionManager;
import ola.com.booking.dao.UserDao;
import ola.com.booking.model.User;

public class UserDaoImpl implements UserDao {

	Connection conn= ConectionManager.getConnection();
	
	@Override
	public void saveUser(User user) {
		try {
			PreparedStatement stmt = conn.prepareStatement("insert into User (email, name, password, phoneNo) values (?,?,?,?)");
//			stmt.setInt(1, user.getuserId());
			stmt.setString(1, user.getEmail());
			stmt.setString(2,user.getName());
			stmt.setString(3, user.getPassword());
			stmt.setString(4, user.getPhoneNo());
			
			stmt.execute();
			
			


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	@Override
	public String validateUser(String username, String password) {
		String userId=null;
		try {System.out.println(username);
		System.out.println(password);
			
			PreparedStatement stmt = conn.prepareStatement("SELECT userId FROM User WHERE name=? and password=?");//SELECT EXISTS(SELECT * FROM User WHERE name=? and password=?)
		    stmt.setString(1, username);
		    stmt.setString(2, password);
		    ResultSet rs=stmt.executeQuery();
		    System.out.println("dsssswd");
		    while(rs.next())
		    {System.out.println("wwwww");
		    	userId=rs.getString("userId");
		    	
		    }
		    System.out.println("userId:"+userId);
		    rs.close();		    
//		    return   stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return userId;
	}

}
