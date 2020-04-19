package com.proyecto.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.proyecto.main.DAO.CursoRepository;
import com.proyecto.main.DAO.EstudianteRepository;
import com.proyecto.main.entity.Curso;
import com.proyecto.main.entity.Estudiante;

@Controller
@RequestMapping ("/curso_estudiante")
public class EstudianteCursoController {
	
	@Autowired
	private CursoRepository cursoRepository;
	@Autowired
	private EstudianteRepository estudianteRepository;
	
	@RequestMapping("/estudiantesDeCurso")
	public String showCurseStudents(@RequestParam("cursoId") int elId,
			Model theModel)
	{
		Curso theCurse = cursoRepository.getOne(elId);
		List<Estudiante> estudiantes = theCurse.getEstudiantes();
		theModel.addAttribute("curso", theCurse);
		theModel.addAttribute("estudiantes", estudiantes);
				
		return "EstudiantesDeCurso";
	}
	
	@GetMapping("/delete_from_curso")
	public String deleteCurso(@RequestParam("cursoId") int cursoId, @RequestParam("estudianteId") int estudianteId) {
		Curso theCurse = cursoRepository.getOne(cursoId);
		Estudiante theEstudiante =estudianteRepository.getOne(estudianteId);
		theCurse.deleteEstudiante(theEstudiante);
		cursoRepository.save(theCurse);
		estudianteRepository.save(theEstudiante);
		return "redirect:/curso_estudiante/estudiantesDeCurso";
	}
	

}
