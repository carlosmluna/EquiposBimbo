package mx.com.bimbo.equipos.beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import mx.com.bimbo.equipos.modelo.LoginModelo;
import mx.com.bimbo.equipos.modelo.dto.UsuarioDTO;
import mx.com.bimbo.equipos.service.UsuariosService;
import mx.com.bimbo.equipos.util.Constantes;

@ManagedBean(name = "loginSesionBean", eager = true)
@SessionScoped
public class LoginBean {
	private LoginModelo loginModelo;	
	
	
	// Metodo Constructor
	public LoginBean() {
		loginModelo = new LoginModelo(); 
		this.limpiaCamposPantalla();
	}

	
	// Limpio campos de pantalla
	private void limpiaCamposPantalla() {
		loginModelo.setUsuario( Constantes.CHAR_VACIO );
		loginModelo.setPassword( Constantes.CHAR_VACIO );
		loginModelo.setMensaje( Constantes.CHAR_VACIO );
		loginModelo.setAdministrador(0);
	}
	
	
	public String validarIngresoEquipoBimbo() {	
		UsuariosService usuarioService = new UsuariosService();
		
		String pagina  = "";
		String usuario = loginModelo.getUsuario();
		
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
		
		UsuarioDTO usuarioDTO = usuarioService.buscarUsuarioMSSericcio( usuario );				
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


	// MEtodos Getter y Setters
	public LoginModelo getLoginModelo() {
		return loginModelo;
	}
	public void setLoginModelo(LoginModelo loginModelo) {
		this.loginModelo = loginModelo;
	}
	
}
