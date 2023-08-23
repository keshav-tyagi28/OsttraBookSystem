package TO;

public class Book {

	private String id;
	private String bname;
	private String author;
	private int price;
	
	public Book(String id, String bname, String author, int price) {
		super();
		this.id = id;
		this.bname = bname;
		this.author = author;
		this.price = price;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
	
}
