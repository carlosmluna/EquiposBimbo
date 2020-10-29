package mx.com.bimbo.equipos.modelo;

import java.util.List;

import javax.faces.model.SelectItem;

import mx.com.bimbo.equipos.modelo.dto.EquipoDTO;

public class EquipoModelo {
	private int    id;
	private String estatus;
	private String region;
	private String localidad;
	private String bodega;
	private String razon;
	private String empleado; 
	private String serie_cambio; 
	private String nombre_cambio; 
	private String estatus_cambio; 
	private String marca; 	
	private String modelo; 
	private String nombre_nuevo; 
	private String serie_nuevo;   
	private String modelo_nuevo;   
	private String orden;
	private String accion;   
	private String programado;   
	private String proveedor;     
	private String comentarios;    
	private String archivo;
	private String garantia; 
	private String sistema;	
	// Cambio el viernes 2 Octubre 2020 
	private int est;
	private int reg;
	private int loc;
	private int bod;
	private int raz;
	private int acc;
	private int ctrl;
	// Cambio el viernes 2 Octubre 2020 
	private String  alta;
	private String  estatus_control;
	private String  nombre_recambio;	
	private String  serie_renombre;	
	// Varios campos
	private String modificado_por;
	private String fecha_modifica;
	private List<SelectItem> localidadesList;	
	// Campos Nuevos 26Oct2020
	private String mes_renovacion;
	private String ticket;
	private String comm_control;
	
	
	public EquipoModelo() { }
	
	public EquipoModelo(int id, String estatus, String region, String localidad, String bodega, String razon,
			String empleado, String serie_cambio, String nombre_cambio, String estatus_cambio, String marca,
			String modelo, String nombre_nuevo, String serie_nuevo, String modelo_nuevo, String orden, String accion,
			String programado, String proveedor, String comentarios, String archivo, String garantia, String sistema,
			int est, int reg, int loc, int bod, int raz, int acc, int ctrl, String alta,
			String estatus_control, String nombre_recambio, String serie_renombre, String modificado_por,
			String fecha_modifica, List<SelectItem> localidadesList, String mes_renovacion, String ticket,
			String comm_control) {
		this.id = id;
		this.estatus = estatus;
		this.region = region;
		this.localidad = localidad;
		this.bodega = bodega;
		this.razon = razon;
		this.empleado = empleado;
		this.serie_cambio = serie_cambio;
		this.nombre_cambio = nombre_cambio;
		this.estatus_cambio = estatus_cambio;
		this.marca = marca;
		this.modelo = modelo;
		this.nombre_nuevo = nombre_nuevo;
		this.serie_nuevo = serie_nuevo;
		this.modelo_nuevo = modelo_nuevo;
		this.orden = orden;
		this.accion = accion;
		this.programado = programado;
		this.proveedor = proveedor;
		this.comentarios = comentarios;
		this.archivo = archivo;
		this.garantia = garantia;
		this.sistema = sistema;
		this.est = est;
		this.reg = reg;
		this.loc = loc;
		this.bod = bod;
		this.raz = raz;
		this.acc = acc;
		this.ctrl = ctrl;
		this.alta = alta;
		this.estatus_control = estatus_control;
		this.nombre_recambio = nombre_recambio;
		this.serie_renombre = serie_renombre;
		this.modificado_por = modificado_por;
		this.fecha_modifica = fecha_modifica;
		this.localidadesList = localidadesList;
		// 26Oct2020 - Campos Nuevos
		this.mes_renovacion = mes_renovacion;
		this.ticket 		= ticket;
		this.comm_control 	= comm_control;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public String getRazon() {
		return razon;
	}
	public void setRazon(String razon) {
		this.razon = razon;
	}
	public String getEmpleado() {
		return empleado;
	}
	public void setEmpleado(String empleado) {
		this.empleado = empleado;
	}
	public String getSerie_cambio() {
		return serie_cambio;
	}
	public void setSerie_cambio(String serie_cambio) {
		this.serie_cambio = serie_cambio;
	}
	public String getNombre_cambio() {
		return nombre_cambio;
	}
	public void setNombre_cambio(String nombre_cambio) {
		this.nombre_cambio = nombre_cambio;
	}
	public String getEstatus_cambio() {
		return estatus_cambio;
	}
	public void setEstatus_cambio(String estatus_cambio) {
		this.estatus_cambio = estatus_cambio;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getNombre_nuevo() {
		return nombre_nuevo;
	}
	public void setNombre_nuevo(String nombre_nuevo) {
		this.nombre_nuevo = nombre_nuevo;
	}
	public String getSerie_nuevo() {
		return serie_nuevo;
	}
	public void setSerie_nuevo(String serie_nuevo) {
		this.serie_nuevo = serie_nuevo;
	}
	public String getModelo_nuevo() {
		return modelo_nuevo;
	}
	public void setModelo_nuevo(String modelo_nuevo) {
		this.modelo_nuevo = modelo_nuevo;
	}
	public String getOrden() {
		return orden;
	}
	public void setOrden(String orden) {
		this.orden = orden;
	}
	public String getAccion() {
		return accion;
	}
	public void setAccion(String accion) {
		this.accion = accion;
	}
	public String getProgramado() {
		return programado;
	}
	public void setProgramado(String programado) {
		this.programado = programado;
	}
	public String getProveedor() {
		return proveedor;
	}
	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}
	public String getComentarios() {
		return comentarios;
	}
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
	public String getArchivo() {
		return archivo;
	}
	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}
	public String getGarantia() {
		return garantia;
	}
	public void setGarantia(String garantia) {
		this.garantia = garantia;
	}
	public String getSistema() {
		return sistema;
	}
	public void setSistema(String sistema) {
		this.sistema = sistema;
	}
	public int getEst() {
		return est;
	}
	public void setEst(int est) {
		this.est = est;
	}
	public int getReg() {
		return reg;
	}
	public void setReg(int reg) {
		this.reg = reg;
	}
	public int getLoc() {
		return loc;
	}
	public void setLoc(int loc) {
		this.loc = loc;
	}
	public int getBod() {
		return bod;
	}
	public void setBod(int bod) {
		this.bod = bod;
	}
	public int getRaz() {
		return raz;
	}
	public void setRaz(int raz) {
		this.raz = raz;
	}
	public int getAcc() {
		return acc;
	}
	public void setAcc(int acc) {
		this.acc = acc;
	}	
	public int getCtrl() {
		return ctrl;
	}
	public void setCtrl(int ctrl) {
		this.ctrl = ctrl;
	}
	public String getAlta() {
		return alta;
	}
	public void setAlta(String alta) {
		this.alta = alta;
	}
	public String getEstatus_control() {
		return estatus_control;
	}
	public void setEstatus_control(String estatus_control) {
		this.estatus_control = estatus_control;
	}
	public String getNombre_recambio() {
		return nombre_recambio;
	}
	public void setNombre_recambio(String nombre_recambio) {
		this.nombre_recambio = nombre_recambio;
	}
	public String getSerie_renombre() {
		return serie_renombre;
	}
	public void setSerie_renombre(String serie_renombre) {
		this.serie_renombre = serie_renombre;
	}
	public String getModificado_por() {
		return modificado_por;
	}
	public void setModificado_por(String modificado_por) {
		this.modificado_por = modificado_por;
	}
	public String getFecha_modifica() {
		return fecha_modifica;
	}
	public void setFecha_modifica(String fecha_modifica) {
		this.fecha_modifica = fecha_modifica;
	}
	public List<SelectItem> getLocalidadesList() {
		return localidadesList;
	}
	public void setLocalidadesList(List<SelectItem> localidadesList) {
		this.localidadesList = localidadesList;
	}
	public String getMes_renovacion() {
		return mes_renovacion;
	}
	public void setMes_renovacion(String mes_renovacion) {
		this.mes_renovacion = mes_renovacion;
	}
	public String getTicket() {
		return ticket;
	}
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}
	public String getComm_control() {
		return comm_control;
	}
	public void setComm_control(String comm_control) {
		this.comm_control = comm_control;
	}
}
