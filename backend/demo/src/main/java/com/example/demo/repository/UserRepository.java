package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Usuario;

@Repository
public interface UserRepository extends JpaRepository<Usuario,Long>{
	
	@Query(value ="SELECT * FROM Usuario WHERE username=:username",nativeQuery=true)
	Optional<Usuario> getUserByUsername(@Param("username") String username);

}
