package library.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import library.entities.Author;

public class AuthorDAO {
	
	private static final String DRIVER = "org.sqlite.JDBC";
    private static final String DB_URL = "jdbc:sqlite:C:\\Users\\pawelw\\Desktop\\library_database\\libraryDatabase.db";
    private static final String ADD_AUTHOR_QUERY = "INSERT INTO authors VALUES (NULL, ?, ?, NULL);";
    private static final String EDIT_AUTHOR_QUERY = "UPDATE authors SET name=?, surname=? WHERE id=?;";
    private static final String SET_FOREIGNKEY_QUERY = "UPDATE authors SET book_id=? WHERE id=?;";
    private static final String DELETE_AUTHOR_QUERY = "DELETE FROM authors WHERE id = ?";
    private static final String GET_AUTHORS_QUERY = "SELECT id,name,surname FROM authors;";
    private static final String GET_AUTHORS_BY_ID_QUERY = "SELECT id,name,surname FROM authors WHERE id = ";
    
    private Connection conn;
    private Statement stat;
    
    public AuthorDAO() {
    	
    	try {
            Class.forName(AuthorDAO.DRIVER);
        } catch (ClassNotFoundException e) {
            System.err.println("No JDBC driver");
            e.printStackTrace();
        }
 
        try {
            conn = DriverManager.getConnection(DB_URL);
            stat = conn.createStatement();
            //System.out.println("Author CRUD");
        } catch (SQLException e) {
            System.err.println("DB connection error");
            e.printStackTrace();
        }
    	
    }
	
	public boolean persistAuthor(String name, String surname) {
		
		try {
            PreparedStatement prepStmt = conn.prepareStatement(ADD_AUTHOR_QUERY);
            prepStmt.setString(1, name);
            prepStmt.setString(2, surname);
            prepStmt.execute();
        } catch (SQLException e) {
            System.err.println("Author persist error");
            e.printStackTrace();
            return false;
        }
		
		return true;
	}
	
	public Author getAuthorById(Integer authorId) {
		Author author = new Author();
		try {
			ResultSet result = stat.executeQuery(GET_AUTHORS_BY_ID_QUERY + authorId + ";");
			while(result.next()) {
				author.setId(result.getInt("id"));
                author.setName(result.getString("name"));
                author.setSurname(result.getString("surname"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("getAuthorById error");
			return null;
		}
		return author;
	}
	
	public List<Author> getAuthors() {
        List<Author> authors = new ArrayList<>();
        try {
            ResultSet result = stat.executeQuery(GET_AUTHORS_QUERY);
            int id;
            String name, surname;
            while(result.next()) {
                id = result.getInt("id");
                name = result.getString("name");
                surname = result.getString("surname");
                authors.add(new Author(id, name, surname));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return authors;
    }
	
	public List<Author> getAuthorsById(String authorId) {
        List<Author> authors = new ArrayList<>();
        try {
            ResultSet result = stat.executeQuery(GET_AUTHORS_BY_ID_QUERY + authorId + ";");
            int id;
            String name, surname;
            while(result.next()) {
                id = result.getInt("id");
                name = result.getString("name");
                surname = result.getString("surname");
                authors.add(new Author(id, name, surname));
            }
        } catch (SQLException e) {
            System.out.println("getAuthorsById error");
        	e.printStackTrace();
            return null;
        }
        return authors;
    }
	
	public boolean editAuthor(String id, String name, String surname) {
		try {
            PreparedStatement prepStmt = conn.prepareStatement(EDIT_AUTHOR_QUERY);
            prepStmt.setString(1, name);
            prepStmt.setString(2, surname);
            prepStmt.setString(3, id);
            prepStmt.execute();
        } catch (SQLException e) {
            System.err.println("Author edit error");
            e.printStackTrace();
            return false;
        }
		
		return true;
	}
	
	public boolean setAuthorsForeignKey(String id, String foreignId) {
		try {
			PreparedStatement prepStmt = conn.prepareStatement(EDIT_AUTHOR_QUERY);
			prepStmt.setString(1, foreignId);
			prepStmt.setString(2, id);
		} catch (SQLException e) {
			System.err.println("Author foreign key set error");
            e.printStackTrace();
            return false;
		}
		
		return true;
	}
	
	public boolean deleteAuthor(String id) {
		try {
			PreparedStatement prepStmt = conn.prepareStatement(DELETE_AUTHOR_QUERY);
			prepStmt.setString(1, id);
			prepStmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Author delete error");
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
