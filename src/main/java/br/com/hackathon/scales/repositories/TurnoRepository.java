package br.com.hackathon.scales.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hackathon.scales.entities.Turno;

public interface TurnoRepository extends JpaRepository<Turno, Long> {

}
