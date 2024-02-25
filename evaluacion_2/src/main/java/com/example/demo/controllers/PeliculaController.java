package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Pelicula;
import com.example.demo.service.PeliculaService;

@Controller
@RequestMapping("/peliculas")
public class PeliculaController {


	@Autowired
	private PeliculaService peliculaService;
	
	@GetMapping("/getAllPeliculas")
	public String getAllPeliculas(Model model ) {
		
		List<Pelicula> listPelicula = peliculaService.getAllPeliculas();
		
		model.addAttribute("peliculas", listPelicula);
		
		return "peliculaList";
	}
	
	@GetMapping("/register")
	public String register() {
		return "peliculaRegister";
	}
	
	@PostMapping("/register")
	public String createPelicula(@RequestParam("nombre") String nombre, 
			@RequestParam("director") String director, 
			@RequestParam("fecha") String fecha,
			@RequestParam("genero") Integer genero, Model model) {
				
		Pelicula pelicula = new Pelicula();
		pelicula.nombre = nombre;
		pelicula.director = director;
		pelicula.fecha = fecha;
		pelicula.genero = genero;
		
		peliculaService.createPelicula(pelicula);
		
		List<Pelicula> listPelicula = peliculaService.getAllPeliculas();
		model.addAttribute("peliculas", listPelicula);
		
		return "peliculaList";
	}
	
	
	@GetMapping("/edit/{id}")
	public String getPeliculaByID(@PathVariable Integer id, Model model) {
		Pelicula pelicula = peliculaService.getPeliculaById(id);
		
		model.addAttribute("pelicula", pelicula);
		return "peliculaEdit";
	}
	
	@PostMapping("/edit")
	public String editPelicula(@RequestParam("id") Integer id,
			@RequestParam("nombre") String nombre,
			@RequestParam("director") String director, 
			@RequestParam("fecha") String fecha,
			@RequestParam("genero") Integer genero, Model model) {
		
		Pelicula pelicula = peliculaService.getPeliculaById(id);
		pelicula.nombre = nombre;
		pelicula.director = director;
		pelicula.fecha = fecha;
		pelicula.genero = genero;
		
		peliculaService.createPelicula(pelicula);
		
		List<Pelicula> listPelicula = peliculaService.getAllPeliculas();
		model.addAttribute("peliculas", listPelicula);
		
		return "peliculaList";
	}
	
	
	@GetMapping("/delete/{id}")
	public String deletePelicula(@PathVariable Integer id, Model model) {
		peliculaService.deletePelicula(id);
		
		List<Pelicula> listPelicula = peliculaService.getAllPeliculas();
		model.addAttribute("peliculas", listPelicula);
		
		return "peliculaList";
	}
	
	
	
}
