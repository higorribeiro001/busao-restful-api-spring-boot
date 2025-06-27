package com.example.busaoapi.auth.domain.model;

import java.util.UUID;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id", updatable=false, unique=true, nullable=true)
	private UUID id;
	
	@Column(name="email", unique=true)
	private String email;
	
	@Column(name="password")
	private String password;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinTable(name="users_role", joinColumns=@JoinColumn(name="user_id"), inverseJoinColumns = @JoinColumn(name="role_id"))
	private List<Role> roles;
	
	public UUID getId() {
		return id;
	}
	
	public String getEmail() {
		return email;
	}
	
	public List<Role> getRoles() {
		return roles;
	}
	
}
