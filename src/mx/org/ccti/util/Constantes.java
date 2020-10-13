package mx.org.ccti.util;

public class Constantes {

	public static final String TRM_PREDIAL = "285";				// Tramites para agua y predial
	public static final String TRM_AGUA    = "286";
	
	public static final String CHAR_VACIO = "";      			// Caracter vacio
	public static final String CHAR_PESOS   = "$";				// Caracter Pesos
	
	public static final String COD_EXITO      = "0000";  		// Operacion Exitosa
	public static final String COD_ERROR      = "1111";  		// Operacion No Exitosa
	public static final String COD_ERRDEFPGO  = "1001";			// Cve Definicion Pago vacia
	public static final String COD_ERRCUENTA  = "1002";			// No. Cuenta vacia
	public static final String COD_ERRLOCALD  = "1003";			// Localidad vacia
	public static final String COD_ERRNOMBRE  = "1004";			// Nombre vacia
	public static final String COD_ERRCLSNFND = "2001";			// Valor no verificado
	public static final String COD_ERRLGRAL   = "9999";			// Valor no verificado
		
	public static final String DESC_EXITO      = "Operacion Exitosa";	
	public static final String DESC_ERROR      = "Operacion No Exitosa";
	public static final String DESC_ERRDEFPGO  = "La Clave de Definicion de Pago no se encuentra";
	public static final String DESC_ERRCUENTA  = "Por favor capture el número de cuenta";
	public static final String DESC_ERRLOCALD  = "Por favor seleccione la Localidad";
	public static final String DESC_ERRNOMBRE  = "Debe ingresar por lo menos algun nombre o apellido del cuentahabiente";
	public static final String DESC_ERRCLSNFND = "Ocurrio un problema al buscar referencias";	
	public static final String DESC_ERRVLGRAL  = "Este valor no esta verificado";
	public static final String DESC_ERRBANRTE  = "No se puede realizar el pago sin algun dato de la pantalla";   // CLF - Brtec - 19Mar15
	
	// Localidades
	public static final String LOC_SAHAGUN     = "CIUDAD SAHAGUN";
	public static final String LOC_TEPEAPLCO   = "TEPEAPULCO";
	
	// Paginas
	public static final String PG_CONFIRM     = "ConfirmIntegracionPago";	
	public static final String PG_INTEGPGO    = "IntegracionPago";
	// public static final String PG_SRVT_BNRTE  = "http://192.168.2.109:8080/PagoElectronico/PostPagoElectronico.jsp";
	public static final String PG_SRVT_BNRTE = "http://192.168.2.109:8080/PagoElectronico/PagoElectronicoTmp.jsp";
		
	// Etiquetas
	public static final String LBL_AGUA       = "Solo Números";
	public static final String LBL_PREDIAL    = "Mayúsculas, Números y Guion medio";
}
