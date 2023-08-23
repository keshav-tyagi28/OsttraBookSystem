package com.osttra.services;

import java.util.List;
import java.util.Scanner;

import com.osttra.dao.UserDAO;
import com.osttra.to.User;

public  class UserServices {

	public  Scanner sc= new Scanner(System.in);
	public UserDAO userdao= new UserDAO();
	
	public void register() {
		
		
		String uname, password, role,name;
		System.out.println("enter your desired username");
		uname=sc.nextLine();
		
		
		System.out.println("enter your password");
		password=sc.nextLine();
		
		System.out.println("enter your name");
		name=sc.nextLine();
		
		
		System.out.println("enter your role");
		role=sc.nextLine();
		
		
		
		User u= new User(uname,password,name,role);
		
		userdao.addUser(u);
	}
	public User login() {
		
		boolean login=false;
		
		String uname, password, role,name;
		System.out.println("enter your  username");
		uname=sc.nextLine();
		
		
		System.out.println("enter your password");
		password=sc.nextLine();
		
		
		User u =userdao.getUser(uname,password);
		
		if(u!=null)
		{
			login=true;
		}
		
		return u;	
		
		
	}
	
	public void getAllUsers()
	{
		
		List<User> users= userdao.getUsers();
		
		for(User u : users)
		{
			System.out.println("Username- " +u.getUsername()+ " ");
			System.out.println("Name- " + u.getName()+ " ");
			System.out.println("Role-" +u.getRole()+ " ");
			System.out.println();
		}
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
