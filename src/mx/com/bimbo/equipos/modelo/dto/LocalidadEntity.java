package mx.com.bimbo.equipos.modelo.dto;

import java.util.Date;

public class LocalidadEntity {
	// Declaro los atributos de la clase
	private Integer idLocalidad;
	private String  localidad;	
	
	
	public LocalidadEntity() { }

	public LocalidadEntity(Integer idLocalidad, String localidad) {
		this.idLocalidad = idLocalidad;
		this.localidad   = localidad;
	}
	
	
	public Integer getIdLocalidad() {
		return idLocalidad;
	}
	public void setIdLocalidad(Integer idLocalidad) {
		this.idLocalidad = idLocalidad;
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	

	@Override
	public String toString() {
		return "LocalidadEntity [idLocalidad=" + idLocalidad + ", localidad=" + localidad + "]";
	}
}
