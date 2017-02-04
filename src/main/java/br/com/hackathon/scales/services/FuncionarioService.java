package br.com.hackathon.scales.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;

import br.com.hackathon.scales.entities.Funcionario;
import br.com.hackathon.scales.repositories.FuncionarioRepository;

@Service
public class FuncionarioService {
	
	@Autowired
	private FuncionarioRepository funcionariosRepository;
	
	public Funcionario save(Funcionario funcionario, Errors errors) {
		
		if (funcionario == null) {
			throw new IllegalArgumentException("Não foi passado um funcionario para ser salvo");
		}

		if (errors.hasErrors()) {
			for (ObjectError error : errors.getAllErrors()) {
				funcionario.addErrorMessage(error.getDefaultMessage());
			}
			return funcionario;
		}

		return funcionariosRepository.save(funcionario);
	}
	
	public List<Funcionario> findAll() {
		List<Funcionario> todosFuncionarios = funcionariosRepository.findAll();
		
		return todosFuncionarios;
	}
	
	public void delete(Long id) {
		funcionariosRepository.delete(id);
	}
}
