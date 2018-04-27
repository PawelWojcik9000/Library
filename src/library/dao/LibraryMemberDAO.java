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
import library.entities.LibraryMember;

public class LibraryMemberDAO {

	private static final String DRIVER = "org.sqlite.JDBC";
	private static final String DB_URL = "jdbc:sqlite:C:\\Users\\pawelw\\Desktop\\library_database\\libraryDatabase.db";
	private static final String ADD_LIBRARY_MEMBER_QUERY = "INSERT INTO library_members VALUES (NULL, ?, ?, ?, ?);";
	private static final String GET_LIBRARY_MEMBERS_QUERY = "SELECT id, name, surname, address, phoneNumber FROM library_members;";
	private static final String EDIT_LIBRARY_MEMBER_QUERY = "UPDATE library_members SET name=?, surname=?, address=?, phoneNumber=? WHERE id = ?;";
	private static final String DELETE_LIBRARY_MEMBER_QUERY = "DELETE FROM library_members WHERE id = ?;";
	private static final String GET_LIBRARY_MEMBER_BY_ID_QUERY = "SELECT id, name, surname, address, phoneNumber FROM library_members WHERE id = ";

	private Connection conn;
	private Statement stat;

	public LibraryMemberDAO() {

		try {
			Class.forName(LibraryMemberDAO.DRIVER);
		} catch (ClassNotFoundException e) {
			System.err.println("No JDBC driver");
			e.printStackTrace();
		}

		try {
			conn = DriverManager.getConnection(DB_URL);
			stat = conn.createStatement();
			// System.out.println("Author CRUD");
		} catch (SQLException e) {
			System.err.println("DB connection error");
			e.printStackTrace();
		}
	}

	public boolean persistLibraryMember(String name, String surname, String address, String phoneNumber) {

		try {
			PreparedStatement prepStmt = conn.prepareStatement(ADD_LIBRARY_MEMBER_QUERY);
			prepStmt.setString(1, name);
			prepStmt.setString(2, surname);
			prepStmt.setString(3, address);
			prepStmt.setString(4, phoneNumber);
			prepStmt.execute();
		} catch (SQLException e) {
			System.out.println("Library member persist error");
			e.printStackTrace();
			return false;
		}

		return true;
	}
	
	public LibraryMember getLibraryMemberById(String libMemberId) {
		LibraryMember libmember = new LibraryMember();
		try {
			ResultSet result = stat.executeQuery(GET_LIBRARY_MEMBER_BY_ID_QUERY + libMemberId + ";");
			while(result.next()) {
				libmember.setId(result.getInt("id"));
                libmember.setName(result.getString("name"));
                libmember.setSurName(result.getString("surname"));
                libmember.setAddress(result.getString("address"));
                libmember.setPhoneNumber(result.getString("phoneNumber"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("getLibraryMemberById error");
			return null;
		}
		return libmember;
	}
	
	public List<LibraryMember> getLibraryMembers() {
        List<LibraryMember> libraryMembers = new ArrayList<>();
        try {
            ResultSet result = stat.executeQuery(GET_LIBRARY_MEMBERS_QUERY);
            int id;
            String name, surname, address, phoneNumber;
            while(result.next()) {
                id = result.getInt("id");
                name = result.getString("name");
                surname = result.getString("surname");
                address = result.getString("address");
                phoneNumber = result.getString("phoneNumber");
                libraryMembers.add(new LibraryMember(id, name, surname, address, phoneNumber));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return libraryMembers;
    }
	
	public boolean editLibraryMember(String id, String name, String surname, String address, String phoneNumber) {
		try {
            PreparedStatement prepStmt = conn.prepareStatement(EDIT_LIBRARY_MEMBER_QUERY);
            prepStmt.setString(1, name);
            prepStmt.setString(2, surname);
            prepStmt.setString(3, address);
            prepStmt.setString(4, phoneNumber);
            prepStmt.setString(5, id);
            prepStmt.execute();
        } catch (SQLException e) {
            System.out.println("Library member edit error");
            e.printStackTrace();
            return false;
        }
		
		return true;
	}
	
	public boolean deleteLibraryMember(String id) {
		try {
			PreparedStatement prepStmt = conn.prepareStatement(DELETE_LIBRARY_MEMBER_QUERY);
			prepStmt.setString(1, id);
			prepStmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Library member delete error");
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
