package br.com.hackathon.scales.enums;

import java.util.Calendar;

public enum Mes {
	JANEIRO("Janeiro", 0),
	FEVEREIRO("Fevereiro", 1),
	MARCO("Março", 2),
	ABRIL("Abril", 3),
	MAIO("Maio", 4),
	JUNHO("Junho", 5),
	JULHO("Julho", 6),
	AGOSTO("Agosto", 7),
	SETEMBO("Setembro", 8),
	OUTUBRO("Outubro", 9),
	NOVEMBRO("Novemro", 10),
	DEZEMBRO("Dezembro", 11);
	
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
