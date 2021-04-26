package com.roytuts.jpa.hibernate.composite.primary.key;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@IdClass(UserPKey.class)
@Table(name = "user")
public class UserEntity {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	//@EmbeddedId
	//private UserPKey userPKey;

	@Id
	@Column(name = "first_name")
	private String firstName;

	@Id
	@Column(name = "last_name")
	private String lastName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}	

	/*@Override
	public String toString() {
		return "User [id=" + id + ", userPKey=" + userPKey + "]";
	}

	public UserPKey getUserPKey() {
		return userPKey;
	}

	public void setUserPKey(UserPKey userPKey) {
		this.userPKey = userPKey;
	}*/

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}	

}
