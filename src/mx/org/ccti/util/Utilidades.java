package mx.org.ccti.util;

import java.text.DecimalFormat;

import mx.org.ccti.modelo.Mensaje;
import mx.org.ccti.util.Constantes;

public class Utilidades {

	public Mensaje valVerificaCapturaTextoUrl ( String psValorTxt ) {				
		// Declaro variables		
		Constantes constantes  = new Constantes();
		Mensaje    mensaje     = new Mensaje();
		
		// Valido el valor pasado a la funcion
		if ( psValorTxt != null && !psValorTxt.trim().equals("") ) {
			mensaje.setCodigo(constantes.COD_EXITO);
			mensaje.setDescripcion(constantes.DESC_EXITO);
		} else {
			mensaje.setCodigo(constantes.COD_ERROR);
			mensaje.setDescripcion(constantes.DESC_ERROR);			
		}		
		
		return mensaje;
	}
	
	
	public Mensaje valVerificaSeleccionCombo ( String psValorCombo ) {				
		// Declaro variables
		Constantes constantes  = new Constantes();
		Mensaje    mensaje     = new Mensaje();
		String     codigo      = "";
		String     descripcion = "";
		
		// Valido el valor pasado a la funcion
		if ( psValorCombo != null && !psValorCombo.equals("0") ) {
			mensaje.setCodigo(constantes.COD_EXITO);
			mensaje.setDescripcion(constantes.DESC_EXITO);
		} else {
			mensaje.setCodigo(constantes.COD_ERRLOCALD);
			mensaje.setDescripcion(constantes.DESC_ERRLOCALD);
		}
		
		return mensaje;
	}
	
	
	public String formatearSepararMiles( String valor ) {		
		DecimalFormat formateador = new DecimalFormat("###,###.##");
		String valorRet = formateador.format(Long.parseLong(valor));
		
		if (!valorRet.contains(".")) {
			valorRet = valorRet + ".00";
		}
		return valorRet; 	
	}
}
