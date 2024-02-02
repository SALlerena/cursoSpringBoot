package com.indra.finalproject.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class PrestamoModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPrestamo;

	@ManyToOne
	@JoinColumn(name = "id_libro")
	private LibroModel libro;

	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private UsuarioModel usuario;

	private Date fechaPrestamo;
	private Date fechaDevolucion;
	private boolean devuelto;

	public Long getIdPrestamo() {
		return idPrestamo;
	}

	public void setIdPrestamo(Long idPrestamo) {
		this.idPrestamo = idPrestamo;
	}

	public LibroModel getLibro() {
		return libro;
	}

	public void setLibro(LibroModel libro) {
		this.libro = libro;
	}

	public UsuarioModel getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioModel usuario) {
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

	// Getters y setters
}