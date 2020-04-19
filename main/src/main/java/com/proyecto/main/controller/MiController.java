package com.proyecto.main.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.main.service.EstudianteServiceImple;
import com.proyecto.main.DAO.EstudianteRepository;
import com.proyecto.main.entity.Estudiante;
import com.proyecto.main.service.CursoServiceImple;


@Controller
@RequestMapping("/estudiante")
public class MiController {

	@Autowired
	private EstudianteRepository estudianteRepository;
	
	//@Autowired
	//private CursoServiceImple cursoservice;
	
	@RequestMapping(value="/lista",method = RequestMethod.GET)
	public String viewHomePage(Model model) {
		//System.out.println("holaaaaaaaaaaaaaaaa");
	    List<Estudiante> listaEstudiante = estudianteRepository.findAll();
	    model.addAttribute("listaEstudiante", listaEstudiante);
	     
	    return "estudiante";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormAdd(Model elModelo)
	{
		Estudiante elEstudiante= new Estudiante();
		elModelo.addAttribute("estudiante", elEstudiante);
		
		return "agregarEstudiante";
	}
	
	@PostMapping(value="/saveEstudiante")
	public String saveEstudiante(@Valid @ModelAttribute("estudiante") Estudiante elEstudiante, 
			BindingResult theBindingResult) 
	{
	
		if (theBindingResult.hasErrors()) 
		{
		return "agregarEstudiante";
		}
		else {
			// save the customer using our service
			estudianteRepository.save(elEstudiante);
		return "redirect:/estudiante/lista";
		}
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("estudianteId") int elId,
									Model elModelo) {
		
		// get the customer from our service
		Estudiante elEstudiante = estudianteRepository.getOne(elId);
		
		// set customer as a model attribute to pre-populate the form
		elModelo.addAttribute("estudiante", elEstudiante);
		
		// send over to our form		
		return "agregarEstudiante";
	}
	
	@GetMapping("/delete")
	public String deleteEstudiante(@RequestParam("estudianteId") int elId) {
		
		// delete the customer
		estudianteRepository.deleteById(elId);
		
		return "redirect:/estudiante/lista";
	}
}
