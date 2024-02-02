package com.indra.finalproject.model;

import java.util.List;
import java.util.stream.Collectors;

import com.indra.finalproject.dto.CategoriaLibroDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class CategoriaLibroModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategoria;

    private String nombre;

    @ManyToMany(mappedBy = "categorias")
    private List<LibroModel> libros;

    public CategoriaLibroModel() {

	}
    
	public CategoriaLibroModel(Long idCategoria, String nombre, List<LibroModel> libros) {
		super();
		this.idCategoria = idCategoria;
		this.nombre = nombre;
		this.libros = libros;
	}

	public CategoriaLibroModel(CategoriaLibroDto libroDto) {
		super();
		this.idCategoria = libroDto.getIdCategoria();
		this.nombre = libroDto.getNombre();
	}
	
	public Long getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<LibroModel> getLibros() {
		return libros;
	}

	public void setLibros(List<LibroModel> libros) {
		this.libros = libros;
	}

    
}