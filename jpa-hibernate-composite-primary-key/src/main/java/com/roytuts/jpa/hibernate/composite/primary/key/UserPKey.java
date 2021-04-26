package com.roytuts.jpa.hibernate.composite.primary.key;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

//@Embeddable
public class UserPKey implements Serializable {

	private static final long serialVersionUID = 1L;

	//@Column(name = "first_name")
	private String firstName;

	//@Column(name = "last_name")
	private String lastName;

	public UserPKey() {
	}

	public UserPKey(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	@Override
	public int hashCode() {
		return Objects.hash(getFirstName(), getLastName());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserPKey other = (UserPKey) obj;

		return Objects.equals(getFirstName(), other.getFirstName())
				&& Objects.equals(getLastName(), other.getLastName());
	}

	/*@Override
	public String toString() {
		return "CompositePKey [firstName=" + firstName + ", lastName=" + lastName + "]";
	}*/

}
