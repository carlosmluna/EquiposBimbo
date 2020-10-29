package mx.com.bimbo.equipos.beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import mx.com.bimbo.equipos.modelo.LoginModelo;
import mx.com.bimbo.equipos.modelo.dto.UsuarioDTO;
import mx.com.bimbo.equipos.service.UsuariosService;
import mx.com.bimbo.equipos.util.Constantes;

@ManagedBean(name = "usuarioBean", eager = true)
@RequestScoped
public class UsuarioBean {
	private LoginModelo loginModelo;

	public LoginModelo getLoginModelo() {
		return loginModelo;
	}
	public void setLoginModelo(LoginModelo loginModelo) {
		this.loginModelo = loginModelo; 
	}
	
	
	public UsuarioBean() {
		loginModelo = new LoginModelo(); 
	}	
	
	
	public String validarIngresoEquipoBimbo() {	
		UsuariosService usuarioService = new UsuariosService();
		
		FacesContext fcesContext = FacesContext.getCurrentInstance();
		if ( loginModelo.getUsuario().equals("") ) {
			fcesContext.addMessage(null, new FacesMessage("Error",  "Capture el 'Usuario'. Este valor es requerido") );
			return Constantes.PGE_LOGIN;
		} 
		if ( loginModelo.getPassword().equals("") ) {
			fcesContext.addMessage(null, new FacesMessage("Error",  "Capture la 'Contraseña'. Este valor es requerido") );
			return Constantes.PGE_LOGIN;
		} 
		System.out.println("Ingresando a la aplicacion .... ");
		
		String pagina  = "";
		String usuario = loginModelo.getUsuario();
		
		UsuarioDTO usuarioDTO = usuarioService.buscarRegistroUsuario( usuario );				
		if ( usuarioDTO!=null && usuarioDTO.getId_usuario()!=0 ) {
			FacesContext context  = javax.faces.context.FacesContext.getCurrentInstance();
			HttpSession session   = (HttpSession) context.getExternalContext().getSession(false);
			session.setAttribute("usaurio", usuario);
			session.setAttribute("administrador", usuarioDTO.getAdministrador());
			
			pagina = Constantes.PGE_SRCH_EQUIPO; 
		} else {
			pagina = Constantes.PGE_LOGIN;   	 } 
 		
		return pagina;
	}
	
	
	public String guardarUsuario() {	
		UsuariosService usuarioService = new UsuariosService();
		
		String pagina  = "";
		String usuario = loginModelo.getUsuario();
		
		/* UsuarioDTO usuarioDTO = usuarioService.buscarUsuarioMSSericcio( usuario );				
		if ( usuarioDTO!=null && usuarioDTO.getId_usuario()!=0 ) {
			FacesContext context  = javax.faces.context.FacesContext.getCurrentInstance();
			HttpSession session   = (HttpSession) context.getExternalContext().getSession(false);
			session.setAttribute("usaurio", usuario);
			session.setAttribute("administrador", usuarioDTO.getAdministrador());
			
			pagina = Constantes.PGE_SRCH_EQUIPO; 
		} else {
			pagina = Constantes.PGE_LOGIN;   	 } */
 		
		return "buscarUsuario";
	}
}
