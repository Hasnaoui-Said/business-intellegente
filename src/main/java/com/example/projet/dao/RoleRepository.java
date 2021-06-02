package com.example.projet.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.projet.enumeration.ERole;
import com.example.projet.beans.Dim_roles;


@Repository
public interface RoleRepository extends JpaRepository<Dim_roles, Long> {
	Optional<Dim_roles> findByName(ERole name);
	//public Dim_roles findByName(ERole eRole);
	//public int deleteByRole(String ref);
	
}
