package library.entities;

import java.util.List;

public class Library {
	
	private List<Book> books;
	private List<LibraryMember> libraryMembers;
	
	public Library() {
		
	}

	public Library(List<Book> books, List<LibraryMember> libraryMembers) {
		super();
		this.books = books;
		this.libraryMembers = libraryMembers;
	}

	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	public List<LibraryMember> getLibraryMembers() {
		return libraryMembers;
	}
	public void setLibraryMembers(List<LibraryMember> libraryMembers) {
		this.libraryMembers = libraryMembers;
	}
	
	@Override
	public String toString() {
		return "Library books=" + books + ", libraryMembers=" + libraryMembers + "\n";
	}
	
}
