package mx.org.ccti.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

public class IntegrPagoModelo {
	
	// ***** Declaro Atributos *****
	private String  cuenta;
	private String  cveDefTramite;
	private String  nombre;		// Atributos para mostrar info del ciudadano antes de imprimir. / Carlos M. Luna / 16-Feb-15 
	private String  nombBusq;
	private String  domicilio;	// Fin Atributos ciudadano
	private String  urlReporte;
	private String  mensaje; 
	private String  selctdLocalidad;
	private String  descrLocalidad;		
	private String  lblComentCuenta;
	private String  urlBanorte;
	private String  subTotal;		// Campo nuevo para integrar el pago a Banorte / CLF / Marzo 15
	
	// ***** Declaro Contructor *****
	public IntegrPagoModelo() { }
	
	
	// ***** Declaro Metodos Getter y Setter *****	
	public String getCuenta() {
		return cuenta;
	}
	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}
	public String getCveDefTramite() {
		return cveDefTramite;
	}
	public void setCveDefTramite(String cveDefTramite) {
		this.cveDefTramite = cveDefTramite;
	}
	// Getters y Setters para mostrar info del ciudadano antes de imprimir. / Carlos M. Luna / 16-Feb-15
	public String getNombBusq() {
		return nombBusq;
	}
	public void setNombBusq(String nombBusq) {
		this.nombBusq = nombBusq;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	} 
	// Fin Getters/Setters Ciudadano
	public String getUrlReporte() {
		return urlReporte;
	}
	public void setUrlReporte(String urlReporte) {
		this.urlReporte = urlReporte;
	} 
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}	
	public String getSelctdLocalidad() {
		return selctdLocalidad;
	}
	public void setSelctdLocalidad(String selctdLocalidad) {
		this.selctdLocalidad = selctdLocalidad;
	}	
	public String getDescrLocalidad() {
		return descrLocalidad;
	}
	public void setDescrLocalidad(String descrLocalidad) {
		this.descrLocalidad = descrLocalidad;
	}
	// Getters y setters para mostrar/ocultar comentarios agua y predial
	public String getLblComentCuenta() {
		return lblComentCuenta;
	}
	public void setLblComentCuenta(String lblComentCuenta) {
		this.lblComentCuenta = lblComentCuenta;
	} // Fin mostrar/ocultar comentarios agua y predial
	// Getters y Setters para el monto a pagar
	public String getSubtotal() {
		return subTotal;
	}
	public void setSubtotal(String subTotal) {
		this.subTotal = subTotal;
	} // Fin Monto a pagar
}
