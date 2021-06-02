package com.example.projet.security.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projet.beans.Dim_roles;
import com.example.projet.dao.RoleRepository;
import com.example.projet.enumeration.ERole;

@Service
public class Dim_roleService {

	@Autowired
	private RoleRepository role_Dao;

	public Optional<Dim_roles>  findByRole(ERole eRole) {
		return role_Dao.findByName(eRole);
	}

	/*public int deleteByRole(String ref) {
		return role_Dao.deleteByRole(ref);
	}*/

	public int save(Dim_roles dim_role) {
		if(findByRole(dim_role.getName()) != null) {
			return -1;
		}else {
			role_Dao.save(dim_role);
			return 1;
		}
	}

	public List<Dim_roles> findAll() {
		return role_Dao.findAll();
	}

	public Dim_roles getOne(Long id) {
		return role_Dao.getOne(id);
	}
}
