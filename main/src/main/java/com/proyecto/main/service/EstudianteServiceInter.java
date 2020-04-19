package com.proyecto.main.service;

import java.util.List;

import com.proyecto.main.entity.Estudiante;

public interface EstudianteServiceInter {
	public List<Estudiante> findAll();
	
	public Estudiante findById(int Id);
	
	public void save(Estudiante elEstudiante);
	
	public void deleteById(int Id);

}
