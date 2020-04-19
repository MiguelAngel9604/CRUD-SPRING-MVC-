package com.proyecto.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.proyecto.main.DAO.EstudianteRepository;
import com.proyecto.main.entity.Estudiante;

public class EstudianteServiceImple implements EstudianteServiceInter{

	
	@Autowired
	private EstudianteRepository estudianteDAO;

	@Override
	public List<Estudiante> findAll() {
		// TODO Auto-generated method stub
		return estudianteDAO.findAll();
	}

	@Override
	public Estudiante findById(int Id) {
		Optional<Estudiante> result = estudianteDAO.findById(Id);
        Estudiante elEstudiante = null;
		
		if (result.isPresent()) {
			elEstudiante = result.get();
		}
		else {
			// we didn't find the employee
			throw new RuntimeException("No se encontro el estudiante id - " + Id);
		}
		return elEstudiante;
	}

	@Override
	public void save(Estudiante elEstudiante) {
		estudianteDAO.save(elEstudiante);
	}

	@Override
	public void deleteById(int Id) {
		estudianteDAO.deleteById(Id);
	}


}
