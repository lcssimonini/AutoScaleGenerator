package br.com.hackathon.scales.entities;

public enum NumeroTurno {
	
	PRIMEIRO("Primeiro turno", 0),
	SEGUNDO("Segundo turno", 1),
	TERCEIRO("Terceiro turno", 2),
	QUARTO("Quarto turno", 3),
	QUINTO("Quinto turno", 4);
	
	String descricao;
	int ordem;
	
	NumeroTurno(String descricao, int ordem) {
		this.descricao = descricao;
		this.ordem = ordem;
	}
}
