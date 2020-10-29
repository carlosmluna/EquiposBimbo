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

import com.google.gson.Gson;
// import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import mx.com.bimbo.equipos.modelo.EquipoBusquedaModelo;
import mx.com.bimbo.equipos.modelo.EquipoModelo;
import mx.com.bimbo.equipos.modelo.dto.EquipoDTO;
import mx.com.bimbo.equipos.modelo.dto.UsuarioDTO;
import mx.com.bimbo.equipos.util.Constantes;
import mx.com.bimbo.equipos.util.Utilidades;

public class EquipoService {
	Constantes constantes = new Constantes();

	public EquipoDTO actualziarEquipo( EquipoModelo equipoModelo, String suaurio ) {		
		System.out.println("Service {} - Se realiza la Actiualizacion del Registro 'Equipo' en la Base de datos Mediante WS-Rest");
		EquipoDTO  equipo = new EquipoDTO();
		Utilidades utils  = new Utilidades();
		String jsonEquipo       = "";
		String uriUpdateEquipo = "";
		
		try {
			uriUpdateEquipo = "http://" + constantes.IP_APLICAION + constantes.EQP_CONTEXT + "/equipos/equipos-actualizar-admin" + 
			// uriUpdateEquipo = "http://localhost:8060/equipos/equipos-actualizar-admin" +
					"?id=" 		+ String.valueOf( equipoModelo.getId() )                            +
					"&est=" 	+ equipoModelo.getEst()   	+ 
					"&reg=" 	+ equipoModelo.getReg()    	+	  
					"&loc=" 	+ equipoModelo.getLoc()  	+ 
					"&bodg=" 	+ equipoModelo.getBod()    	+ 
					"&razon=" 	+ equipoModelo.getRaz()  	+ 
					// Informacion del Equipo a Reemplazar
					"&empl=" 	+ utils.colocaCarcterEspacioURL( equipoModelo.getEmpleado()  ) 		+ 
					"&nomb1="   + utils.colocaCarcterEspacioURL( equipoModelo.getNombre_cambio() )  +	 
					"&serie1="  + utils.colocaCarcterEspacioURL( equipoModelo.getSerie_cambio() )	+					
					"&est1="    + utils.colocaCarcterEspacioURL( equipoModelo.getEstatus_cambio() ) + 
					"&marca="   + utils.colocaCarcterEspacioURL( equipoModelo.getMarca() )          +
					"&modelo="  + utils.colocaCarcterEspacioURL( equipoModelo.getModelo() )         + 
					// Informacion del Equipo Nuevo
					"&nomb2=" 	+ utils.colocaCarcterEspacioURL( equipoModelo.getNombre_nuevo() )   + 
					"&serie2=" 	+ utils.colocaCarcterEspacioURL( equipoModelo.getSerie_nuevo() )    + 
					"&alta="    + utils.colocaCarcterEspacioURL( equipoModelo.getAlta() ) 			+
					"&model2=" 	+ utils.colocaCarcterEspacioURL( equipoModelo.getModelo_nuevo() )   +
					"&garant=" 	+ utils.colocaCarcterEspacioURL( equipoModelo.getGarantia() )	    +
					"&so=" 		+ utils.colocaCarcterEspacioURL( equipoModelo.getSistema() )        +
					"&orden=" 	+ utils.colocaCarcterEspacioURL( equipoModelo.getOrden() )          + 
					"&comm=" 	+ utils.colocaCarcterEspacioURL( equipoModelo.getComentarios() )	+
					"&fProg=" 	+ utils.colocaCarcterEspacioURL( equipoModelo.getProgramado() )	    +
					"&prov=" 	+ utils.colocaCarcterEspacioURL( equipoModelo.getProveedor() )	    +
					// Informacion Adicional
					"&accn=" 	+ equipoModelo.getAcc()		+ 
					"&estCtl="  + utils.colocaCarcterEspacioURL( equipoModelo.getEstatus_control() ) +  
					// 26Oct2020 - Campos Nuevos
					"&mes="     + utils.colocaCarcterEspacioURL( equipoModelo.getMes_renovacion() )  + 
					"&tkt="     + utils.colocaCarcterEspacioURL( equipoModelo.getTicket() ) 		 + 
					"&comC="    + utils.colocaCarcterEspacioURL( equipoModelo.getComm_control() ) 	 + 
					"&usr="		+ suaurio;
			
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
            
            // equipo = utils.convierteJsonToObject_Equipo( jsonEquipo );  
            Gson gson = new Gson(); 
            equipo = gson.fromJson(jsonEquipo, EquipoDTO.class); 
            
        } catch (Exception e) {
            System.out.println("Exception in NetClientGet GET - actualziarEquipo del Equipo: - " + uriUpdateEquipo + " - " + e);
        }
		return equipo;
	}
	
	public List<EquipoDTO> buscarEquiposPorDTO( EquipoBusquedaModelo equipoModelo ) {		
		System.out.println("Service {} - Se realiza la consulta de un 'Equipos-DTO' en la Base de datos Mediante WS-Rest");
		List<EquipoDTO> equipos = new ArrayList<EquipoDTO>();
		EquipoDTO equipoDTO    = null;
		String jsonEquipo      = "";
		String uriSelectEquipo = "";
		
		String estatus         = equipoModelo.getEstatus()!=null ? equipoModelo.getEstatus() : "";
		String region 		   = equipoModelo.getRegion()!=null ? equipoModelo.getRegion() : "";
		String localidad 	   = equipoModelo.getLocalidad()!=null ? equipoModelo.getLocalidad() : "";
		String bodega 	  	   = equipoModelo.getBodega()!=null ? equipoModelo.getBodega() : "";
		String razonSoc 	   = equipoModelo.getRazonSocial()!=null ? equipoModelo.getRazonSocial() : "";
		String modelo 		   = equipoModelo.getModelo()!=null ? equipoModelo.getModelo() : "";
		String accion 		   = equipoModelo.getAccion()!=null ? equipoModelo.getAccion() : "";
		String fchProgramacion = equipoModelo.getProgramacion()!=null ? equipoModelo.getProgramacion() : "";
		String proveedor       = equipoModelo.getProveedor()!=null ? equipoModelo.getProveedor() : "";	
		String id              = equipoModelo.getId()!=null ? equipoModelo.getId() : "";
		// 26Oct2020 - Nuevo Filtro de busqueda
		String serieCambio     = equipoModelo.getSerie_cambio()!=null ? equipoModelo.getSerie_cambio() : "";
		
		try {
			uriSelectEquipo = "http://" + constantes.IP_APLICAION + constantes.EQP_CONTEXT + "/equipos/equipos-buscardto" + 
			// uriSelectEquipo = "http://localhost:8060/equipos/equipos-buscardto" + 
					"?estatus=" 	+ estatus 			+ 
					"&region=" 		+ region  			+  
					"&local=" 		+ localidad  		+ 
					"&bodega=" 		+ bodega  			+ 
					"&razon=" 		+ razonSoc  		+ 
					"&model2=" 		+ modelo   			+ 
					"&accion="   	+ accion 			+
					"&fProgram="	+ fchProgramacion	+		 
					"&proveed="    	+ proveedor			+
					"&serie1="      + serieCambio		+	// 26Oct2020 - Nuevo Filtro de busqueda
					"&id="    		+ id;
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
            	// Informacion del equipo a Reemplazar
            	equipojsnDTO.setEmpleado( gsonObj.get("empleado").getAsString() ); 
            	equipojsnDTO.setNombre_cambio( gsonObj.get("nombre_cambio").getAsString() );
            	equipojsnDTO.setSerie_cambio( gsonObj.get("serie_cambio").getAsString() );
            	equipojsnDTO.setEstatus_cambio( gsonObj.get("estatus_cambio").getAsString() );
            	equipojsnDTO.setMarca( gsonObj.get("marca").getAsString() );
            	equipojsnDTO.setModelo( gsonObj.get("modelo").getAsString() ); 
            	// Informacion del equipo Nuevo
            	equipojsnDTO.setNombre_nuevo( gsonObj.get("nombre_nuevo").getAsString() );  
            	equipojsnDTO.setSerie_nuevo( gsonObj.get("serie_nuevo").getAsString() ); 
            	equipojsnDTO.setAlta( gsonObj.get("alta").getAsString() );   
            	equipojsnDTO.setModelo_nuevo( gsonObj.get("modelo_nuevo").getAsString() ); 
            	equipojsnDTO.setGarantia( gsonObj.get("garantia").getAsString() );   
            	equipojsnDTO.setSistema( gsonObj.get("sistema").getAsString() );   
            	equipojsnDTO.setOrden( gsonObj.get("orden").getAsString() );
            	equipojsnDTO.setComentarios( gsonObj.get("comentarios").getAsString() );    
            	equipojsnDTO.setProgramado( gsonObj.get("programado").getAsString() );   
            	equipojsnDTO.setProveedor( gsonObj.get("proveedor").getAsString() );   
            	equipojsnDTO.setEstatus_control( gsonObj.get("estatus_control").getAsString() );     
            	equipojsnDTO.setAccion( gsonObj.get("accion").getAsString() );   
            	// Ids
            	equipojsnDTO.setEst( Integer.valueOf( gsonObj.get("est").getAsString() ) );   
            	equipojsnDTO.setReg( Integer.valueOf( gsonObj.get("reg").getAsString() ) );   
            	equipojsnDTO.setLoc( Integer.valueOf( gsonObj.get("loc").getAsString() ) );   
            	equipojsnDTO.setBod( Integer.valueOf( gsonObj.get("bod").getAsString() ) );   
            	equipojsnDTO.setRaz( Integer.valueOf( gsonObj.get("raz").getAsString() ) );   
            	equipojsnDTO.setAcc( Integer.valueOf( gsonObj.get("acc").getAsString() ) );   
            	equipojsnDTO.setCtrl( Integer.valueOf( gsonObj.get("ctrl").getAsString() ) );   
            	// Informacion del registro
            	equipojsnDTO.setUsuario_modifica( gsonObj.get("usuario_modifica").getAsString() );   
            	equipojsnDTO.setFecha_modifica( gsonObj.get("fecha_modifica").getAsString() );   
            	// equipojsnDTO.setArchivo( gsonObj.get("archivo").getAsString() );
            	// 26Oct2020 - campos Nuevos
            	equipojsnDTO.setMes_renovacion( gsonObj.get("mes_renovacion").getAsString() );
            	equipojsnDTO.setTicket( gsonObj.get("ticket").getAsString() );
            	equipojsnDTO.setComm_control( gsonObj.get("comm_control").getAsString() );
            	
            	equipos.add(equipojsnDTO);
            }
        } catch (Exception e) {
            System.out.println("Exception in NetClientGet GET - buscarEquiposPorDTO: - " + uriSelectEquipo + " - " + e);
        }
		return equipos; 
	}
	
	public EquipoDTO buscarRegistroEquipoPorID( int id ) {
		System.out.println("Service {} - Se realiza la consulta del Registro 'Equipo' en la Base de datos Mediante WS-Rest");
		EquipoDTO  equipo = new EquipoDTO();
		Utilidades utils  = new Utilidades();
		String jsonEquipo   = "";
		String uriRegEquipo = "";
		
		try {
			uriRegEquipo = "http://" + constantes.IP_APLICAION + constantes.EQP_CONTEXT + "/equipos/equipos-consultarPorId/" + id;
			// uriRegEquipo = "http://localhost:8060/equipos/equipos-consultarPorId/" + id;
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
            
            // equipo = utils.convierteJsonToObject_Equipo( jsonEquipo );       
            Gson gson = new Gson(); 
            equipo = gson.fromJson(jsonEquipo, EquipoDTO.class); 
            
        } catch (Exception e) {
            System.out.println("Exception in NetClientGet GET - buscarRegistroEquipoPorID: - " + uriRegEquipo + " - "+ e);
        }
		return equipo;
	}

}
