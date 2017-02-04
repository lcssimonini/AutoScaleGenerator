package br.com.hackathon.scales.entities.suport;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Transient;

public abstract class ErrorSerializer {
	
	@Transient
	private List<String> errorsList = new ArrayList<String>();
	
	public List<String> getErrorsList() {
		return errorsList;
	}

	public void setErrorsList(List<String> errorsList) {
		this.errorsList = errorsList;
	}
	
	public void addErrorMessage(String message) {
		this.errorsList.add(message);
	}
	
	public boolean hasErrors() {
		return !this.errorsList.isEmpty();
	}
}
