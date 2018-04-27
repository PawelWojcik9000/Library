package library.entities;

import java.util.List;

public class LibraryMember {
	
	private int id;
	private String name;
	private String surName;
	private List<Integer> rentedBookId;
	private String address;
	private String phoneNumber;
	
	public LibraryMember(int id, String name, String surName, List<Integer> rentedBookId, String address,
			String phoneNumber) {
		super();
		this.id = id;
		this.name = name;
		this.surName = surName;
		this.rentedBookId = rentedBookId;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}
	public LibraryMember(int id, String name, String surName, String address, String phoneNumber) {
		super();
		this.id = id;
		this.name = name;
		this.surName = surName;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}
	
	public LibraryMember() {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurName() {
		return surName;
	}
	public void setSurName(String surName) {
		this.surName = surName;
	}
	public List<Integer> getRentedBookId() {
		return rentedBookId;
	}
	public void setRentedBookId(List<Integer> rentedBookId) {
		this.rentedBookId = rentedBookId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	@Override
	public String toString() {
		return "LibraryMember id=" + id + ", name=" + name + ", surName=" + surName + ", rentedBookId=" + rentedBookId
				+ ", address=" + address + ", phoneNumber=" + phoneNumber + "\n";
	}
	

}
