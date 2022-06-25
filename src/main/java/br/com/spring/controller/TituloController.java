package br.com.spring.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.spring.model.StatusTitulo;
import br.com.spring.model.Titulo;
import br.com.spring.repository.TitulosRepository;

@Controller
@RequestMapping("/titulos")
public class TituloController {
	
	@Autowired
	private TitulosRepository titulosRepository;
	
	@RequestMapping("/novo")
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView("CadastroTitulo");
		mv.addObject(new Titulo());
		return mv;
	}

	@RequestMapping(method= RequestMethod.POST)
	public ModelAndView salvar(@Valid Titulo titulo, BindingResult bindingResult) {
		ModelAndView mv = new ModelAndView("CadastroTitulo");
		if(bindingResult.hasErrors()) {
			return mv;
		}
		
		List<String> msg = new ArrayList<String>();
		for(ObjectError objectError : bindingResult.getAllErrors()) {
			msg.add(objectError.getDefaultMessage()); // retorna as msg das anotações 
		}
		mv.addObject("mensagem", "Título cadastrado com Sucesso!");
		//mv.addObject("msg", msg);
		titulosRepository.save(titulo);		
		
		
		return mv;
	}
	
	@RequestMapping
	public ModelAndView pesquisar() {
		List<Titulo> todosTitulos = titulosRepository.findAll();
		ModelAndView mv = new ModelAndView("PesquisaTitulos");
		mv.addObject("titulos", todosTitulos);
		return mv;
	}
	
	@ModelAttribute("todosStatusTitulo")
	public List<StatusTitulo> todosStatusTitulo() {
		return Arrays.asList(StatusTitulo.values());
	}
	
	
}