package com.example.projet.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(	name = "Dim_user", 
uniqueConstraints = { 
	@UniqueConstraint(columnNames = "username"),
	@UniqueConstraint(columnNames = "email") 
})
public class Dim_user  implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long user_id;
	@NotBlank
	@Size(max = 20)
	private String username;
	@NotBlank
	@Size(max = 50)
	@Email
	private String email;

	private String firstName;
	@JsonFormat(pattern ="dd-mm-yyyy")
	private Date dateNassance;
	private String lastName;
	private String phone;
	private String ville;
	@NotBlank
	@Size(max = 120)
	private String password;
	private String stateUser;//active or inactifs
	@ManyToOne
	private Dim_country ct_id;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(	name = "user_roles", 
				joinColumns = @JoinColumn(name = "user_id"), 
				inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Dim_roles> roles = new HashSet<>();
	
	public Dim_user() {
	}

	public Dim_user(String username, String email, String password) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
	}
	public Dim_user(long user_id, @NotBlank @Size(max = 20) String username,
			@NotBlank @Size(max = 50) @Email String email, String firstName, Date dateNassance, String lastName,
			String phone, String ville, @NotBlank @Size(max = 120) String password, String stateUser,
			Dim_country ct_id, Set<Dim_roles> roles) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.email = email;
		this.firstName = firstName;
		this.dateNassance = dateNassance;
		this.lastName = lastName;
		this.phone = phone;
		this.ville = ville;
		this.password = password;
		this.stateUser = stateUser;
		this.ct_id = ct_id;
		this.roles = roles;
	}


	public Date getDateNassance() {
		return dateNassance;
	}

	public void setDateNassance(Date dateNassance) {
		this.dateNassance = dateNassance;
	}

	public Set<Dim_roles> getRoles() {
		return roles;
	}


	public void setRoles(Set<Dim_roles> roles) {
		this.roles = roles;
	}


	public long getUser_id() {
		return user_id;
	}
	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Dim_country getCt_id() {
		return ct_id;
	}
	public void setCt_id(Dim_country ct_id) {
		this.ct_id = ct_id;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String userName) {
		this.username = userName;
	}
	public String getStateUser() {
		return stateUser;
	}
	public void setStateUser(String stateUser) {
		this.stateUser = stateUser;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (user_id ^ (user_id >>> 32));
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
		Dim_user other = (Dim_user) obj;
		if (user_id != other.user_id)
			return false;
		return true;
	}
	
	
}
