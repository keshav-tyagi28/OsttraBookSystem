package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;

import TO.Book;
import TO.User;
import utils.DbConnect;

public class UserDAO {

	
	public void addUser(User user)
	{
		
		DbConnect dbobj= new DbConnect();
		Connection conn= dbobj.connect();
		try {
		PreparedStatement statement =conn.prepareStatement("insert into user values(?,?,?,?)");
		
		statement.setString(1, user.getUsername());
		statement.setString(2, user.getPassword());
		statement.setString(3, user.getName());
		statement.setString(4, user.getRole());
		
		statement.executeUpdate();
		}catch(Exception e) {
			System.out.println("inside userdoa adduser function");
			e.printStackTrace();
		}
		
	}
	
	public User getUser(String username, String password)
	{
		User u=null;
		
		DbConnect dbobj= new DbConnect();
		try {
		Connection conn= dbobj.connect();
		
	
		
		PreparedStatement statement= conn.prepareStatement("select * from user where username=? and password=?");
		
		statement.setString(1, username);
		statement.setString(2, password);
		
		ResultSet resultset =statement.executeQuery();
		
		if(resultset.next())
		{
			String uname=resultset.getString(1);
			String pass=resultset.getString(2);
			String name=resultset.getString(3);
			String role=resultset.getString(4);
		
			u=new User(uname, pass, name, role);
		}
		
		
		
		
	}catch(Exception e)
	
	{
		System.out.println("inside login function");
	}
		return u;	
		
	}
	
	public List<User> getUsers()
	{
		
		List<User> list= new ArrayList<User>();
		
		DbConnect dbobj= new DbConnect();
		try {
		Connection conn= dbobj.connect();
		PreparedStatement statement= conn.prepareStatement("select * from user");
		
		ResultSet resultset =statement.executeQuery();
		if (!resultset.next()) {
	        throw new Exception("No books available.");
	    }
		
		while(resultset.next())
		{
			String username= resultset.getString(1);
			String password=resultset.getString(2);
			String role=resultset.getString(3);
			String name= resultset.getString(4);
			
			User u= new User(username,password,role,name);
			
			list.add(u);
			
			
		}}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
			return list;
	}
	
	
	
}
