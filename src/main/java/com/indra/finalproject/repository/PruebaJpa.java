package com.indra.finalproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.indra.finalproject.model.PruebaEntity;

@Repository
public interface PruebaJpa extends JpaRepository<PruebaEntity, Long>{

}
