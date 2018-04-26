package library.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class LibraryDAO {
	
	private static final String DRIVER = "org.sqlite.JDBC";
    private static final String DB_URL = "jdbc:sqlite:C:\\Users\\pawelw\\Desktop\\library_database\\libraryDatabase.db";
    private static final String CREATE_AUTHORS_TABLE = "CREATE TABLE IF NOT EXISTS authors (id INTEGER PRIMARY KEY AUTOINCREMENT, name varchar(255), surname varchar(255), "
    		+ "book_id int, foreign key(book_id) references books(id));";
    private static final String CREATE_BOOKS_TABLE = "CREATE TABLE IF NOT EXISTS books (id INTEGER PRIMARY KEY AUTOINCREMENT, title varchar(255), type varchar(255), "
    		+ "simpleAuthorId int, available int, rentAmount int, returnedToLate int, isbn character(17), pages int, published date);";
    private static final String CREATE_LIBRARY_MEMBERS_TABLE = "CREATE TABLE IF NOT EXISTS library_members (id INTEGER PRIMARY KEY AUTOINCREMENT, name varchar(255), surname varchar(255), "
    		+ "address varchar(255), phoneNumber varchar(255));";
    private static final String CREATE_AUTHORS_BOOKS_TABLE = "CREATE TABLE IF NOT EXISTS books_authors (id INTEGER PRIMARY KEY AUTOINCREMENT, book_id int, author_id int, "
    		+ "FOREIGN KEY(book_id) REFERENCES books(id), FOREIGN KEY(author_id) REFERENCES authors(id));";
    
    private Connection conn;
    private Statement stat;
    
    public LibraryDAO() {
    	
    	try {
            Class.forName(LibraryDAO.DRIVER);
        } catch (ClassNotFoundException e) {
            System.err.println("No JDBC driver");
            e.printStackTrace();
        }
 
        try {
            conn = DriverManager.getConnection(DB_URL);
            stat = conn.createStatement();
            System.out.println("DB connected");
        } catch (SQLException e) {
            System.err.println("DB connection error");
            e.printStackTrace();
        }
 
        createTables();
    	
    }
    
    public boolean createTables()  {
        
        try {
            stat.execute(CREATE_AUTHORS_TABLE);
            stat.execute(CREATE_BOOKS_TABLE);
            stat.execute(CREATE_LIBRARY_MEMBERS_TABLE);
            stat.execute(CREATE_AUTHORS_BOOKS_TABLE);
            System.out.println("Created tables authors, books, librarymembers");
        } catch (SQLException e) {
            System.err.println("Table creating error");
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
