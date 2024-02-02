package com.indra.finalproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.indra.finalproject.model.CategoriaLibroModel;

@Repository
public interface CategoriaLibroRepository extends JpaRepository<CategoriaLibroModel, Long>{

}
