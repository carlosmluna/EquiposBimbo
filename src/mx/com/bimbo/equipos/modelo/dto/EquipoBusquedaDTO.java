package mx.com.bimbo.equipos.modelo.dto;

import java.util.List;

import javax.faces.model.SelectItem;

public class EquipoBusquedaDTO {
	// Declaro Atributos de la Clase 
	private String id;
	private String estatus;
	private String region;
	private String localidad;
	private String bodega;
	private String razonSocial;
	private String modelo;
	private String accion;
	private String fechaProgramacion;
	private String proveedor;
	private List<SelectItem> localidadesList;
	private List<String>     equiposList;

	
	
	public EquipoBusquedaDTO() { }
	
	public EquipoBusquedaDTO(String id, String estatus, String region, String localidad, String bodega, String razonSocial,
			String modelo, String accion, String fechaProgramacion, String proveedor, List<SelectItem> localidadesList,
			List<String> equiposList) {
		this.id   		 = id;
		this.estatus 	 = estatus;
		this.region 	 = region;
		this.localidad 	 = localidad;
		this.bodega 	 = bodega;
		this.razonSocial = razonSocial;
		this.modelo      = modelo;
		this.accion 	 = accion;
		this.fechaProgramacion = fechaProgramacion;
		this.proveedor   = proveedor;
		this.localidadesList = localidadesList;
		this.equiposList = equiposList; 
	}

	// MEtodos Getter y Setters de los atributos
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	public String getBodega() {
		return bodega;
	}
	public void setBodega(String bodega) {
		this.bodega = bodega;
	}
	public String getRazonSocial() {
		return razonSocial;
	}
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getAccion() {
		return accion;
	}
	public void setAccion(String accion) {
		this.accion = accion;
	}
	public String getFechaProgramacion() {
		return fechaProgramacion;
	}
	public void setFechaProgramacion(String fechaProgramacion) {
		this.fechaProgramacion = fechaProgramacion;
	}
	public String getProveedor() {
		return proveedor;
	}
	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}	
	public List<SelectItem> getLocalidadesList() {
		return localidadesList;
	}
	public void setLocalidadesList(List<SelectItem> localidadesList) {
		this.localidadesList = localidadesList;
	}
	public List<String> getEquiposList() {
		return equiposList;
	}
	public void setEquiposList(List<String> equiposList) {
		this.equiposList = equiposList;
	}

	@Override
	public String toString() {
		return "EquipoBusquedaDTO [estatus=" + estatus + ", region=" + region + ", localidad=" + localidad + ", bodega="
				+ bodega + ", razonSocial=" + razonSocial + ", modelo=" + modelo + ", accion=" + accion
				+ ", fechaProgramacion=" + fechaProgramacion + ", proveedor=" + proveedor + ", localidadesList="
				+ localidadesList + ", equiposList=" + equiposList + "]";
	}
}
