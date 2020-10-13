package mx.com.bimbo.equipos.modelo;

public class UsaurioModelo {
	// Declaro Atributos de la calse
	private String usuario;
	private String password;
	private String mensaje;
	private int    administrador;
	
	
	// Metodos Constructores
	public UsaurioModelo() { }
	
	public UsaurioModelo(String usuario, String password, String mensaje, int administrador) {
		this.usuario  = usuario;
		this.password = password;
		this.mensaje  = mensaje;
		this.administrador = administrador;
	}
	
	
	// Metodos Getter y Setter
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public int getAdministrador() {
		return administrador;
	}
	public void setAdministrador(int administrador) {
		this.administrador = administrador;
	}
	

	// Implemento metodo toString
	@Override
	public String toString() {
		return "LoginModelo [usuario=" + usuario + ", password=" + password + ", mensaje=" + mensaje
				+ ", administrador=" + administrador + "]";
	}
	
}
