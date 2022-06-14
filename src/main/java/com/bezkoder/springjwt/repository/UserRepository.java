package com.bezkoder.springjwt.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bezkoder.springjwt.models.User;
import com.bezkoder.springjwt.models.Vacaciones;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

//@Query("select c from users c")
	List<User> findAll();
	
	Optional<User> findById(Long id);
	
	@Query("select p from User p where p.username like ?1%")
	List<User> findByNombre(String username); 
	
	@Query("select p from User p where p.id = :id")
	User findPorId(Long id); 
	
//	@Query("select p from User p join fetch p.vacaciones c where p.id = :id")
//	User findPorIdVacaciones(Long id); 
	
	@Query("select p.vacaciones from User p where p.id = :id")
	User findPorIdVacaciones(Long id); 
	
	Optional<User> findByUsername(String username); //NO SE DONDE SE IMPLEMENTA ESTA FUNCION, NO VEO QUE SEA DE LIBRERIA
		
	Boolean existsByUsername(String username);
		
	Boolean existsByEmail(String email);

	void save(Vacaciones vaca);
  
  
}
