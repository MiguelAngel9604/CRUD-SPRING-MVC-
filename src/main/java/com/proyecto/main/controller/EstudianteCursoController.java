package com.proyecto.main.controller;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	
	@RequestMapping("/cursosDelEstudiante")
	public String showStudentsCourses(@RequestParam("cursoId") int elId,
			Model theModel)
	{
		//Curso theCurse = cursoRepository.getOne(elId);
		Estudiante theStudent = estudianteRepository.getOne(elId);
		List<Curso> cursos = theStudent.getCursos();
		theModel.addAttribute("estudiante", theStudent);
		theModel.addAttribute("cursos", cursos);
				//ystem.out.println("cursos");
		return "CursosDelEstudiante";
	}
	
	@GetMapping("/eliminarCursoDeEstudiante")
	public String deleteCursoDeEstudiante(@RequestParam("cursoId") int cursoId, @RequestParam("estudianteId") int estudianteId) {
		Estudiante theStudent = estudianteRepository.getOne(estudianteId);
		Curso theCurso =cursoRepository.getOne(cursoId);
		theStudent.deleteCurso(theCurso);
		cursoRepository.save(theCurso);
		estudianteRepository.save(theStudent);
		return "redirect:/estudiante/lista";
	}
	
	@GetMapping("/delete_from_curso")
	public String deleteCurso(@RequestParam("cursoId") int cursoId, @RequestParam("estudianteId") int estudianteId) {
		Curso theCurse = cursoRepository.getOne(cursoId);
		Estudiante theEstudiante =estudianteRepository.getOne(estudianteId);
		theCurse.deleteEstudiante(theEstudiante);
		cursoRepository.save(theCurse);
		estudianteRepository.save(theEstudiante);
		return "redirect:/curso_estudiante/estudiantesDeCurso?cursoId="+cursoId;
	}
	

	@GetMapping("/formAddStudent")
	public String showFormAddEstudiante(Model theModel, @RequestParam("cursoId") int cursoId) {
		Map<Integer, String> StudentsList = new HashMap<Integer, String>();
	    
		
		Curso theCurse = cursoRepository.getOne(cursoId);
	    List<Estudiante> listatemporal = theCurse.getEstudiantes();//lista de los inscritos
	    List<Estudiante> listatemporal2 = estudianteRepository.findAll();//lista de todos
	    
	    if (listatemporal==null) {
	    	listatemporal = new ArrayList<>();
	    }
	    for (Estudiante var : listatemporal2) {
			if(!listatemporal.contains(var)) {
				StudentsList.put(var.getId(),var.getNombre()+" "+var.getApellido() );
			}
		}
		
	    theModel.addAttribute("cursoId",cursoId);
	    theModel.addAttribute("StudentsList",StudentsList);
		return "AgregarEstudianteCurso";
	}

	@GetMapping("/AgregarAlCurso")
	public String addCurso(@RequestParam("cursoId") int cursoId, @RequestParam("estudianteId") int estudianteId) {
		Curso theCurse = cursoRepository.getOne(cursoId);
		Estudiante theEstudiante =estudianteRepository.getOne(estudianteId);
		theCurse.addEstudiante(theEstudiante);
		cursoRepository.save(theCurse);
		estudianteRepository.save(theEstudiante);
		return "redirect:/curso_estudiante/estudiantesDeCurso?cursoId="+cursoId;
	}
	
	@GetMapping("/BuscarEstudiante")
	public String showFormEstudiante() {
		return "buscar-estudiante";
	}
}
