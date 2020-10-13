package mx.com.bimbo.equipos.util;

public class TestJson {

	public static void main(String[] args) {
		String jsonRequest = "{\"id\":5,\"estatus\":\"3\",\"region\":\"6\",\"localidad\":\"1\",\"bodega\":\"7\",\"razon\":\"13\",\"empleado\":\"1232164\",\"serie_cambio\":\"MXL225085S\",\"nombre_cambio\":\"Juan Carlos Andres Fierro Ortiz\",\"estatus_cambio\":\"Missing\",\"marca\":\"Hewlett-Packard\",\"modelo\":\"8200 ELITE\",\"nombre_nuevo\":\"CARLOS LUNA FERNANDEZ\",\"serie_nuevo\":\"7654321\",\"modelo_nuevo\":\"DELL VOSTRO 123\",\"orden\":\"4499001\",\"accion\":\"2\",\"programado\":\"05-ENE-2020\",\"proveedor\":\"LBG\",\"comentarios\":\"Equipo sale del proyecto ya que esta en Missng\",\"archivo\":\"ArchivoPrueba.txt\",\"garantia\":null,\"sistema\":\"Windos 7 Professional Edition\"}";
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
				
				if ( indice1 == 1 ) {	// Estatus
					if ( indice2 == 1 ) {
						String estatus = arrLinea[1].substring(1, arrLinea[1].length()-1);
						System.out.println("Estatus: " + estatus);
					}
				}
			}
		}
	}

}
