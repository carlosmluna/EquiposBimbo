package mx.com.bimbo.equipos.modelo.dto;

import java.util.List;

public class ParamsEquipos {
	private List<String> equipos;

	public List<String> getEquipos() {
		return equipos;
	}
	public void setEquipos(List<String> equipos) {
		this.equipos = equipos;
	}
	
	@Override
	public String toString() {
		return "ParamsEquipos [equipos=" + equipos + "]";
	}	
}
