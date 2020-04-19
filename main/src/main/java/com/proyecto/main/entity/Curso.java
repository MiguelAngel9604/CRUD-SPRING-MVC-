package com.proyecto.main.entity;

import java.util.ArrayList;
import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "curso")
public class Curso {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="descripcion")
	private String descripcion;

	@ManyToMany(fetch=FetchType.LAZY,
			cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			 CascadeType.DETACH, CascadeType.REFRESH})
	@JoinTable(
			name="coursos_alumnos",
			joinColumns=@JoinColumn(name="cursos_id"),
			inverseJoinColumns=@JoinColumn(name="alumnos_id"))
			
	private List<Estudiante> estudiantes;
	public Curso() {
	}

	public Curso(int id, String nombre, String descripcion,
			List<Estudiante> estudiantes) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.estudiantes =estudiantes;
	}
	public List<Estudiante> getEstudiantes() {
		return estudiantes;
	}
	
	public void setEstudiantes(List<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}
	public void addEstudiante(Estudiante theStudent) {
		
		if (estudiantes == null) {
			estudiantes = new ArrayList<>();
		}
		estudiantes.add(theStudent);
	}
	
	public void deleteEstudiante(Estudiante theStudent) {
		estudiantes.remove(theStudent);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Curso [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + "]";
	}
	
	
	

}
