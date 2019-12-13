package com.tech.mobile.innovative;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity(name = "SUBSCRIPTION")
@Table(name="SUBSCRIPTION",uniqueConstraints = {
        @UniqueConstraint(columnNames = "ID"),
        @UniqueConstraint(columnNames = "EMAIL") })

public class Users implements Serializable {

	private static final long serialVersionUID = -1798070786993154676L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID", unique = true, nullable = false)
	private long subscriberId;
	
	@Column(name = "NAME", unique = false, nullable = false, length = 100)
	private String firstName;
	
	@Column(name = "SURNAME", unique = false, nullable = false, length = 100)
	private String lastName;
	
	@Column(name = "EMAIL", unique = true, nullable = false, length = 100)
	private String email;
	
	public Users() {
		firstName ="";
		lastName = "";
		email = "";
		
	}
	
	
	public Users(long subscriberId, String firstName, String lastName, String email) {
		super();
		this.subscriberId = subscriberId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}



	/**
	 * @return the subscriberId
	 */
	public long getSubscriberId() {
		return subscriberId;
	}
	/**
	 * @param subscriberId the subscriberId to set
	 */
	public void setSubscriberId(long subscriberId) {
		this.subscriberId = subscriberId;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
