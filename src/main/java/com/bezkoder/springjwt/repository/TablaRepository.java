package com.bezkoder.springjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bezkoder.springjwt.models.TablaBorrar;

public interface TablaRepository extends JpaRepository<TablaBorrar, Long>{

}
