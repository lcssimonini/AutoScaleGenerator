package br.com.hackathon.scales.entities;

public enum NumeroTurno {
	
	PRIMEIRO("Primeiro turno"),
	SEGUNDO("Segundo turno"),
	TERCEIRO("Terceiro turno"),
	QUARTO("Quarto turno"),
	QUINTO("Quinto turno");
	
	String descricao;
	
	NumeroTurno(String descricao) {
		this.descricao = descricao;
	}
}
