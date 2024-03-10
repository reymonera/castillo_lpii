package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Libro;
import com.example.demo.repository.LibrosRepository;

@Service
public class LibrosService {

	@Autowired
	private LibrosRepository librosRepository;
	
	public List<Libro> getAllLibros() {
		return librosRepository.findAll();
	}
	
	public Libro createLibro(Libro libro) {
		return librosRepository.save(libro);
	}
	
	public Libro getLibroById(long id) {
		return librosRepository.findById(id).orElse(null);
	}
	public void deleteLibro(Long id) {
		librosRepository.deleteById(id);
	}
}
