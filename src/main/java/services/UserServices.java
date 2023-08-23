package services;

import java.util.List;
import java.util.Scanner;

import DAO.UserDAO;
import TO.User;

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
			System.out.print(u.getUsername()+ " ");
			System.out.print(u.getName()+ " ");
			System.out.print(u.getRole()+ " ");
			System.out.println();
		}
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
