package mx.com.bimbo.equipos.modelo.dto;

import java.util.List;

public class GrupoBusquedaDTO {
	// Declaro atributos de la clase
	private List<String> personas;
	
	
	public List<String> getPersonas() {
		return personas;
	}
	public void setPersonas(List<String> personas) {
		this.personas = personas;
	}

	@Override
	public String toString() {
		return "GrupoBusquedaDTO [personas=" + personas + "]";
	}	

}
