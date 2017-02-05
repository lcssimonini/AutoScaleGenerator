package br.com.hackathon.scales.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.hackathon.scales.entities.suport.ErrorSerializer;

@Entity
public class SystemParameter extends ErrorSerializer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private Integer numPontos;
	
	private Integer maxDiasSeguidos;
	
	private Integer minHorasEntreTurnos;
	
	private Integer maxDomingosSeguidos;
	
	public SystemParameter() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNumPontos() {
		return numPontos;
	}

	public void setNumPontos(Integer numPontos) {
		this.numPontos = numPontos;
	}

	public Integer getMaxDiasSeguidos() {
		return maxDiasSeguidos;
	}

	public void setMaxDiasSeguidos(Integer maxDiasSeguidos) {
		this.maxDiasSeguidos = maxDiasSeguidos;
	}

	public Integer getMinHorasEntreTurnos() {
		return minHorasEntreTurnos;
	}

	public void setMinHorasEntreTurnos(Integer minHorasEntreTurnos) {
		this.minHorasEntreTurnos = minHorasEntreTurnos;
	}

	public Integer getMaxDomingosSeguidos() {
		return maxDomingosSeguidos;
	}

	public void setMaxDomingosSeguidos(Integer maxDomingosSeguidos) {
		this.maxDomingosSeguidos = maxDomingosSeguidos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		SystemParameter other = (SystemParameter) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SystemParameter [numPontos=" + numPontos + ", maxDiasSeguidos=" + maxDiasSeguidos
				+ ", minHorasEntreTurnos=" + minHorasEntreTurnos + ", maxDomingosSeguidos=" + maxDomingosSeguidos + "]";
	}
}
