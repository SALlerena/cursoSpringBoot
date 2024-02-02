package com.indra.finalproject.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.indra.finalproject.constants.Constants;
import com.indra.finalproject.dto.CategoriaLibroDto;
import com.indra.finalproject.dto.LibroDto;
import com.indra.finalproject.model.LibroModel;
import com.indra.finalproject.repository.LibroRepository;

@Service
public class FinalProjectServiceImpl implements IFinalPojectService {

	@Autowired
	LibroRepository libroRepository;

	public List<LibroDto> obtenerTodosLosLibros() {

		List<LibroModel> libros = libroRepository.findAll();

		List<LibroDto> librosDto = new ArrayList<>();

		libros.forEach(unLibro -> {

			if (!tieneCopyRight(unLibro.getTitulo(), "L")) {

				librosDto.add(new LibroDto(unLibro));
			}
		});

		return librosDto;
	}

	public LibroDto guardarLibro(LibroDto libro) {

		List<CategoriaLibroDto> categorias = new ArrayList<>();

		if (libro.getCategorias() != null) {
			for (CategoriaLibroDto categoriaDto : libro.getCategorias()) {

				CategoriaLibroDto categoriaLibro = new CategoriaLibroDto();
				categoriaLibro.setNombre(categoriaDto.getNombre());
				categorias.add(categoriaLibro);
			}
		}
		LibroModel libroPlantilla = new LibroModel(libro);
		libroRepository.save(libroPlantilla);

		return libro;
	}

	public Optional<LibroDto> obtenerLibroPorId(Long id) {

		Optional<LibroModel> libro = libroRepository.findById(id);

		if (libro.isPresent()) {
			return Optional.of(new LibroDto(libro.get()));
		} else {
			return Optional.empty();
		}
	}

	public Optional<LibroDto> modificarLibro(LibroDto libroDto) {

		Optional<LibroModel> libroPlantilla = Optional.ofNullable(libroDto).map(LibroModel::new);

		if (libroRepository.findById(libroPlantilla.get().getIdLibro()).isPresent())
			libroRepository.save(libroPlantilla.get());

		if (libroPlantilla.isPresent()) {
			return Optional.of(new LibroDto(libroPlantilla.get()));
		} else {
			return Optional.empty();
		}
	}

	public void eliminarLibro(Long id) {
		libroRepository.deleteById(id);
	}

	private boolean tieneCopyRight(String nombre, String letra) {

		boolean tieneCopyRight = false;

		try {

			URL url = new URL(Constants.URL_API+"?nombre="+nombre + "&letraNoMuestra=" + letra);
			
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			
			connection.setRequestMethod("GET");

			int responseCode = connection.getResponseCode();

			if (responseCode == HttpURLConnection.HTTP_OK) {

				BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				String inputLine;
				StringBuilder response = new StringBuilder();

				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
				in.close();

				ObjectMapper objectMapper = new ObjectMapper();
				JsonNode jsonNode = objectMapper.readTree(response.toString());

				String respuestaApi = jsonNode.toPrettyString();

				tieneCopyRight = recogerValorJson(respuestaApi);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return tieneCopyRight;
	}

	private boolean recogerValorJson(String jsonInput) {

		boolean tieneCopy = false;

		try {
			ObjectMapper objectMapper = new ObjectMapper();

			JsonNode jsonNode = objectMapper.readTree(jsonInput);

			tieneCopy = jsonNode.get("isCopy").asBoolean();

			System.out.println("tieneCopy: " + tieneCopy);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return tieneCopy;
	}
}
