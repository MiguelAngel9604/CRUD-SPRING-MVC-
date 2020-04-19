package com.proyecto.main.entity;

import java.util.Date;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
@Entity
@Table(name = "estudiante")
public class Estudiante
{

	//Definimos el ID
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="apellido")
	private String apellido;
	
	@Column(name="correo")
	private String correo;
	
	@NotNull(message="El campo debe de estar lleno")
	@Size(min=1, message="El campo no puede estar vacio")
	@Pattern(regexp="^\\d{4}-\\d{2}-\\d{2}$", message="El campo debe de tener el siguiente foramto: aaaa-mm-dd")
	@Column(name="fecha_nacimiento")
	private String fechaNacimiento;
	
	@Column(name="mayoria_edad")
	private Boolean mayoriaEdad;
	
	@ManyToMany(fetch=FetchType.LAZY,
			cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			 CascadeType.DETACH, CascadeType.REFRESH})
	@JoinTable(
			name="coursos_alumnos",
			joinColumns=@JoinColumn(name="alumnos_id"),
			inverseJoinColumns=@JoinColumn(name="cursos_id")
			)	
	private List<Curso> cursos;
	
	public Estudiante() {

	}

	public Estudiante(int id, String nombre, String apellido, String correo, 
			String fechaNacimiento,Boolean mayoriaEdad,List<Curso> cursos) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.fechaNacimiento = fechaNacimiento;
		this.mayoriaEdad = mayoriaEdad;
		this.cursos = cursos;
	}
	public List<Curso> getCursos() {
		return cursos;
	}
	public void deleteCurso(Curso theCurso) {
		cursos.remove(theCurso);
	}
	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Boolean getMayoriaEdad() {
		return mayoriaEdad;
	}

	public void setMayoriaEdad(Boolean mayoriaEdad) {
		this.mayoriaEdad = mayoriaEdad;
	}
	



	@Override
	public String toString() {
		return "Estudiante [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", correo=" + correo
				+ ", fechaNacimiento=" + fechaNacimiento + ", mayoriaEdad=" + mayoriaEdad + "]";
	}
	
	
	
	
}
