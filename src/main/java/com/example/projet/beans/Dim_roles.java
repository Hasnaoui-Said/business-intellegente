package com.example.projet.beans;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.example.projet.enumeration.ERole;

@Entity
public class Dim_roles  implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long roleId;
	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private ERole name;
	private String description;

	
	public long getRole_id() {
		return roleId;
	}

	public void setRole_id(long role_id) {
		this.roleId = role_id;
	}

	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	public ERole getName() {
		return name;
	}

	public void setName(ERole name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (roleId ^ (roleId >>> 32));
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
		Dim_roles other = (Dim_roles) obj;
		if (roleId != other.roleId)
			return false;
		return true;
	}

	
	
	
	
	
	
}
