package com.smart.entities;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "USER")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@NotBlank(message = "Name Required")
	@Size(min = 2,max = 18,message = "Size must be 2-18")
	private String name;
	@Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$",message = "Invalid Email")
	private String Email;
	private String role;
	private Boolean active;
	private String description;
	
	
	 @Pattern(regexp ="(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}", message ="Enter valid password")

//	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$",message="Must Contain Eight characters, one uppercase letter, one lowercase letter, one number and one special character")
	private String password;
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", Email=" + Email + ", role=" + role + ", active=" + active
				+ ", description=" + description + ", password=" + password + ", imgURL=" + imgURL + ", contacts="
				+ contacts + "]";
	}
	private String imgURL; 
	@OneToMany(cascade = CascadeType.ALL ,fetch = FetchType.LAZY)
	private List<Contact>contacts = new ArrayList<>();

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
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getImgURL() {
		return imgURL;
	}
	public void setImgURL(String imgURL) {
		this.imgURL = imgURL;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int id, String name, String email, String role, Boolean active, String description, String password,
			String imgURL) {
		super();
		this.id = id;
		this.name = name;
		Email = email;
		this.role = role;
		this.active = active;
		this.description = description;
		this.password = password;
		this.imgURL = imgURL;
	}
	public List<Contact> getContacts() {
		return contacts;
	}
	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}
	

}
