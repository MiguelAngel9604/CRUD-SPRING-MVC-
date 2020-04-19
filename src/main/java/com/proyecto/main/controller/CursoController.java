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

import com.proyecto.main.DAO.CursoRepository;
import com.proyecto.main.DAO.EstudianteRepository;
import com.proyecto.main.entity.Curso;

@Controller
@RequestMapping("/curso")
public class CursoController {

	@Autowired
	private CursoRepository cursoRepository;
	
	@RequestMapping(value="/lista",method = RequestMethod.GET)
	public String viewHomePage(Model model) {
		//System.out.println("holaaaaaaaaaaaaaaaa");
	    List<Curso> listaCurso = cursoRepository.findAll();
	    model.addAttribute("listaCurso", listaCurso);
	     
	    return "curso";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormAdd(Model elModelo)
	{
		Curso elCurso= new Curso();
		elModelo.addAttribute("curso", elCurso);
		
		return "agregarCurso";
	}
	
	@PostMapping(value="/saveCurso")
	public String saveCurso(@Valid @ModelAttribute("curso") Curso elCurso, 
			BindingResult theBindingResult) 
	{
	
		if (theBindingResult.hasErrors()) 
		{
		return "agregarCurso";
		}
		else {
			// save the customer using our service
			cursoRepository.save(elCurso);
		return "redirect:/curso/lista";
		}
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("cursoId") int elId,
									Model elModelo) {
		
		// get the customer from our service
		Curso elCurso = cursoRepository.getOne(elId);
		
		// set customer as a model attribute to pre-populate the form
		elModelo.addAttribute("curso", elCurso);
		
		// send over to our form		
		return "agregarCurso";
	}
	
	@GetMapping("/delete")
	public String deleteCurso(@RequestParam("cursoId") int elId) {
		
		// delete the customer
		cursoRepository.deleteById(elId);
		
		return "redirect:/curso/lista";
	}
}
