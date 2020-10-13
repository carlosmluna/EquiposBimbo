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
	private Integer est;
	private Integer reg;
	private Integer loc;
	private Integer bod;
	private Integer raz;
	private Integer acc;
	// Cambio el viernes 2 Octubre 2020 
	private String  alta;
	private String  estatus_control;
	private String  nombre_recambio;	
	private String  serie_renombre;	
	
	
	public EquipoDTO() { }
	
	public EquipoDTO(int id, String estatus, String region, String localidad, String bodega, String razon,
			String empleado, String serie_cambio, String nombre_cambio, String estatus_cambio, String marca,
			String modelo, String nombre_nuevo, String serie_nuevo, String modelo_nuevo, String orden, String accion,
			String programado, String proveedor, String comentarios, String archivo, String garantia, String sistema,
			Integer est, Integer reg, Integer loc, Integer bod, Integer raz, Integer acc, String alta,
			String estatus_control, String nombre_recambio, String serie_renombre) {
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
		this.alta = alta;
		this.estatus_control = estatus_control;
		this.nombre_recambio = nombre_recambio;
		this.serie_renombre = serie_renombre;
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
	
	
	@Override
	public String toString() {
		return "EquipoDTO [id=" + id + ", estatus=" + estatus + ", region=" + region + ", localidad=" + localidad
				+ ", bodega=" + bodega + ", razon=" + razon + ", empleado=" + empleado + ", serie_cambio="
				+ serie_cambio + ", nombre_cambio=" + nombre_cambio + ", estatus_cambio=" + estatus_cambio + ", marca="
				+ marca + ", modelo=" + modelo + ", nombre_nuevo=" + nombre_nuevo + ", serie_nuevo=" + serie_nuevo
				+ ", modelo_nuevo=" + modelo_nuevo + ", orden=" + orden + ", accion=" + accion + ", programado="
				+ programado + ", proveedor=" + proveedor + ", comentarios=" + comentarios + ", archivo=" + archivo
				+ ", garantia=" + garantia + ", sistema=" + sistema + ", est=" + est + ", reg=" + reg + ", loc=" + loc
				+ ", bod=" + bod + ", raz=" + raz + ", acc=" + acc + ", alta=" + alta + ", estatus_control="
				+ estatus_control + ", nombre_recambio=" + nombre_recambio + ", serie_renombre=" + serie_renombre + "]";
	}	
}
