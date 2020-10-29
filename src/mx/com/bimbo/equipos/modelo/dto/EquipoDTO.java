package mx.com.bimbo.equipos.modelo.dto;

public class EquipoDTO {
	// Declaro Atributos de la Clase 
	private int    id;
	private String estatus;
	private String region;
	private String localidad;
	private String bodega;
	private String razon;
	private String empleado; 
	// Informacion del Equipo a Reemplazar
	private String nombre_cambio; 
	private String serie_cambio; 	
	private String estatus_cambio; 
	private String marca; 	
	private String modelo; 
	// Informacion del Equipo Nuevo
	private String nombre_nuevo; 
	private String serie_nuevo;   
	private String alta;
	private String modelo_nuevo;   
	private String garantia; 
	private String sistema;	
	private String orden;
	private String comentarios; 
	private String programado;
	private String proveedor; 
	private String estatus_control;    
	// Otros Campos del registro del Equipo    
	private String accion;  
	private Integer est;
	private Integer reg;
	private Integer loc;
	private Integer bod;
	private Integer raz;
	private Integer acc;
	private Integer ctrl;	
	// Cambios en el registro
	private String  usuario_modifica;
	private String  fecha_modifica;
	// Campos Nuevos 26Oct2020
	private String mes_renovacion;
	private String ticket;
	private String comm_control;
	
	
	public EquipoDTO() { }
	
	public EquipoDTO(int id, String estatus, String region, String localidad, String bodega, String razon,
			String empleado, String nombre_cambio, String serie_cambio, String estatus_cambio, String marca,
			String modelo, String nombre_nuevo, String serie_nuevo, String alta, String modelo_nuevo, String garantia,
			String sistema, String orden, String comentarios, String programado, String proveedor,
			String estatus_control, String accion, Integer est, Integer reg, Integer loc, Integer bod, Integer raz,
			Integer acc, Integer ctrl, String usuario_modifica, String fecha_modifica, String mes_renovacion, 
			String ticket, String comm_control) {
		this.id = id;
		this.estatus = estatus;
		this.region = region;
		this.localidad = localidad;
		this.bodega = bodega;
		this.razon = razon;
		this.empleado = empleado;
		this.nombre_cambio = nombre_cambio;
		this.serie_cambio = serie_cambio;
		this.estatus_cambio = estatus_cambio;
		this.marca = marca;
		this.modelo = modelo;
		this.nombre_nuevo = nombre_nuevo;
		this.serie_nuevo = serie_nuevo;
		this.alta = alta;
		this.modelo_nuevo = modelo_nuevo;
		this.garantia = garantia;
		this.sistema = sistema;
		this.orden = orden;
		this.comentarios = comentarios;
		this.programado = programado;
		this.proveedor = proveedor;
		this.estatus_control = estatus_control;
		this.accion = accion;
		this.est = est;
		this.reg = reg;
		this.loc = loc;
		this.bod = bod;
		this.raz = raz;
		this.acc = acc;
		this.ctrl = ctrl;
		this.usuario_modifica = usuario_modifica;
		this.fecha_modifica = fecha_modifica;
		// Campos nuevos 26Oct2020
		this.mes_renovacion = mes_renovacion;
		this.ticket	= ticket;
		this.comm_control = comm_control;
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
	public String getNombre_cambio() {
		return nombre_cambio;
	}
	public void setNombre_cambio(String nombre_cambio) {
		this.nombre_cambio = nombre_cambio;
	}
	public String getSerie_cambio() {
		return serie_cambio;
	}
	public void setSerie_cambio(String serie_cambio) {
		this.serie_cambio = serie_cambio;
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
	public String getAlta() {
		return alta;
	}
	public void setAlta(String alta) {
		this.alta = alta;
	}
	public String getModelo_nuevo() {
		return modelo_nuevo;
	}
	public void setModelo_nuevo(String modelo_nuevo) {
		this.modelo_nuevo = modelo_nuevo;
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
	public String getOrden() {
		return orden;
	}
	public void setOrden(String orden) {
		this.orden = orden;
	}
	public String getComentarios() {
		return comentarios;
	}
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
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
	public String getEstatus_control() {
		return estatus_control;
	}
	public void setEstatus_control(String estatus_control) {
		this.estatus_control = estatus_control;
	}
	public String getAccion() {
		return accion;
	}
	public void setAccion(String accion) {
		this.accion = accion;
	}
	public Integer getEst() {
		return est;
	}
	public void setEst(Integer est) {
		this.est = est;
	}
	public Integer getReg() {
		return reg;
	}
	public void setReg(Integer reg) {
		this.reg = reg;
	}
	public Integer getLoc() {
		return loc;
	}
	public void setLoc(Integer loc) {
		this.loc = loc;
	}
	public Integer getBod() {
		return bod;
	}
	public void setBod(Integer bod) {
		this.bod = bod;
	}
	public Integer getRaz() {
		return raz;
	}
	public void setRaz(Integer raz) {
		this.raz = raz;
	}
	public Integer getAcc() {
		return acc;
	}
	public void setAcc(Integer acc) {
		this.acc = acc;
	}
	public Integer getCtrl() {
		return ctrl;
	}
	public void setCtrl(Integer ctrl) {
		this.ctrl = ctrl;
	}
	public String getUsuario_modifica() {
		return usuario_modifica;
	}
	public void setUsuario_modifica(String usuario_modifica) {
		this.usuario_modifica = usuario_modifica;
	}
	public String getFecha_modifica() {
		return fecha_modifica;
	}
	public void setFecha_modifica(String fecha_modifica) {
		this.fecha_modifica = fecha_modifica;
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
