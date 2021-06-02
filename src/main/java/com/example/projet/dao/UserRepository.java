package com.example.projet.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.projet.beans.Dim_user;



@Repository
public interface UserRepository extends JpaRepository<Dim_user, Long> {
	Optional<Dim_user> findByUsername(String username);

	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);
}
