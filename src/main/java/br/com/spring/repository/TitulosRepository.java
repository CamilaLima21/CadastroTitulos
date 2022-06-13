package br.com.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.spring.model.Titulo;

public interface TitulosRepository extends JpaRepository<Titulo, Long>{

}
