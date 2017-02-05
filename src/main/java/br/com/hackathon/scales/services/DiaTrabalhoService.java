package br.com.hackathon.scales.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;

import br.com.hackathon.scales.entities.DiaTrabalho;
import br.com.hackathon.scales.repositories.DiaTrabalhoRepository;

@Service
public class DiaTrabalhoService {

	@Autowired
	private DiaTrabalhoRepository repository;

	public DiaTrabalho save(DiaTrabalho diaTrabalho, Errors errors) {

		if (diaTrabalho == null) {
			throw new IllegalArgumentException("Não foi passado um funcionario para ser salvo");
		}

		if (errors.hasErrors()) {
			for (ObjectError error : errors.getAllErrors()) {
				diaTrabalho.addErrorMessage(error.getDefaultMessage());
			}
			return diaTrabalho;
		}

		return repository.save(diaTrabalho);
	}

	public List<DiaTrabalho> findAll() {
		List<DiaTrabalho> todosDiaTrabalho = repository.findAll();

		return todosDiaTrabalho;
	}

	public void delete(Long id) {
		repository.delete(id);
	}
}
