package br.com.hackathon.scales.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
public class Escala {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private Mes mes;
	
	@NotNull(message = "O horário de início deve ser informado")
	@Temporal(value=TemporalType.DATE)
	private Date diaInicio;
	
	@NotNull(message = "O horário de fim deve ser informado")
	@Temporal(value=TemporalType.DATE)
	private Date diaFim;
	
	public Escala() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Mes getMes() {
		return mes;
	}

	public void setMes(Mes mes) {
		this.mes = mes;
	}

	public Date getDiaInicio() {
		return diaInicio;
	}

	public void setDiaInicio(Date diaInicio) {
		this.diaInicio = diaInicio;
	}

	public Date getDiaFim() {
		return diaFim;
	}

	public void setDiaFim(Date diaFim) {
		this.diaFim = diaFim;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((diaFim == null) ? 0 : diaFim.hashCode());
		result = prime * result + ((diaInicio == null) ? 0 : diaInicio.hashCode());
		result = prime * result + ((mes == null) ? 0 : mes.hashCode());
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
		Escala other = (Escala) obj;
		if (diaFim == null) {
			if (other.diaFim != null)
				return false;
		} else if (!diaFim.equals(other.diaFim))
			return false;
		if (diaInicio == null) {
			if (other.diaInicio != null)
				return false;
		} else if (!diaInicio.equals(other.diaInicio))
			return false;
		if (mes != other.mes)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Escala [mes=" + mes + ", diaInicio=" + diaInicio + ", diaFim=" + diaFim + "]";
	}
}
