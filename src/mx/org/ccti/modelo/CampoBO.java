package mx.org.ccti.modelo;

import java.lang.Comparable;

public class CampoBO implements Comparable<CampoBO> {
	
	// Declaro Atributos
	private String xmlCampo;
	private String valor;
	
	
	// Declaro Contructor
	public CampoBO() { }

	
	// Declaro Metodos Getter y Setter
	public String getXmlCampo() {
		return xmlCampo;
	}
	public void setXmlCampo(String xmlCampo) {
		this.xmlCampo = xmlCampo;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	
	
	public int compareTo(CampoBO o) {  
		return (this.xmlCampo.compareTo(o.getXmlCampo()));
	}
	
}
