package br.com.hackathon.scales.enums;

public enum Cargo {
	ATENDENTE("Atendente"),
	SUPERVISOR("supervisor"),
	COORDENADOR("Coordenador"),
	LIDER("Lider");
	
	private String descricao;
	
	Cargo(String descricao) {
		this.descricao = descricao;				
	}

	public String getDescricao() {
		return descricao;
	}
}
