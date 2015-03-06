package base;

import java.util.ArrayList;
import java.util.Date;

public class User implements Comparable<User>{
	private int id;
	private String userName;
	private String email;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public User(int id, String userName, String email) {
		super();
		this.id = id;
		this.userName = userName;
		this.email = email;		
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + id;
		result = prime * result
				+ ((userName == null) ? 0 : userName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id != other.id)
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "name: "+ getUserName() + " id: " + getId() + " email: " + getEmail();
	}

	@Override
	public int compareTo(User o) {
		/*
		 * The compareTo(User u) method compares this user with the input user u. Since we want to sort by user ID, the behavior of compareTo(User u) is:
		 * 1. Return 1 if this user’s ID is greater than u’s ID
		 * 2. Return -1 if this user’s ID is less than u’s ID
		 * 3. Return 0 if this user’s ID equals to u’s ID
		 */
		
		if (this.getId() == o.getId()){
			return 0;
		}
		else if (this.getId() < o.getId()){
			return -1;
		}
		else 
			return 1;
	}
}
