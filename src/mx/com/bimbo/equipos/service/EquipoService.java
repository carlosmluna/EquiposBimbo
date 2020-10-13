package mx.com.bimbo.equipos.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.springframework.expression.spel.ast.TypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;

// import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import mx.com.bimbo.equipos.modelo.EquipoBusquedaModelo;
import mx.com.bimbo.equipos.modelo.EquipoModelo;
import mx.com.bimbo.equipos.modelo.dto.EquipoDTO;
import mx.com.bimbo.equipos.util.Constantes;
import mx.com.bimbo.equipos.util.Utilidades;

public class EquipoService {
	Constantes constantes = new Constantes();

	public EquipoDTO actualziarEquipoMSServivio( EquipoModelo equipoModelo, String suaurio ) {		
		System.out.println("Service {} - Se realiza la Actiualizacion del Registro 'Equipo' en la Base de datos Mediante WS-Rest");
		EquipoDTO  equipo = new EquipoDTO();
		Utilidades utils  = new Utilidades();
		String jsonEquipo       = "";
		
		try {
			String uriUpdateEquipo = "http://" + constantes.IP_APLICAION + ":8060/equipos/equipos-actualizar-admin" + 
					"?id=" 		+ String.valueOf( equipoModelo.getId() )                            +
					"&est=" 	+ equipoModelo.getEst()   	+ 
					"&reg=" 	+ equipoModelo.getReg()    	+	  
					"&loc=" 	+ equipoModelo.getLoc()  	+ 
					"&bodg=" 	+ equipoModelo.getBod()    	+ 
					"&razon=" 	+ equipoModelo.getRaz()  	+ 
					"&empl=" 	+ utils.colocaCarcterEspacioURL( equipoModelo.getEmpleado()  ) 		+ 
					"&serie1="  + utils.colocaCarcterEspacioURL( equipoModelo.getSerie_cambio() )	+
					"&nomb1="   + utils.colocaCarcterEspacioURL( equipoModelo.getNombre_cambio() )  +	 
					"&est1="    + utils.colocaCarcterEspacioURL( equipoModelo.getEstatus_cambio() ) + 
					"&marca="   + utils.colocaCarcterEspacioURL( equipoModelo.getMarca() )          +
					"&modelo="  + utils.colocaCarcterEspacioURL( equipoModelo.getModelo() )         + 
					"&nomb2=" 	+ utils.colocaCarcterEspacioURL( equipoModelo.getNombre_nuevo() )   + 
					"&serie2=" 	+ utils.colocaCarcterEspacioURL( equipoModelo.getSerie_nuevo() )    + 
					"&model2=" 	+ utils.colocaCarcterEspacioURL( equipoModelo.getModelo_nuevo() )   +
					"&orden=" 	+ utils.colocaCarcterEspacioURL( equipoModelo.getOrden() )          + 
					"&accn=" 	+ equipoModelo.getAcc()		+ 
					"&fProg=" 	+ utils.colocaCarcterEspacioURL( equipoModelo.getProgramado() )	    + 
					"&prov=" 	+ utils.colocaCarcterEspacioURL( equipoModelo.getProveedor() )	    +
					"&comm=" 	+ utils.colocaCarcterEspacioURL( equipoModelo.getComentarios() )	+ 
					"&arch=" 	+ utils.colocaCarcterEspacioURL( equipoModelo.getArchivo() )        + 
					"&garant=" 	+ utils.colocaCarcterEspacioURL( equipoModelo.getGarantia() )	    + 
					"&so=" 		+ utils.colocaCarcterEspacioURL( equipoModelo.getSistema() )        +
					// Campos Nuevos
					"&serie3="  + utils.colocaCarcterEspacioURL( equipoModelo.getSistema() )        	+ 
					"&alta="    + utils.colocaCarcterEspacioURL( equipoModelo.getAlta() ) 				+ 
					"&estCtl="  + utils.colocaCarcterEspacioURL( equipoModelo.getEstatus_control() ) + 
					"&nomb3="   + utils.colocaCarcterEspacioURL( equipoModelo.getNombre_recambio() )  + 
					// Campos del Usaurio que modifica
					"&usr="		+ suaurio			+ 
					"&id="      + equipoModelo.getId();
			
			// uriUpdateEquipo = "http://localhost:8060/equipos/equipos-actualizar?id=5&est=3&reg=6&loc=1&bodg=7&razon=13&empl=1232164&serie1=MXL225085S&nomb1=Juan%20Carlos%20Andres%20Fierro%20Ortiz&est1=Missing&marca=Hewlett-Packard&modelo=8200%20ELITE&nomb2=CARLOS%20LUNA%20FERNANDEZ&serie2=7654321&model2=DELL%20VOSTRO%20123&orden=4499001&accn=2&fProg=05-ENE-2020&prov=LBG&comm=Equipo%20sale%20del%20proyecto%20ya%20que%20esta%20en%20Missng&arch=ArchivoPrueba.txt&garant=31-ENE-2023&so=Windos%207%20Professional%20Edition&usr=CLUNA";
			System.out.println("uriUpdateEquipo: " + uriUpdateEquipo);
			
            URL url = new URL( uriUpdateEquipo );	//your url i.e fetch data from .
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP Error code : " + conn.getResponseCode());
            }
            
            InputStreamReader in = new InputStreamReader(conn.getInputStream());
            BufferedReader br = new BufferedReader(in);  
            String output;
            while ((output = br.readLine()) != null) {
                System.out.println(output);
                jsonEquipo = output;
            }
            conn.disconnect();
            
            equipo = utils.convierteJsonToObject_Equipo( jsonEquipo );            
        } catch (Exception e) {
            System.out.println("Exception in NetClientGet GET - Actualizar Registro del Equipo: - " + e);
        }
		return equipo;
	}
	
	public List<EquipoDTO> buscarEquiposPorDTOMSSericio( EquipoBusquedaModelo equipoModelo ) {		
		System.out.println("Service {} - Se realiza la consulta de un 'Equipos-DTO' en la Base de datos Mediante WS-Rest");
		List<EquipoDTO> equipos = new ArrayList<EquipoDTO>();
		EquipoDTO equipoDTO    = null;
		String jsonEquipo      = "";
		String fchProgramacion = equipoModelo.getProgramacion()!=null ? equipoModelo.getProgramacion() : "";
		
		
		try {
			String uriSelectEquipo = "http://" + constantes.IP_APLICAION + ":8060/equipos/equipos-buscardto" + 
					"?estatus=" 	+ equipoModelo.getEstatus() 		+ 
					"&region=" 		+ equipoModelo.getRegion()  		+  
					"&local=" 		+ equipoModelo.getLocalidad()  		+ 
					"&bodega=" 		+ equipoModelo.getBodega()  		+ 
					"&razon=" 		+ equipoModelo.getRazonSocial()  	+ 
					"&model2=" 		+ equipoModelo.getModelo()   		+ 
					"&accion="   	+ equipoModelo.getAccion() 			+
					"&fProgram="	+ fchProgramacion  					+		 
					"&proveed="    	+ equipoModelo.getProveedor()		+
					"&id="    		+ equipoModelo.getId();
			System.out.println("uriUpdateEquipo: " + uriSelectEquipo);
			
            URL url = new URL( uriSelectEquipo );		//your url i.e fetch data from .
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP Error code : " + conn.getResponseCode());
            }
            
            InputStreamReader in = new InputStreamReader(conn.getInputStream());
            BufferedReader    br = new BufferedReader(in);  
            String output;
            while ((output = br.readLine()) != null) {
                System.out.println(output);
                jsonEquipo = output;
            }
            conn.disconnect();
            
            JsonParser parser = new JsonParser();
            JsonArray gsonArr = parser.parse(jsonEquipo).getAsJsonArray();
            for (JsonElement obj : gsonArr) {
            	EquipoDTO equipojsnDTO = new EquipoDTO();
            	JsonObject   gsonObj   = obj.getAsJsonObject();
            	
            	equipojsnDTO.setId( gsonObj.get("id").getAsInt() );
            	equipojsnDTO.setEstatus( gsonObj.get("estatus").getAsString() );
            	equipojsnDTO.setRegion( gsonObj.get("region").getAsString() );
            	equipojsnDTO.setLocalidad( gsonObj.get("localidad").getAsString() );
            	equipojsnDTO.setBodega( gsonObj.get("bodega").getAsString() );
            	equipojsnDTO.setRazon( gsonObj.get("razon").getAsString() );
            	equipojsnDTO.setEmpleado( gsonObj.get("empleado").getAsString() ); 
            	equipojsnDTO.setSerie_cambio( gsonObj.get("serie_cambio").getAsString() );
            	equipojsnDTO.setNombre_cambio( gsonObj.get("nombre_cambio").getAsString() );
            	equipojsnDTO.setEstatus_cambio( gsonObj.get("estatus_cambio").getAsString() );
            	equipojsnDTO.setMarca( gsonObj.get("marca").getAsString() );
            	equipojsnDTO.setModelo( gsonObj.get("modelo").getAsString() ); 
            	equipojsnDTO.setNombre_nuevo( gsonObj.get("serie_cambio").getAsString() ); 
            	equipojsnDTO.setSerie_nuevo( gsonObj.get("serie_nuevo").getAsString() ); 
            	equipojsnDTO.setModelo_nuevo( gsonObj.get("modelo_nuevo").getAsString() );   
            	equipojsnDTO.setOrden( gsonObj.get("orden").getAsString() );
            	equipojsnDTO.setAccion( gsonObj.get("accion").getAsString() );   
            	equipojsnDTO.setProgramado( gsonObj.get("programado").getAsString() );   
            	equipojsnDTO.setProveedor( gsonObj.get("proveedor").getAsString() );     
            	equipojsnDTO.setComentarios( gsonObj.get("comentarios").getAsString() );    
            	equipojsnDTO.setArchivo( gsonObj.get("archivo").getAsString() );
            	equipojsnDTO.setGarantia("");
            	equipojsnDTO.setSistema("");
            	            	
            	equipos.add(equipojsnDTO);
            }
        } catch (Exception e) {
            System.out.println("Exception in NetClientGet GET - Buscar Usuario: - " + e);
        }
		return equipos;
	}
	
	public EquipoDTO buscarRegistroEquipoMSSericio( int id ) {
		System.out.println("Service {} - Se realiza la consulta del Registro 'Equipo' en la Base de datos Mediante WS-Rest");
		EquipoDTO  equipo = new EquipoDTO();
		Utilidades utils  = new Utilidades();
		String jsonEquipo       = "";
		
		try {
			String uriRegEquipo = "http://" + constantes.IP_APLICAION + ":8060/equipos/equipos-consultarPorId/" + id;
			System.out.println("uriUpdateEquipo: " + uriRegEquipo);
			
            URL url = new URL( uriRegEquipo );	//your url i.e fetch data from .
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP Error code : " + conn.getResponseCode());
            }
            
            InputStreamReader in = new InputStreamReader(conn.getInputStream());
            BufferedReader br = new BufferedReader(in);  
            String output;
            while ((output = br.readLine()) != null) {
                System.out.println(output);
                jsonEquipo = output;
            }
            conn.disconnect();
            
            equipo = utils.convierteJsonToObject_Equipo( jsonEquipo );            
        } catch (Exception e) {
            System.out.println("Exception in NetClientGet GET - Buscar Localidades: - " + e);
        }
		return equipo;
	}

}
