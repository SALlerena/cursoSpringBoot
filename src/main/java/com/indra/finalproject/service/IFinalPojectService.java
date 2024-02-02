package com.indra.finalproject.service;

import java.util.List;
import java.util.Optional;

import com.indra.finalproject.dto.LibroDto;

public interface IFinalPojectService {

	List<LibroDto> obtenerTodosLosLibros();
	
	Optional<LibroDto> obtenerLibroPorId(Long id);
	
	LibroDto guardarLibro(LibroDto libro);
	
	void eliminarLibro(Long id);
	
	Optional<LibroDto> modificarLibro(LibroDto libroDto);
}
