package com.indra.finalproject.model;

import java.util.List;
import java.util.stream.Collectors;

import com.indra.finalproject.dto.LibroDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class LibroModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idLibro;

	private String titulo;

	private String autor;

	private int anioPublicacion;

	private boolean disponible;

	@ManyToMany
	@JoinTable(name = "Libro_Categoria", joinColumns = @JoinColumn(name = "id_libro"), inverseJoinColumns = @JoinColumn(name = "id_categoria"))

	private List<CategoriaLibroModel> categorias;

	public LibroModel() {
	}

	public LibroModel(Long idLibro, String titulo, String autor, int anioPublicacion, boolean disponible,
			List<CategoriaLibroModel> categorias) {
		super();
		this.idLibro = idLibro;
		this.titulo = titulo;
		this.autor = autor;
		this.anioPublicacion = anioPublicacion;
		this.disponible = disponible;
		this.categorias = categorias;
	}

	public LibroModel(LibroDto libro) {
		super();
		this.idLibro = libro.getIdLibro();
		this.titulo = libro.getTitulo();
		this.autor = libro.getAutor();
		this.anioPublicacion = libro.getAnioPublicacion();
		this.disponible = libro.isDisponible();
		this.categorias = libro.getCategorias().stream().map(CategoriaLibroModel::new).collect(Collectors.toList());
	}

	public Long getIdLibro() {
		return idLibro;
	}

	public void setIdLibro(Long idLibro) {
		this.idLibro = idLibro;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getAnioPublicacion() {
		return anioPublicacion;
	}

	public void setAnioPublicacion(int anioPublicacion) {
		this.anioPublicacion = anioPublicacion;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	public List<CategoriaLibroModel> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<CategoriaLibroModel> categorias) {
		this.categorias = categorias;
	}

	// Getters y setters
}