package com.cg.dms.entities;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@MappedSuperclass
public abstract class AbstractUser {
	
	@NotNull
	private String userName;
	@NotNull
	private String firstName;
	@NotNull
	private String lastName;
	@NotNull
	@Size(min = 4, max = 10)
	private String password;
	@Column(length = 10)
	private String mobileNumber;
	@Email
	@NotBlank
	private String email;
	@NotNull
	private int milkunits;
	@NotEmpty
	private double unitprice;

	public String getUsername() {
		return userName;
	}

	public void setUsername(String username) {
		this.userName = username;
	}

	public String getfirstName() {
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getMilkunits() {
		return milkunits;
	}

	public void setMilkunits(int milkunits) {
		this.milkunits = milkunits;
	}

	public double getUnitprice() {
		return unitprice;
	}

	public void setUnitprice(double unitprice) {
		this.unitprice = unitprice;
	}
}