package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Genero;

import com.example.demo.repository.GeneroRepository;

@Service
public class GeneroService {
	
	@Autowired
	private GeneroRepository generoRepository;
	
	public List<Genero> getAllGeneros() {
		return generoRepository.findAll();
	}
	
	public Genero createLibro(Genero genero) {
		return generoRepository.save(genero);
	}
	
	public Genero getGeneroById(long id) {
		return generoRepository.findById(id).orElse(null);
	}

}
