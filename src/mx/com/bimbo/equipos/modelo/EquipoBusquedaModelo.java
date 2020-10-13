package mx.com.bimbo.equipos.modelo;

import java.util.List;

import javax.faces.model.SelectItem;

import mx.com.bimbo.equipos.modelo.dto.EquipoDTO;

public class EquipoBusquedaModelo {
	private String id;
	private String estatus;
	private String region;
	private String localidad;
	private String bodega;
	private String razonSocial;
	private String modelo;
	private String accion;
	private String programacion;
	private String proveedor;
	private List<SelectItem> localidadesList;
	private List<String>     equiposList;
	private List<EquipoDTO>	 equipos;
	
	
	public EquipoBusquedaModelo() { }
	
	public EquipoBusquedaModelo(String id, String estatus, String region, String localidad, String bodega, String razonSocial,
			String modelo, String accion, String programacion, String proveedor, List<SelectItem> localidadesList,
			List<String> equiposList, List<EquipoDTO> equipos) {
		this.id              = id;
		this.estatus 		 = estatus;
		this.region 		 = region;
		this.localidad 		 = localidad;
		this.bodega 		 = bodega;
		this.razonSocial 	 = razonSocial;
		this.modelo 		 = modelo;
		this.accion 		 = accion;
		this.programacion 	 = programacion;
		this.proveedor 		 = proveedor;
		this.localidadesList = localidadesList;
		this.equiposList 	 = equiposList;
		this.equipos 	 	 = equipos;
	}
	
	
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
	public String getProgramacion() {
		return programacion;
	}
	public void setProgramacion(String programacion) {
		this.programacion = programacion;
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
	public List<EquipoDTO> getEquipos() {
		return equipos;
	}
	public void setEquipos(List<EquipoDTO> equipos) {
		this.equipos = equipos;
	}

	@Override
	public String toString() {
		return "EquipoBusquedaModelo [estatus=" + estatus + ", region=" + region + ", localidad=" + localidad
				+ ", bodega=" + bodega + ", razonSocial=" + razonSocial + ", modelo=" + modelo + ", accion=" + accion
				+ ", programacion=" + programacion + ", proveedor=" + proveedor + ", localidadesList=" + localidadesList
				+ ", equiposList=" + equiposList + ", equipos=" + equipos + "]";
	}
}
