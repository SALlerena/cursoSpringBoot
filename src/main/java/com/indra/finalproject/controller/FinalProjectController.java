package com.indra.finalproject.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.indra.finalproject.dto.LibroDto;
import com.indra.finalproject.service.IFinalPojectService;

@RestController
@RequestMapping("/libros")
public class FinalProjectController {

	@Autowired
	IFinalPojectService libroService;
	
	@GetMapping
    public ResponseEntity<List<LibroDto>> obtenerTodosLosLibros() {
        List<LibroDto> libros = libroService.obtenerTodosLosLibros();
        return new ResponseEntity<>(libros, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LibroDto> obtenerLibroPorId(@PathVariable Long id) {
        Optional<LibroDto> libro = libroService.obtenerLibroPorId(id);
        return libro.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/insert")
    public ResponseEntity<LibroDto> guardarLibro(@RequestBody LibroDto LibroDto) {
    	LibroDto nuevoLibro = libroService.guardarLibro(LibroDto);
        return new ResponseEntity<>(nuevoLibro, HttpStatus.CREATED);
    }
    
    @PutMapping("/put")
    public ResponseEntity<LibroDto> modificarLibro(@RequestBody LibroDto libroDto) {
    	
    	Optional<LibroDto> libro = libroService.modificarLibro(libroDto);
    	
        return new ResponseEntity<>(libro.get(), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarLibro(@PathVariable Long id) {
        libroService.eliminarLibro(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
