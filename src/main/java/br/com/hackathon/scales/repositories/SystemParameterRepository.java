package br.com.hackathon.scales.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hackathon.scales.entities.SystemParameter;

public interface SystemParameterRepository extends JpaRepository<SystemParameter, Long> {

}
