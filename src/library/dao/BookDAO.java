package library.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import library.entities.Book;

public class BookDAO {
	
	private static final String DRIVER = "org.sqlite.JDBC";
    private static final String DB_URL = "jdbc:sqlite:C:\\Users\\pawelw\\Desktop\\library_database\\libraryDatabase.db";
    private static final String ADD_BOOK_QUERY = "INSERT INTO books VALUES (NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String EDIT_BOOK_QUERY = "UPDATE books SET title=?, type=?, available=?, rentAmount=?, returnedToLate=?, isbn=?, pages=?, published=? WHERE id=?;";
    private static final String DELETE_BOOK_QUERY = "DELETE FROM books WHERE id = ?";
    private static final String GET_BOOKS_QUERY = "SELECT id,title,type,simpleAuthorId,available,rentAmount,returnedToLate,isbn,pages,published FROM books;";
    private static final String ADD_BOOKS_AUTHORS_QUERY = "INSERT INTO books_authors VALUES (NULL, ?, ?);";
    private static final String GET_AUTHORS_BY_BOOK_ID_QUERY = "SELECT author_id FROM books_authors WHERE book_id = ";
    private static final String GET_BOOK_BY_ID_QUERY = "SELECT id,title,type,simpleAuthorId,available,rentAmount,returnedToLate,isbn,pages,published FROM books WHERE id = ";
    private static final String REMOVE_AUTHOR_FROM_BOOK_QUERY = "DELETE FROM books_authors WHERE book_id=? AND author_id=?;";
    
    private Connection conn;
    private Statement stat;
    
    public BookDAO() {
    	
    	try {
            Class.forName(BookDAO.DRIVER);
        } catch (ClassNotFoundException e) {
            System.err.println("No JDBC driver");
            e.printStackTrace();
        }
 
        try {
            conn = DriverManager.getConnection(DB_URL);
            stat = conn.createStatement();
        } catch (SQLException e) {
            System.err.println("DB connection error");
            e.printStackTrace();
        }
    	
    }
	
	public boolean persistBook(String title, String type, boolean available, int rentAmount, int returnedToLate, String isbn, int pages, String published) {
		
		try {
            PreparedStatement prepStmtBook = conn.prepareStatement(ADD_BOOK_QUERY);
            prepStmtBook.setString(1, title);
            prepStmtBook.setString(2, type);
            prepStmtBook.setInt(3, 0);
            prepStmtBook.setBoolean(4, available);
            prepStmtBook.setInt(5, rentAmount);
            prepStmtBook.setInt(6, returnedToLate);
            prepStmtBook.setString(7, isbn);
            prepStmtBook.setInt(8, pages);
            prepStmtBook.setString(9, published);
            prepStmtBook.execute();
        } catch (SQLException e) {
            System.err.println("Book persist error");
            e.printStackTrace();
            return false;
        }
		
		return true;
	}
	
	public Book getBookById(String bookId) {
		Book book  = new Book();
		try {
			ResultSet result = stat.executeQuery(GET_BOOK_BY_ID_QUERY + bookId + ";");
			while(result.next()) {
				book.setId(result.getInt("id"));
				book.setTitle(result.getString("title"));
				book.setType(result.getString("type"));
				book.setAvailable(result.getBoolean("available"));
				book.setRentAmount(result.getInt("rentAmount"));
				book.setReturnedToLate(result.getInt("returnedToLate"));
				book.setISBN(result.getString("isbn"));
				book.setPages(result.getInt("pages"));
				String published = result.getString("published");
				String pattern = "yyyy-MM-dd";
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
                java.util.Date publishedDate = null;
				try {
					publishedDate = simpleDateFormat.parse(published);
				} catch (ParseException e) {
					System.out.println("Parse published date error");
					e.printStackTrace();
				}
				book.setPublished(publishedDate);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("getBookById error");
			return null;
		}
		return book;
	}
	
	public boolean addBooksAuthors(String bookId, String authorId) {
		
		try {
			PreparedStatement prepStmtBooksAuthors = conn.prepareStatement(ADD_BOOKS_AUTHORS_QUERY);
			prepStmtBooksAuthors.setInt(1, Integer.parseInt(bookId));
			prepStmtBooksAuthors.setInt(2, Integer.parseInt(authorId));
			prepStmtBooksAuthors.execute();
		} catch (SQLException e) {
			System.err.println("Add book's authors error");
            e.printStackTrace();
            return false;
		}
		
		return true;
	}
	
	public List<Integer> getAuthorsIdByBookId(String bookId) {
		List<Integer> authorsIds = new ArrayList<>();
		try {
			ResultSet result = stat.executeQuery(GET_AUTHORS_BY_BOOK_ID_QUERY + bookId + ";");
			while(result.next()) {
				authorsIds.add(result.getInt("author_id"));
			}
		} catch (SQLException e) {
			System.out.println("getAuthorsIdByBookId error");
            e.printStackTrace();
		}
		return authorsIds;
		
	}
	
	public boolean removeAuthorFromBook(String bookId, String authorId) {
		try {
			PreparedStatement prepStmt = conn.prepareStatement(REMOVE_AUTHOR_FROM_BOOK_QUERY);
			prepStmt.setString(1, bookId);
			prepStmt.setString(2, authorId);
			prepStmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Remove author from book error");
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public List<Book> getBooks() {
        List<Book> books = new ArrayList<>();
        try {
            ResultSet result = stat.executeQuery(GET_BOOKS_QUERY);
            int id, /*simpleAuthorId,*/ rentAmount, returnedToLate, pages;
            String title, type, isbn;
            boolean available;
            String published;
            //List<Author> authors = getAuthorsByForeignKey();
            while(result.next()) {
                id = result.getInt("id");
                title = result.getString("title");
                type = result.getString("type");
//                simpleAuthorId = result.getInt("simpleAuthorId");
                available = result.getBoolean("available");
                rentAmount = result.getInt("rentAmount");
                returnedToLate = result.getInt("returnedToLate");
                isbn = result.getString("isbn");
                pages = result.getInt("pages");
                published = result.getString("published");
                String pattern = "yyyy-MM-dd";
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
                java.util.Date publishedDate = null;
				try {
					publishedDate = simpleDateFormat.parse(published);
				} catch (ParseException e) {
					System.out.println("Parse published date error");
					e.printStackTrace();
				}
                books.add(new Book(id, title, type, available, rentAmount, returnedToLate, isbn, pages, publishedDate));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return books;	// ZROBIC METODE ZWRACAJACA LISTE AUTOROW NA PODSTAWIE FOREIGNKEY Z BOOK
    }
	
	public boolean editBook(String title, String type, boolean available, int rentAmount, int returnedToLate, String isbn, int pages, String published, String id) {
		try {
            PreparedStatement prepStmt = conn.prepareStatement(EDIT_BOOK_QUERY);
            prepStmt.setString(1, title);
            prepStmt.setString(2, type);
            prepStmt.setBoolean(3, available);
            prepStmt.setInt(4, rentAmount);
            prepStmt.setInt(5, returnedToLate);
            prepStmt.setString(6, isbn);
            prepStmt.setInt(7, pages);
            prepStmt.setString(8, published);
            prepStmt.setString(9, id);
            prepStmt.execute();
        } catch (SQLException e) {
            System.err.println("Book edit error");
            e.printStackTrace();
            return false;
        }
		
		return true;
	}
	
	public boolean deleteBook(String id) {
		try {
			PreparedStatement prepStmt = conn.prepareStatement(DELETE_BOOK_QUERY);
			prepStmt.setString(1, id);
			prepStmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Book delete error");
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public void closeConnection() {
        try {
            conn.close();
        } catch (SQLException e) {
            System.err.println("Closing connection error");
            e.printStackTrace();
        }
    }

}
