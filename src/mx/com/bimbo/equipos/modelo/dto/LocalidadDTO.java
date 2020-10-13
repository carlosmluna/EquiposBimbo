package mx.com.bimbo.equipos.modelo.dto;

import java.util.Date;

public class LocalidadDTO {
	// Declaro los atributos de la clase
	private Integer id_localidad;
	private String  localidad;	
	
	
	public LocalidadDTO() { }

	public LocalidadDTO(Integer id_localidad, String localidad) {
		this.id_localidad = id_localidad;
		this.localidad    = localidad;
	}
		
	public Integer getId_localidad() {
		return id_localidad;
	}
	public void setId_localidad(Integer id_localidad) {
		this.id_localidad = id_localidad;
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	

	@Override
	public String toString() {
		return "LocalidadEntity [id_localidad=" + id_localidad + ", localidad=" + localidad + "]";
	}
}
