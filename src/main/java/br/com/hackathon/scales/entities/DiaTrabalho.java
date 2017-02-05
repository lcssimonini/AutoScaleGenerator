package br.com.hackathon.scales.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import br.com.hackathon.scales.entities.suport.ErrorSerializer;
import br.com.hackathon.scales.enums.DiaSemana;

@Entity
public class DiaTrabalho extends ErrorSerializer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@NotEmpty(message = "Dia da semana não pode ser vazio")
	@Enumerated(EnumType.STRING)
	private DiaSemana diaSemana;
	
	@NotNull(message = "O turno deve ser informado")
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Turno> turnos;
	
	private boolean reduzido;
	
	public DiaTrabalho(){
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public DiaSemana getDiaSemana() {
		return diaSemana;
	}

	public void setDiaSemana(DiaSemana diaSemana) {
		this.diaSemana = diaSemana;
	}

	public List<Turno> getTurnos() {
		return turnos;
	}

	public void setTurnos(List<Turno> turnos) {
		this.turnos = turnos;
	}

	public boolean isReduzido() {
		return reduzido;
	}

	public void setReduzido(boolean reduzido) {
		this.reduzido = reduzido;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((diaSemana == null) ? 0 : diaSemana.hashCode());
		result = prime * result + (reduzido ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DiaTrabalho other = (DiaTrabalho) obj;
		if (diaSemana != other.diaSemana)
			return false;
		if (reduzido != other.reduzido)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DiaTrabalho [diaSemana=" + diaSemana + ", reduzido=" + reduzido + "]";
	}
}
