package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import TO.Book;
import utils.DbConnect;

public class BookDAO {

	
	public void addBook(Book book)
	{
		
		DbConnect dbobj= new DbConnect();
		Connection conn= dbobj.connect();
		try {
		PreparedStatement statement =conn.prepareStatement("insert into book values(?,?,?,?)");
		
		statement.setString(1, book.getId());
		statement.setString(2, book.getBname());
		statement.setString(3, book.getAuthor());
		statement.setLong(4, book.getPrice());
		
		statement.executeUpdate();
		
		}catch(Exception e) {
			System.out.println("inside bookdao addbook function");
			e.printStackTrace();
		}
		
		
	}
	
	public List<Book> getAll()
	{
		
		DbConnect dbobj= new DbConnect();
		Connection conn= dbobj.connect();
		List<Book> books= new ArrayList<>();
		try {
		PreparedStatement statement =conn.prepareStatement("select * from book");
		
		ResultSet resultset =statement.executeQuery();
		
		if (!resultset.next()) {
		    System.out.println("No books available.");
		}
	
		
		while(resultset.next())
		{
			String id= resultset.getString(1);
			String bname=resultset.getString(2);
			String author=resultset.getString(3);
			int price= resultset.getInt(4);
			
			Book b= new Book(id,bname,author,price);
			
			books.add(b);
			
			
		}}
		catch(Exception e)
		
		{
			e.printStackTrace();
			System.out.println("inside getallbook function");
		}
		
		return books;
	}
	
	public void updateBook(String id, int price)
	{
		
		DbConnect dbobj= new DbConnect();
		Connection conn= dbobj.connect();
		
		try {
		PreparedStatement statement =conn.prepareStatement("UPDATE  book SET price=? where id=?");
		
		statement.setLong(1, price);
		statement.setString(2, id);
		
		int rowaffect= statement.executeUpdate();
		
		if(rowaffect>0)
			System.out.println("successfully updated");
		else
			System.out.println("no record found");
		
		}catch(Exception E)
		{
			E.printStackTrace();
			System.out.println("inside update book");
		}
		
		
		
		
	}
	
	public void deleteBook(String id)
	{
		DbConnect dbobj= new DbConnect();
		Connection conn= dbobj.connect();
		
		try {
			PreparedStatement statement =conn.prepareStatement("DELETE from book where id=?");
			
			statement.setString(1, id);
			
			int rowaffect= statement.executeUpdate();
			
			if(rowaffect>0)
				System.out.println("successfully deleted");
			else
				System.out.println("no record found");
			
		}catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("inside delete book");
		}
		
	}
	
	public Book getDetails(String id)
	{
		DbConnect dbobj= new DbConnect();
		Connection conn= dbobj.connect();
		Book b=null;
			
		
		try {
			PreparedStatement statement =conn.prepareStatement("Select * from book where id=?");
			
			statement.setString(1, id);
			
			ResultSet resultset=  statement.executeQuery();
			
			if (!resultset.next()) {
		        System.out.println("Wrong id try again");
		    } 


			
			else {
				String bid= resultset.getString(1);
				String bname=resultset.getString(2);
				String author=resultset.getString(3);
				int price= resultset.getInt(4);
				
				 b= new Book(bid,bname,author,price);
			}
		
		}
			
			
			
			catch(Exception e)
			
			{
				e.printStackTrace();
				System.out.println("inside getDetail of BOok");
			}	
		
		return b;
	}
	
	
	
}
