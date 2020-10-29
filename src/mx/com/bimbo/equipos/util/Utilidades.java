package mx.com.bimbo.equipos.util;

import mx.com.bimbo.equipos.modelo.dto.CatalogoDTO;
import mx.com.bimbo.equipos.modelo.dto.EquipoDTO;

public class Utilidades {

	public String colocaCarcterEspacioURL( String valor ) {
		String strReturnValor = "";
		if (valor!=null) {
			strReturnValor = valor.replace(" ", "%20");
			
			if ( valor.trim().equals("#N/D") ) {
				strReturnValor = ""; 
			}
		}		
		return strReturnValor;
	}
	
	public EquipoDTO convierteJsonToObject_Equipo( String jsonRequest ) {
		EquipoDTO equipo = new EquipoDTO();
		
		jsonRequest = jsonRequest.replace("null", " ");
		String strJsonTmp = jsonRequest.substring(1, jsonRequest.length()-1);
		System.out.println(strJsonTmp);
		
		String[] arrEquipo = strJsonTmp.split(",");		
		for (int indice1=0; indice1<arrEquipo.length; indice1++) {
			String lineaEquipo = arrEquipo[indice1];
			
			String[] arrLinea = lineaEquipo.split(":");
			for (int indice2=0; indice2<arrLinea.length; indice2++) {
				String lineaItem = arrLinea[indice2] !=null ?  arrLinea[indice2] : "";
				System.out.println("Linea Item: " + lineaItem);
				
				switch ( indice1 ) {	// Valido el campo a evaluar
				case 0:		// Id
					equipo.setId( Integer.valueOf( arrLinea[1] ) );					
					break;
				case 1:		// Estatus
					equipo.setEstatus( arrLinea[1].substring(1, arrLinea[1].length()-1) );					
					break;
				case 2:		// Region
					equipo.setRegion( arrLinea[1].substring(1, arrLinea[1].length()-1) );					
					break;
				case 3:		// Localidad
					equipo.setLocalidad( arrLinea[1].substring(1, arrLinea[1].length()-1) );					
					break;
				case 4:		// Bodega
					equipo.setBodega( arrLinea[1].substring(1, arrLinea[1].length()-1) );					
					break;
				case 5:		// Razon
					equipo.setRazon( arrLinea[1].substring(1, arrLinea[1].length()-1) );					
					break;
				// ************************************************************************************	
				// Informacion del Equipo que se v a reemplazar
				// ************************************************************************************
				case 6:		// Id Empleado
					equipo.setEmpleado( arrLinea[1].substring(1, arrLinea[1].length()-1) );					
					break;
				case 7:		// nombre_cambio
					equipo.setNombre_cambio( arrLinea[1].substring(1, arrLinea[1].length()-1) );		
					break;
				case 8:		// serie_cambio
					equipo.setSerie_cambio( arrLinea[1].substring(1, arrLinea[1].length()-1) );					
					break;	
				case 9:		// estatus_cambio
					equipo.setEstatus_cambio( arrLinea[1].substring(1, arrLinea[1].length()-1) );					
					break;
				case 10:	// marca
					equipo.setMarca( arrLinea[1].substring(1, arrLinea[1].length()-1) );					
					break;
				case 11:	// modelo
					equipo.setModelo( arrLinea[1].substring(1, arrLinea[1].length()-1) );					
					break;
				// ************************************************************************************
				// Informacion del Equipo Nuevo
				// ************************************************************************************
				case 12:	// nombre Nuevo
					equipo.setNombre_nuevo( arrLinea[1].substring(1, arrLinea[1].length()-1) );					
					break;
				case 13:	// serie nuevo
					equipo.setSerie_nuevo( arrLinea[1].substring(1, arrLinea[1].length()-1) );					
					break;
				case 14:	// fecha alta
					equipo.setAlta( arrLinea[1].substring(1, arrLinea[1].length()-1) );					
					break;						
				case 15:	// modelo nuevo
					equipo.setModelo_nuevo( arrLinea[1].substring(1, arrLinea[1].length()-1) );					
					break;
				case 16:	// garantia
					equipo.setGarantia( arrLinea[1].substring(1, arrLinea[1].length()-1) );					
					break;
				case 17:	// sistema
					equipo.setSistema( arrLinea[1].substring(1, arrLinea[1].length()-1) );					
					break;						
				case 18:	// orden
					equipo.setOrden( arrLinea[1].substring(1, arrLinea[1].length()-1) );					
					break;
				case 19:	// Comentarios
					equipo.setComentarios( arrLinea[1].substring(1, arrLinea[1].length()-1) );					
					break;	
				case 20:	// Fecha Programacion
					equipo.setProgramado( arrLinea[1].substring(1, arrLinea[1].length()-1) );					
					break;	
				case 21:	// proveedor
					equipo.setProveedor( arrLinea[1].substring(1, arrLinea[1].length()-1) );					
					break;
				case 22:	// archivo
					equipo.setEstatus_control( arrLinea[1].substring(1, arrLinea[1].length()-1) );					
					break;					
				case 23:	// Accion
					equipo.setAccion( arrLinea[1].substring(1, arrLinea[1].length()-1) );					
					break;
				// ************************************************************************************
				// IDS
				// ************************************************************************************					
				// Campos de ids de los Catalogos o combos de pantalla
				case 24:	// id estatus
					equipo.setEst( Integer.valueOf( arrLinea[1] ) );					
					break;
				case 25:	// id region
					equipo.setReg( Integer.valueOf( arrLinea[1] ) );					
					break;
				case 26:	// id_localidad
					equipo.setLoc( Integer.valueOf( arrLinea[1] ) );					
					break;
				case 27:	// id bodega
					equipo.setBod( Integer.valueOf( arrLinea[1] ) );					
					break;
				case 28:	// id_razon
					equipo.setRaz( Integer.valueOf( arrLinea[1] ) );					
					break;
				case 29:	// id_accion
					equipo.setAcc( Integer.valueOf( arrLinea[1] ) );					
					break;
				case 30:	// id_Estatus Control
					equipo.setCtrl( Integer.valueOf( arrLinea[1] ) );					
					break;	
				// ************************************************************************************
				// Modificacion del Registro
				// ************************************************************************************	
				case 31:	// fecha alta
					equipo.setUsuario_modifica( arrLinea[1].substring(1, arrLinea[1].length()-1) );					
					break;
				case 32:	// estatus_control
					equipo.setFecha_modifica( arrLinea[1].substring(1, arrLinea[1].length()-1) );					
					break;
				/* case 31:	// nombre_recambio
					equipo.setNombre_recambio( arrLinea[1].substring(1, arrLinea[1].length()-1) );					
					break;
				case 32:	// serie_renombre
					equipo.setSerie_renombre( arrLinea[1].substring(1, arrLinea[1].length()-1) );					
					break; */
				default:
					break;
				}
			}
		}
		System.out.println( equipo.toString() );
		return equipo;
	}
	
	public CatalogoDTO convierteJsonToObject_Catalogo( String jsonRequest ) {
		CatalogoDTO catalogoReg = new CatalogoDTO();
		
		jsonRequest = jsonRequest.replace("null", " ");
		String strJsonTmp = jsonRequest.substring(1, jsonRequest.length()-1);
		System.out.println(strJsonTmp);
		
		String[] arrEquipo = strJsonTmp.split(",");		
		for (int indice1=0; indice1<arrEquipo.length; indice1++) {
			String lineaEquipo = arrEquipo[indice1];
			
			String[] arrLinea = lineaEquipo.split(":");
			for (int indice2=0; indice2<arrLinea.length; indice2++) {
				String lineaItem = arrLinea[indice2] !=null ?  arrLinea[indice2] : "";
				System.out.println("Linea Item: " + lineaItem);
				
				switch ( indice1 ) {	
				case 0:		// Id
					catalogoReg.setId( Integer.valueOf( arrLinea[1] ) );					
					break;
				case 1:	
					catalogoReg.setDescripcion( arrLinea[1].substring(1, arrLinea[1].length()-1) );					
					break;
				}
			}
		}
		
		return catalogoReg;
	}
}
