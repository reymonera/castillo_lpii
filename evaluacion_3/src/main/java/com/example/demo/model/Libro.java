package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "libro")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idLibro", nullable = false)
    public Long id;

    @Column(name = "nombre", nullable = false)
	public String nombre;

    @Column(name = "autor", nullable = false)
    public String autor;

    @Column(name = "fechaPublicacion", nullable = false)
    public String fechaPublicacion;

    @ManyToOne
    @JoinColumn(name = "idGenero")
    public Genero genero;
    
}
