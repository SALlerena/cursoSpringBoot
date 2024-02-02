package com.indra.finalproject.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.indra.finalproject.model.LibroModel;

public class LibroDto {

	private Long idLibro;
	private String titulo;
	private String autor;
	private int anioPublicacion;
	private boolean disponible;
	private List<CategoriaLibroDto> categorias;

	public LibroDto(Long idLibro, String titulo, String autor, int anioPublicacion, boolean disponible,
			List<CategoriaLibroDto> categorias) {
		super();
		this.idLibro = idLibro;
		this.titulo = titulo;
		this.autor = autor;
		this.anioPublicacion = anioPublicacion;
		this.disponible = disponible;
		this.categorias = categorias;
	}

	public LibroDto(LibroModel libro) {
		super();
		this.idLibro = libro.getIdLibro();
		this.titulo = libro.getTitulo();
		this.autor = libro.getAutor();
		this.anioPublicacion = libro.getAnioPublicacion();
		this.disponible = libro.isDisponible();
		this.categorias = libro.getCategorias().stream()
                .map(CategoriaLibroDto::new)
                .collect(Collectors.toList());
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

	public List<CategoriaLibroDto> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<CategoriaLibroDto> categorias) {
		this.categorias = categorias;
	}

}
