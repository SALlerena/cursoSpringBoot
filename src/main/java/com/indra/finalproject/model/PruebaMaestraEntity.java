package com.indra.finalproject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PruebaMaestraEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPrueba;
 	
    private String nombre;
}
