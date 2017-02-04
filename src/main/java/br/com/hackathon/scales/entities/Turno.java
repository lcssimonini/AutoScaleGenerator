package br.com.hackathon.scales.entities;

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import br.com.hackathon.scales.entities.suport.ErrorSerializer;

@Entity
public class Turno extends ErrorSerializer  {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@NotNull(message = "O número do turno deve ser informado")
	@Enumerated(EnumType.STRING)
	private NumeroTurno numeroTurno;
	
	@NotNull(message = "O horário de início deve ser informado")
	@Temporal(value=TemporalType.TIME)
	@DateTimeFormat(pattern = "HH:mm")
	private Date horarioInicio;
	
	@NotNull(message = "O horário de fim deve ser informado")
	@Temporal(value=TemporalType.TIME)
	@DateTimeFormat(pattern = "HH:mm")
	private Date horarioFim;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Funcionario> funcionarios;
	
	private Integer qtdFuncionarios;
	
	private boolean reduzido;

	public Turno() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public NumeroTurno getNumeroTurno() {
		return numeroTurno;
	}

	public void setNumeroTurno(NumeroTurno turno) {
		this.numeroTurno = turno;
	}

	public Date getHorarioInicio() {
		return horarioInicio;
	}

	public void setHorarioInicio(Date horarioInicio) {
		this.horarioInicio = horarioInicio;
	}

	public Date getHorarioFim() {
		return horarioFim;
	}

	public void setHorarioFim(Date horarioFim) {
		this.horarioFim = horarioFim;
	}
	
	public boolean isReduzido() {
		return reduzido;
	}

	public void setReduzido(boolean reduzido) {
		this.reduzido = reduzido;
	}
	
	public Integer getQtdFuncionarios() {
		return qtdFuncionarios;
	}

	public void setQtdFuncionarios(Integer qtdFuncionarios) {
		this.qtdFuncionarios = qtdFuncionarios;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numeroTurno == null) ? 0 : numeroTurno.hashCode());
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
		Turno other = (Turno) obj;
		if (numeroTurno != other.numeroTurno)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Turno [numeroTurno=" + numeroTurno + ", horarioInicio=" + horarioInicio + ", horarioFim=" + horarioFim
				+ "]";
	}
}
