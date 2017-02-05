package br.com.hackathon.scales.enums;

import java.util.Calendar;

public enum DiaSemana {
	
	DOMINGO("Domingo", 1),
	SEGUNDA("Segunda", 2),
	TERCA("Terça", 3),
	QUARTA("Quarta", 4),
	QUINTA("Quinta", 5),
	SEXTA("Sexta", 6),
	SABADO("Sábado", 7);
	
	private String descricao;
	private Calendar calendar;
	
	DiaSemana(String descricao, int dia) {
		this.descricao = descricao;
		
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_WEEK, dia);
		
		this.calendar = calendar;
	}

	public String getDescricao() {
		return descricao;
	}

	public Calendar getCalendar() {
		return calendar;
	}
}
