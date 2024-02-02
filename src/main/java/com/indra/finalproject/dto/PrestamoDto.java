package com.indra.finalproject.dto;

import java.util.Date;

public class PrestamoDto {
	private Long idPrestamo;
	private LibroDto libro;
	private UsuarioDto usuario;
	private Date fechaPrestamo;
	private Date fechaDevolucion;
	private boolean devuelto;

	public Long getIdPrestamo() {
		return idPrestamo;
	}

	public void setIdPrestamo(Long idPrestamo) {
		this.idPrestamo = idPrestamo;
	}

	public LibroDto getLibro() {
		return libro;
	}

	public void setLibro(LibroDto libro) {
		this.libro = libro;
	}

	public UsuarioDto getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioDto usuario) {
		this.usuario = usuario;
	}

	public Date getFechaPrestamo() {
		return fechaPrestamo;
	}

	public void setFechaPrestamo(Date fechaPrestamo) {
		this.fechaPrestamo = fechaPrestamo;
	}

	public Date getFechaDevolucion() {
		return fechaDevolucion;
	}

	public void setFechaDevolucion(Date fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}

	public boolean isDevuelto() {
		return devuelto;
	}

	public void setDevuelto(boolean devuelto) {
		this.devuelto = devuelto;
	}

}
