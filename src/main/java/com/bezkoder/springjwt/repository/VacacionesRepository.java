package com.bezkoder.springjwt.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bezkoder.springjwt.models.Vacaciones;

//@Transactional
//@Repository
public interface VacacionesRepository extends JpaRepository<Vacaciones, Long>{
	
	//void save(Vacaciones vaca);
	
	//CUANDO HAY CLASES DENTRO DE CLASES?? SE USA FETCH SI O SI?? ESTUDIAR JPQL !!!!!!!!!!!!!!!!!!!!
	//ESTAMOS HACIENDO JOIN FETCH, PARA QUE NOS TRAIGA TAMBIEN EL USUARIO DENTRO DE DICHAS VACACIONES
//	@Query("select m from Vacaciones m join fetch m.user c where m.id = :id")
//    public Vacaciones getVacaciones(Integer id);
//	public Vacaciones getVacaciones(@Param("id") Integer id);
	
//	@Query("select p from Vacaciones p where p.categoria.id = :categoriaId")
//    public List<Vacaciones> getVacaciones(Integer id);
	
	@Query("select p.vacaciones from User p where p.id = :id")
	public List<Vacaciones> getVacaciones(Long id);
	
	
}
