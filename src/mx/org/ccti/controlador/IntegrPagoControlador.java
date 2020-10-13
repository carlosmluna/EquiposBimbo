package mx.org.ccti.controlador;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import mx.org.ccti.modelo.IntegrPagoModelo;
import mx.org.ccti.modelo.Mensaje;
import mx.org.ctti.bd.BaseDatos;
import mx.org.ccti.util.Constantes;
import mx.org.ccti.util.Utilidades;

/* 	Descripc : Clase que inicializa objetos, variables y limpia campos de pantalla 
 	Proceso  : 
 	 	* Instancia objetos. En este caso el Modelo 'IntegrPagoModelo'
 	 	* Toma informacion de la URL. (La variable 'cveDefTramite')
 	 	* Valida la existencia de la variable 'cveDefTramite', El Numero de cuenta y Localidad.
 	 		- Si es nula. Termina la ejecucion
 	 		- Si es un espacio en blanco Termino la ejecución. 
 	 		- Si no selecciona una localidad, Termino la ejeccion
 	 		( En cualquiera de estas excepciones se envia un mensaje a pantalla )	 		 
 	 	* Coloca el valor de la variable 'DefinicionTramite' en un campo en pantalla.
 	 	* Limpio campos de pantalla:
 	 		- Mensaje
 	 		- Url del Reporte
*/
@ManagedBean(name = "integrPagoControlador", eager = true)
@SessionScoped
public class IntegrPagoControlador {
	Constantes constantes = new Constantes();
	
	private IntegrPagoModelo integrPagoModelo;	
	
	// ***** Contructor ***** { }
	// Método Constructor de la clase, este instancia objetos,  inicializa valores y campos y coloca valores en la página.
	public IntegrPagoControlador() { 
		integrPagoModelo = new IntegrPagoModelo(); 
		
		// integrPagoModelo.setUrlBanorte("https://via.banorte.com/bancybhosted/index.do?MERCHANT_ID=123456");
		
		// Tomo el codigo De Definicion de Tramite de la URL y la coloco en el modelo
		FacesContext facesContext = FacesContext.getCurrentInstance();
        String urlDefTramite = facesContext.getExternalContext().getRequestParameterMap().get("cveDefTramite");
        if (urlDefTramite == null )        { return; } 
        else if (urlDefTramite.equals("")) { return; }
        else { 
        	integrPagoModelo.setCveDefTramite(urlDefTramite); }
        
        // Limpio valores de la pantalla
        limpiaCamposPantalla();        
        
        // Muestro/escondo campos o valores de la pantalla
        muestraEtiquetasPantalla();               
	}
	
	
	// ***** Getters y Setters *****
	// Metodod  getter y setter del atributo integrPagoModelo
	public IntegrPagoModelo getIntegrPagoModelo() {
		return integrPagoModelo; }
	public void setIntegrPagoModelo(IntegrPagoModelo integrPagoModelo) {
		this.integrPagoModelo = integrPagoModelo; }	
	

	// ***** Metodos del Controlador *****
	/* Descripc : Método que valida valores de url y pantalla para después realizar la búsqueda de información para llenar las plantillas y el formato de pago.
 	   Proceso  : 
 	 	* Instancia objetos. Constantes, BaseDatos, Utilidades y Mensaje
 	 	* Valida la existencia de la variable 'cveDefTramite', El Numero de cuenta y Localidad.
 	 		- Si es nula. Termina la ejecucion
 	 		- Si es un espacio en blanco Termino la ejecución. 
 	 		- Si no selecciona una localidad, Termino la ejeccion
 	 		( En cualquiera de estas excepciones se envia un mensaje a pantalla )	 		 
 	 	* Busca la informacion en BD para llenar las plantillas xls y pdf.
 	 	* Si existe un error en el paso anterior envia un mensaje a la pantalla y termino la ejecucion
 	 	* Si es Exitoso muestra el PDF para darle opcion al usuario de verlo, guardarlo o imprimirlo
	*/
	public String generaIntegracionPagoPDF() {	
		Constantes constants  = new Constantes();
		BaseDatos  baseDatos  = new BaseDatos();
		Utilidades utilidades = new Utilidades();
		Mensaje    mensaje    = new Mensaje();
		
		String vsCuenta     = "";
		String vscveDefTram = "";
		String vsLocalidad  = "";		
		String resultado    = "";
		String vPagina      = "";			
		
		String vCodigoVal = validaCamposPantallaBean();		// Valido que el campo Definicion Tramite, No de Cuenta y Localidad tenga valor
		if ( vCodigoVal.equals(constants.COD_EXITO) ) {
			vsCuenta     = integrPagoModelo.getCuenta();
			vscveDefTram = integrPagoModelo.getCveDefTramite();
			vsLocalidad  = integrPagoModelo.getSelctdLocalidad();
			resultado = baseDatos.conultaInformacionLlenadoPDF( integrPagoModelo ); 
			
			if ( !resultado.equals("Operacion Exitosa") ) {
				integrPagoModelo.setMensaje(resultado); }
			else {				
				integrPagoModelo.setMensaje(Constantes.CHAR_VACIO);
				vPagina = constants.PG_INTEGPGO; }
		}		
        return constants.CHAR_VACIO;
	}
	
	
	/* Descripc : Método que valida valores de url y pantalla para después realizar la búsqueda de información del ciudadano antes de generar el formatos.
	   Proceso  : 
	 	* Instancia objetos. Constantes y BaseDatos
	 	* Valida la existencia de la variable 'cveDefTramite', El Numero de cuenta y Localidad.
	 		- Si es nula. Termina la ejecucion
	 		- Si es un espacio en blanco Termino la ejecución. 
	 		- Si no selecciona una localidad, Termino la ejeccion
	 		( En cualquiera de estas excepciones se envia un mensaje a pantalla )	 		 
	 	* Busca la informacion en BD del ciudadano.
	 	* Si existe un error en el paso anterior envia un mensaje a la pantalla y termino la ejecucion
	 	* Si es Exitoso la busqueda, muestra la pantalla de confirmacion
	*/
	public String buscaInformacionCiudadano() {			
		BaseDatos  baseDatos  = new BaseDatos();	
		Constantes constants  = new Constantes();
		String     pgReturn = "";
		
		String vCodigoVal = validaCamposPantallaBean();		// Valido que el campo Definicion Tramite, No de Cuenta y Localidad tenga valor
		if ( vCodigoVal.equals(constants.COD_EXITO) ) {
			Mensaje mensaje = baseDatos.consultaCiudadanoIntegrPago(integrPagoModelo);
			integrPagoModelo.setMensaje( mensaje.getDescripcion() );
			if ( mensaje.getCodigo().equals( constants.COD_EXITO ) ) {	
				pgReturn = constants.PG_CONFIRM; }
			else {		
				pgReturn = constants.CHAR_VACIO; }			
		}
		
		return pgReturn;
	} // buscaInformacionCiudadano
	
			
	/* Descripc : Regreso a la pagina de busqueda de la cuenta 
	   Proceso  : 
	 	* Regresa el nombre de la pagina a mostrar
	*/
	public String regresarPaginaInicial() {
		Constantes constants = new Constantes();
		
		// limpio los campos de buqueda
		integrPagoModelo.setCuenta(constants.CHAR_VACIO);
		integrPagoModelo.setSelctdLocalidad("0");
		integrPagoModelo.setNombre(constants.CHAR_VACIO);
		integrPagoModelo.setDomicilio(constants.CHAR_VACIO);
		integrPagoModelo.setMensaje(constants.CHAR_VACIO);
		integrPagoModelo.setNombBusq(constants.CHAR_VACIO);
		
		return constants.PG_INTEGPGO;		
	} // regresarPaginaInicial
			
	
	/* Descripc : Método que valida valores de url y pantalla y regresa un codigo de aceptacion o rechazo
	   Proceso  : 
	 	* Instancia objetos. Constantes, BaseDatos y  Utilidades
	 	* Valida la existencia de la variable 'cveDefTramite', El Numero de cuenta y Localidad.
	 		- Si es nula. Termina la ejecucion
	 		- Si es un espacio en blanco Termino la ejecución. 
	 		- Si no selecciona una localidad, Termino la ejeccion
	 		( En cualquiera de estas excepciones se envia un mensaje a pantalla )	 		 
	 	* Regresa el codigo de exito
	*/
	private String validaCamposPantallaBean() {			
		// Instancio referencias a objetos
		Constantes constants  = new Constantes();
		Utilidades utilidades = new Utilidades();		
		String     vCodigoVal = constants.COD_EXITO;	
		
		// Valido que el campo Definicion Tramite, No de Cuenta y Localidad tenga valor
		if ( vCodigoVal.equals(constants.COD_EXITO) && !utilidades.valVerificaCapturaTextoUrl( integrPagoModelo.getCveDefTramite() ).getCodigo().equals(constants.COD_EXITO) ) {
			vCodigoVal = constants.COD_ERRDEFPGO; 
			integrPagoModelo.setMensaje(constants.DESC_ERRDEFPGO); }		
		if ( vCodigoVal.equals(constants.COD_EXITO) && !utilidades.valVerificaCapturaTextoUrl( integrPagoModelo.getCuenta() ).getCodigo().equals(constants.COD_EXITO) ) {
			vCodigoVal = constants.COD_ERRCUENTA; 
			integrPagoModelo.setMensaje(constants.DESC_ERRCUENTA); }			
		if ( vCodigoVal.equals(constants.COD_EXITO) && !utilidades.valVerificaSeleccionCombo( integrPagoModelo.getSelctdLocalidad() ).getCodigo().equals(constants.COD_EXITO) ) {
			vCodigoVal = constants.COD_ERRLOCALD; 
			integrPagoModelo.setMensaje(constants.DESC_ERRLOCALD); }
		if ( vCodigoVal.equals(constants.COD_EXITO) && !utilidades.valVerificaCapturaTextoUrl( integrPagoModelo.getNombBusq() ).getCodigo().equals(constants.COD_EXITO) ) {
			vCodigoVal = constants.COD_ERRNOMBRE; 
			integrPagoModelo.setMensaje(constants.DESC_ERRNOMBRE); }
		
		// regreso el codigo de exito/Error
		return vCodigoVal;
	}
	
	
	// Limpio campos de pantalla
	private void limpiaCamposPantalla() {
		integrPagoModelo.setMensaje("");
        integrPagoModelo.setUrlReporte("");
	}
	
	
	// Muestra/Oculta labels de la pantalla
	private void muestraEtiquetasPantalla() {
		if ( integrPagoModelo.getCveDefTramite().equals(constantes.TRM_AGUA) ) {
        	integrPagoModelo.setLblComentCuenta(constantes.LBL_AGUA); }
        else if ( integrPagoModelo.getCveDefTramite().equals(constantes.TRM_PREDIAL) ) {
        	integrPagoModelo.setLblComentCuenta(constantes.LBL_PREDIAL); }
        else {
        	integrPagoModelo.setLblComentCuenta(constantes.CHAR_VACIO); }
	}
	
	
	// Muestra la pantalla para realizar el pago en Banorte
	// 17 Marzo 2015
	// CLF - Bremer - 2015
	public String muestraPantallaPagoimpuestos() {		
		// integrPagoModelo.setCuenta("U-224488");
		// integrPagoModelo.setNombre("CARLOS MARTIN LUNA FERNANDEZ DE JAUREGUI");
		// integrPagoModelo.setDomicilio("EGUIARE Y EGUREN 63, INTERIOR 7, COL. VIADUCTO PIEDAD. MEXICO DF");
		// integrPagoModelo.setCveDefTramite("285");
		// integrPagoModelo.setSelctdLocalidad("S");
		// integrPagoModelo.setDescrLocalidad("CIUDAD SAHAGUN");
		try {
			ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
			
			System.out.println("URL: " + constantes.PG_SRVT_BNRTE + "?nombreTH=" + integrPagoModelo.getNombre() + "&direccionTH=" + integrPagoModelo.getDomicilio() + "&ciudadTH=" + integrPagoModelo.getSelctdLocalidad() + "&numCuenta=" + integrPagoModelo.getCuenta() + "&tipoPago=" + integrPagoModelo.getCveDefTramite());
			externalContext.redirect(constantes.PG_SRVT_BNRTE + "?nombreTH=" + integrPagoModelo.getNombre() + "&direccionTH=" + integrPagoModelo.getDomicilio() + "&ciudadTH=" + integrPagoModelo.getSelctdLocalidad() + "&numCuenta=" + integrPagoModelo.getCuenta() + "&tipoPago=" + integrPagoModelo.getCveDefTramite());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}	
	
}
