package br.com.hackathon.scales.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hackathon.scales.entities.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
	
	List<Funcionario> findByNomeContaining(String nome);
}
