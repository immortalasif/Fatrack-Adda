package com.example.demo.model;




import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

@Entity
public class UserDetails {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int id;
private String name;

@Email
private String email;

private String password;
private String address;

public UserDetails() {
	super();
}

public UserDetails(int id, String name, String email, String password, String address) {
	super();
	this.id = id;
	this.name = name;
	this.email = email;
	this.password = password;
	this.address = address;
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
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}

@Override
public String toString() {
	return "UserDetails [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", address="
			+ address + "]";
}

}
