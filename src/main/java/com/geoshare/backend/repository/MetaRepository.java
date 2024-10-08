package com.geoshare.backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.geoshare.backend.entity.Meta;

import jakarta.persistence.EntityNotFoundException;

@Repository
public interface MetaRepository extends CrudRepository<Meta, Long> {
	
/**
 * Removed all this fun JPQL stuff and replaced it with service layer
 * 	functionality which resulted in fewer lines of code, and much, much better performance.
 */
	
//	@Query("SELECT M FROM Meta M WHERE M.id = :id")
//	Optional<Meta> findByID(Long id);
//	
//	default Meta findByIDOrThrow(Long id) {
//		return findByID(id).orElseThrow(() ->
//			new EntityNotFoundException("Meta not found in database"));
//	}
//	
//	@Query("SELECT M FROM Meta M WHERE M.name = :name")
//	Optional<Meta> findByName(String name);
//	
//	default Meta findByNameOrThrow(String name) {
//		return findByName(name).orElseThrow(() -> 
//			new EntityNotFoundException("Meta not found in database"));
//	}
	
	List<Meta> findAll();
	
}
