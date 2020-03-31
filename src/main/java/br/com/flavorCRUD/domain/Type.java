package br.com.flavorCRUD.domain;

public enum Type {
	
	SALGADA("Salgada"), 
	DOCE("Doce"), 
	VEGETARIANA("Vegetariana");
	
	private String value;
	
	private Type(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
}
