package it.polito.tdp.anagrammi.model;

public class Parola {

	private int codice;
	private String parola;
	
	public Parola(int codice, String parola) {
		super();
		this.codice = codice;
		this.parola = parola;
	}
	
	public int getCodice() {
		return codice;
	}
	public void setCodice(int codice) {
		this.codice = codice;
	}
	public String getParola() {
		return parola;
	}
	public void setParola(String parola) {
		this.parola = parola;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codice;
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
		Parola other = (Parola) obj;
		if (codice != other.codice)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return parola;
	}
	
	
}
