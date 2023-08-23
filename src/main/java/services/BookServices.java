package services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import DAO.BookDAO;
import TO.Book;

public class BookServices {

	Scanner sc= new Scanner(System.in);
	
	BookDAO bookdao= new BookDAO();
	public void storeBookInfo()
	{
		String bname,author,id;
		int price;
		
		System.out.println("give the id of Book");
		id=sc.nextLine();
		
		System.out.println("give the name of Book");
		bname=sc.nextLine();
		
		System.out.println("give the author  of Book");
		author=sc.nextLine();
		
		
		System.out.println("give the price of Book");
		price=sc.nextInt();
		
		
		Book book= new Book(id,bname,author,price);
		

		
		bookdao.addBook(book);
		
	}
	
	public void getAllBooks()
	{
		
		List<Book> books;
		
		books= bookdao.getAll();
		
		for(Book b: books)
		{
			System.out.print(b.getId()+ " ");
			System.out.print(b.getBname()+ " ");
			System.out.print(b.getAuthor()+ " ");
			System.out.print(b.getPrice()+ " ");
			System.out.println();
		}
		System.out.println();
	}
	
	public void update()
	{
		String userchoiceid;
		System.out.println("Enter the id of book u want to update");
		userchoiceid= sc.nextLine();
		
		int price;
		System.out.println("Enter the new price");
		price=sc.nextInt();
		
		
		bookdao.updateBook(userchoiceid,price);
	}
	
	public void deleteInfo()
	{
		String userchoiceid;
		System.out.println("Enter the id of book u want to delete");
		userchoiceid= sc.nextLine();
		
		bookdao.deleteBook(userchoiceid);
	}
	
	public void getBook()
	{
		String userchoiceid;
		System.out.println("Enter the id of book u want to see");
		userchoiceid= sc.nextLine();
		
		Book b= bookdao.getDetails(userchoiceid);
		
		if(b==null)
			System.out.println("NO Book Found");
		
		        else {
            System.out.print(b.getId()+ " ");
            System.out.print(b.getBname() + " ");
            System.out.print(b.getAuthor() + " ");
            System.out.print(b.getPrice() + " ");
            System.out.println();
        } 	
	}
	
	
	
}
