package br.com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.spring.model.Titulo;

@Controller
@RequestMapping("/titulos")
public class TituloController {
	
	@RequestMapping("/novo")
	public String novo() {
		return "CadastroTitulo";
	}

	@RequestMapping(method= RequestMethod.POST)
	public String salvar(Titulo titulo) {
		//TODO: Salvar no banco de dados
		System.out.println(">>> " + titulo.getDescricao());
		return "CadastroTitulo";
	}
	
}