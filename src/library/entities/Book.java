package library.entities;

import java.util.Date;
import java.util.List;

public class Book {
	
	private int id;
	private String title;
	private String type;
	private List<Author> authors;
	private boolean available;
	private int rentAmount;
	private int returnedToLate;
	private String ISBN;
	private int pages;
	private Date published;
	
	public Book(int id, String title, String type, List<Author> authors, boolean available, int rentAmount, int returnedToLate,
			String iSBN, int pages, Date published) {
		this.id = id;
		this.title = title;
		this.type = type;
		this.authors = authors;
		this.available = available;
		this.rentAmount = rentAmount;
		this.returnedToLate = returnedToLate;
		this.ISBN = iSBN;
		this.pages = pages;
		this.published = published;
	}
	
	public Book(int id, String title, String type, boolean available, int rentAmount, int returnedToLate,
			String iSBN, int pages, Date published) {
		this.id = id;
		this.title = title;
		this.type = type;
		this.available = available;
		this.rentAmount = rentAmount;
		this.returnedToLate = returnedToLate;
		this.ISBN = iSBN;
		this.pages = pages;
		this.published = published;
	}
	
	public Book() {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public List<Author> getAuthors() {
		return authors;
	}
	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	public int getRentAmount() {
		return rentAmount;
	}
	public void setRentAmount(int rentAmount) {
		this.rentAmount = rentAmount;
	}
	public int getReturnedToLate() {
		return returnedToLate;
	}
	public void setReturnedToLate(int returnedToLate) {
		this.returnedToLate = returnedToLate;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	public Date getPublished() {
		return published;
	}
	public void setPublished(Date published) {
		this.published = published;
	}

	@Override
	public String toString() {
		return "Book id=" + id + ", title=" + title + ", authors=" + authors + ", available=" + available
				+ ", rentAmount=" + rentAmount + ", returnedToLate=" + returnedToLate + ", ISBN=" + ISBN + ", pages="
				+ pages + ", published=" + published + "\n";
	}
	
}
