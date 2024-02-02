package com.indra.finalproject.dto;

import com.indra.finalproject.model.CategoriaLibroModel;

public class CategoriaLibroDto {
	private Long idCategoria;
	private String nombre;
	

	public CategoriaLibroDto() {
		super();
	}
	
	public CategoriaLibroDto(Long idCategoria, String nombre) {
		super();
		this.idCategoria = idCategoria;
		this.nombre = nombre;
	}
	
	public CategoriaLibroDto(CategoriaLibroModel libroModel) {
		super();
		this.idCategoria = libroModel.getIdCategoria();
		this.nombre = libroModel.getNombre();
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

}
