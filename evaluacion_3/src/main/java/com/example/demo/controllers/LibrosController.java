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

import com.example.demo.model.Genero;
import com.example.demo.model.Libro;
import com.example.demo.service.LibrosService;
import com.example.demo.service.GeneroService;

@Controller
@RequestMapping("/libro")

public class LibrosController {
	
	@Autowired
	private GeneroService generoService;
	
	@Autowired
	private LibrosService librosService;
	
	@GetMapping("/libros")
	public String getAllLibros(Model model) {
		
		List<Libro> listLibro = librosService.getAllLibros();
		
		model.addAttribute("libro", listLibro);
		
		
		return "librosList";
	}
	
	@GetMapping("/register")
	public String Register(Model model) {
		List<Genero> generos = generoService.getAllGeneros();
	    model.addAttribute("generos", generos);
		
		return "libroRegister";
	}
	
	@PostMapping("/register")
	public String createLibro(@RequestParam("nombre") String nombre, @RequestParam("autor") String autor,@RequestParam("fechaPublicacion") String fechaPublicacion,@RequestParam("id") Long id, Model model) {
		
		
		
		Libro libro = new Libro();
		libro.nombre=nombre;
		libro.autor=autor;
		libro.fechaPublicacion= fechaPublicacion;
		
		Genero genero = generoService.getGeneroById(id);
		
		libro.genero=genero;
		
		
		librosService.createLibro(libro);
		
		model.addAttribute("libros", librosService.getAllLibros());
		model.addAttribute("generos", generoService.getAllGeneros());
		
		return "librosList";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable Long id, Model model) {
		
		Libro libro = librosService.getLibroById(id);
		
		model.addAttribute("libros", libro);
		model.addAttribute("generos", generoService.getAllGeneros());
		
		return "libroEdit";
	}
	
	@PostMapping("/edit")
	public String createLibro1(@RequestParam("nombre") String nombre, @RequestParam("autor") String autor,@RequestParam("fechaPublicacion") String fechaPublicacion,@RequestParam("id") Long id, Model model) {
		
		
		
		Libro libro = new Libro();
		libro.nombre=nombre;
		libro.autor=autor;
		libro.fechaPublicacion= fechaPublicacion;
		
		Genero genero = generoService.getGeneroById(id);
		
		libro.genero=genero;
		
		
		librosService.createLibro(libro);
		
		model.addAttribute("libros", librosService.getAllLibros());
		model.addAttribute("generos", generoService.getAllGeneros());
		
		return "librosList";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable Long id, Model model) {
		librosService.deleteLibro(id);
		
		model.addAttribute("libros", librosService.getAllLibros());
		model.addAttribute("generos", generoService.getAllGeneros());
		
		return "librosList";
	}

}
