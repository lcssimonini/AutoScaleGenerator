package br.com.hackathon.scales.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hackathon.scales.entities.Escala;

public interface EscalaRepository extends JpaRepository<Escala, Long>  {

}
