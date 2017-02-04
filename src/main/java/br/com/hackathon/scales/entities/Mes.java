package br.com.hackathon.scales.entities;

import java.util.Calendar;

public enum Mes {
	JANEIRO("Janeiro", 0),
	FEVEREIRO("Fevereiro", 0),
	MARCO("Março", 0),
	ABRIL("Abril", 0),
	MAIO("Maio", 0),
	JUNHO("Junho", 0),
	JULHO("Julho", 0),
	AGOSTO("Agosto", 0),
	SETEMBO("Setembro", 0),
	OUTUBRO("Outubro", 0),
	NOVEMBRO("Novemro", 0),
	DEZEMBRO("Dezembro", 0);
	
	private String descricao;
	private Calendar calendar;
	
	Mes(String descricao, int mes) {
		this.descricao = descricao;
		
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.MONTH, mes);
		
		this.calendar = calendar;
	}

	public Calendar getCalendar() {
		return calendar;
	}

	public String getDescricao() {
		return descricao;
	}
}
