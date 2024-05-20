package com.example.finvision.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class User {
    
	@Column(name = "name", length = 100, nullable = false)
    private String name;
    
	@Column(name = "date", nullable = false)
    private LocalDate date;
    
    @Id
    @Column(name = "email", length = 255, nullable = false)
    private String email;
    
    @Column(name = "password", length = 255, nullable = false)
    private String password;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
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
}
