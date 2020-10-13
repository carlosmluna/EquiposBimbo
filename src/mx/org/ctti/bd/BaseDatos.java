package mx.org.ctti.bd;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import mx.org.ccti.modelo.*;
import mx.org.ccti.pdf.IntegrPagosPDF;
import mx.org.ccti.util.Constantes;
import mx.org.ccti.util.Utilidades;

public class BaseDatos {
	Utilidades utilidades = new Utilidades();
	
	static final String JDBC_DRIVER = "org.postgresql.Driver";  
	static final String DB_URL = "jdbc:postgresql://192.168.1.61:5432/Tepea_EXP";
	static final String USER = "webuser";
	static final String PASS = "baron";
			   
	// Consulta la BD para tomar la informacion al reporte pdf
	/* 
	Codigos de error:
		* 00 - Operacion Exitosa				
		* 01 - No se encontraron registros de Integracion de Pago
		* 02 - No se encontraron registros XML	
		* 10 - Excepcion al abrir el archivo PDF
		* 100 - Clase No encontrada
		* 101 - Excepcion SQL al consultar
		* 102 - Excepcion General
		* 110 - Excepcion SQL al cerrar conexion
	*/	
	public String conultaInformacionLlenadoPDF( IntegrPagoModelo integrPagoModelo ) {
		List<CampoBO> listaCampos = new ArrayList<CampoBO>();
		
		Connection conn = null;
		Statement  stmt = null;
		String     sqlIntPagos  = "";
		String     sqlDefTram   = "";
		String     clave        = "";
		String     codError     = "Operacion Exitosa";
		int numRegisIntegReg = 0;
		int indDefTramite = 0;
        int numRegisDefTramite = 0;	 
		
		try {
			Class.forName(JDBC_DRIVER);		
			System.out.println("Connecting to database...");
		    conn = DriverManager.getConnection(DB_URL,USER,PASS);
		    	    
		    // Obtengo la informacion de la tabla 'integracion_pagos'
		    stmt = conn.createStatement();		    
		    sqlIntPagos = "SELECT cuenta, nombre_razon_social, domicilio, rfc, concepto, cuota_anual, rezagos, "; 
		    sqlIntPagos = sqlIntPagos + "recargos, iva, derechos_sda, subtotal, descuento, importe_neto, "; 
		    sqlIntPagos = sqlIntPagos + "linea_captura1, linea_captura2, linea_captura4, linea_captura3, fecha_vencimineto "; 
		    sqlIntPagos = sqlIntPagos + "FROM integracion_pagos "; 
		    sqlIntPagos = sqlIntPagos + "WHERE cuenta = '" + integrPagoModelo.getCuenta() + "' and localidad = '" + integrPagoModelo.getSelctdLocalidad() + "' ";
		    sqlIntPagos = sqlIntPagos + "and translate(Upper(nombre_razon_social),'¡…Õ”⁄ƒÀœ÷‹','AEIOUAEIOU') like '%" + integrPagoModelo.getNombBusq() + "%'";
		    System.out.println("SQL: " + sqlIntPagos);
		    ResultSet rsIntPago = stmt.executeQuery(sqlIntPagos);
		    
		    // Barro el resulset de Integracion de pagos		    
		    while(rsIntPago.next()) {
		    	numRegisIntegReg ++;
		    	
			   	for (int indIntPago=1; indIntPago<=18; indIntPago++) {
			   		CampoBO campo = new CampoBO();
			   		
			   		campo.setValor(rsIntPago.getString(indIntPago));
			   		campo.setXmlCampo("");
			    	listaCampos.add(campo);
			    	
			    	if (indIntPago == 5) { clave = rsIntPago.getString(indIntPago); }   // Obtengo la clave de la referencia del pago
			   	}	    	
			}	
		    
		    
	    	// Obtengo la informacion de la tabla 'pscampodefiniciontramite'
		    if (numRegisIntegReg > 0) {
		    	sqlDefTram = "SELECT cam_xml FROM pscampodefiniciontramite WHERE cod_def_tramite = " + integrPagoModelo.getCveDefTramite() + " ORDER BY orden ";  // ****
		        ResultSet rsDefTramite = stmt.executeQuery(sqlDefTram);
				    
		        // Barro el resulset de Integracion de pagos
		        while(rsDefTramite.next()) {		        	
			    	listaCampos.get(indDefTramite).setXmlCampo(rsDefTramite.getString("cam_xml"));
			    	numRegisDefTramite ++;
			    	indDefTramite++; }  // While
				
		        if (numRegisDefTramite > 0) {
		        	Collections.sort(listaCampos);
				    
		        	integrPagoModelo = null;	// limpio la referencia la objeto
		        	
					IntegrPagosPDF integrPagoPDF = new IntegrPagosPDF();	// Coloco los datos en la plantilla excel y genero el reporte PDF.
					String urlReporte = integrPagoPDF.llenaPlantilla(listaCampos, clave);
															
					IntegrPagosPDF integPDF = new IntegrPagosPDF(); 		// Abro el PDF con la url que regreso
					integPDF.visualizaArchivoPDF(urlReporte, integrPagoModelo);										
		        } else { codError = "No existen registros en archivo XML"; }
						        		        			    
			    rsDefTramite.close();   // Cierro las referencias
		    } else { codError = "No existen Registros de Integracion de Pago"; }
	           	 		    	
	    		 
		    // Cierro las referencias
		    rsIntPago.close();		    
		    stmt.close();
		    conn.close();
		} catch (ClassNotFoundException e) {
			codError = "Ocurrio un problema al buscar referencias";
			e.printStackTrace();
		} catch (SQLException e) {
			codError = "Ocurrio un problema SQL al consultar";
			e.printStackTrace();
		} catch(Exception e){
			codError = "Ocurrio un problema al generar el Formato PDF";
		    e.printStackTrace();
		} finally { // Se cierra la conexiÛn con la base de datos.
            try {
                if (conn != null) { conn.close(); }
            } catch (SQLException ex) {
            	codError = "Ocurrio un problema 'SQL' al cerrar la conexiÚn";
                System.out.println(ex.getMessage()); }
        } // Finnaly
		
		return codError; 
		
	} // conexionbasedatos
	
	// Consulta la BD para tomar la informacion del ciudadano
		/* 
		Codigos de error:
			* 00 - Operacion Exitosa				
			* 01 - No se encontraron registros de Integracion de Pago
			* 02 - No se encontraron registros XML	
			* 10 - Excepcion al abrir el archivo PDF
			* 100 - Clase No encontrada
			* 101 - Excepcion SQL al consultar
			* 102 - Excepcion General
			* 110 - Excepcion SQL al cerrar conexion
		*/	
	public Mensaje consultaCiudadanoIntegrPago( IntegrPagoModelo integrPagoModelo ) {
		Mensaje    mensaje = new Mensaje();
		Constantes constantes = new Constantes();
		Connection conn = null;
		Statement  stmt = null;
		String     sqlCiudadano  = "";
		int        numRegistross = 0;
		
		mensaje.setCodigo(constantes.COD_EXITO);
		mensaje.setDescripcion(constantes.DESC_EXITO);
		
		try {
			Class.forName(JDBC_DRIVER);		
			System.out.println("Connecting to database 'consultaCiudadanoIntegrPago'...");
		    conn = DriverManager.getConnection(DB_URL,USER,PASS);
		    
		    // Obtengo la informacion de la tabla 'integracion_pagos'
		    stmt = conn.createStatement();		    
		    sqlCiudadano = "SELECT nombre_razon_social, domicilio, subtotal FROM integracion_pagos WHERE cuenta = '" + integrPagoModelo.getCuenta() + "'"
		    		+ " and localidad = '" + integrPagoModelo.getSelctdLocalidad() + "'"
		    		+ " and translate(Upper(nombre_razon_social),'¡…Õ”⁄ƒÀœ÷‹','AEIOUAEIOU') like '%"+ integrPagoModelo.getNombBusq() + "%'";  
		    ResultSet rsCiudadano = stmt.executeQuery(sqlCiudadano);		    
		    while(rsCiudadano.next()) {		// Barro el resulset de Integracion de pagos
		    	numRegistross++;
		    	integrPagoModelo.setNombre(rsCiudadano.getString("nombre_razon_social"));
		    	integrPagoModelo.setDomicilio(rsCiudadano.getString("domicilio"));
		    	
		    	if (integrPagoModelo.getSelctdLocalidad().equals("S")) {
		    		integrPagoModelo.setDescrLocalidad(constantes.LOC_SAHAGUN); }
		    	else {
		    		integrPagoModelo.setDescrLocalidad(constantes.LOC_TEPEAPLCO); }		
		    	
		    	// Asigno el monto a pagar al modelo / CLF / Marzo 15
		    	String monto = "";
		    	if ( rsCiudadano.getString("subtotal").equals("") ) {
		    		monto = "0"; }
		    	else {
		    		monto = rsCiudadano.getString("subtotal"); }
		    	integrPagoModelo.setSubtotal(constantes.CHAR_PESOS + " " + utilidades.formatearSepararMiles(monto));  // Fin - Asignar Monto
		    }
		    
		    if ( numRegistross == 0 ) {
		    	mensaje.setCodigo("1001");
				mensaje.setDescripcion("No se encontraron Registros asociados a esta cuenta"); } // End-If
		    
		    // Cierro las referencias
		    rsCiudadano.close();		    
		    stmt.close();
		    conn.close();
		} catch (ClassNotFoundException e) {
			mensaje.setCodigo(constantes.COD_ERRCLSNFND);
			mensaje.setDescripcion(constantes.DESC_ERRCLSNFND);
			e.printStackTrace();
		} catch (SQLException e) {
			mensaje.setCodigo(constantes.COD_ERRCLSNFND);
			mensaje.setDescripcion("Ocurrio un problema SQL al consultar");			
			e.printStackTrace();
		} catch(Exception e){
			mensaje.setCodigo(constantes.COD_ERRCLSNFND);
			mensaje.setDescripcion("Ocurrio un problema al generar el Formato PDF");	
		    e.printStackTrace();
		} finally { // Se cierra la conexiÛn con la base de datos.
            try {
                if (conn != null) { conn.close(); }
            } catch (SQLException ex) {
            	mensaje.setCodigo(constantes.COD_ERRCLSNFND);
    			mensaje.setDescripcion("Ocurrio un problema 'SQL' al cerrar la conexiÚn");	
                System.out.println(ex.getMessage()); }
        } // Finnaly    
		return mensaje;
	} 
	

}
