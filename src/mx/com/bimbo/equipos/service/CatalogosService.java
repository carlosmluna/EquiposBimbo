package mx.com.bimbo.equipos.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import mx.com.bimbo.equipos.modelo.dto.CatalogoDTO;
import mx.com.bimbo.equipos.modelo.dto.LocalidadDTO;
import mx.com.bimbo.equipos.util.Constantes;
import mx.com.bimbo.equipos.util.Utilidades;

public class CatalogosService {
	Utilidades utils      = new Utilidades();
	Constantes constantes = new Constantes();
	
	
	public List<LocalidadDTO> buscarLocalidadMSSericio( ) {		
		System.out.println("Service {} - Se realiza la consulta de 'Localidades' en la Base de datos Mediante WS-Rest");
		List<LocalidadDTO> localidades = new ArrayList<LocalidadDTO>();
		String jsonLocalidad      = "";
		
		try {
            URL url = new URL("http://" + constantes.IP_APLICAION + ":8070/catalogo/catlocalidades-consultar");	//your url i.e fetch data from .
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
                jsonLocalidad = output;
            }
            conn.disconnect();
            
            JsonParser parser = new JsonParser();
            JsonArray gsonArr = parser.parse(jsonLocalidad).getAsJsonArray();
            for (JsonElement obj : gsonArr) {
            	LocalidadDTO localidadDTO = new LocalidadDTO();
            	JsonObject   gsonObj      = obj.getAsJsonObject();
            	                 	
            	localidadDTO.setId_localidad( gsonObj.get("id").getAsInt() );
            	localidadDTO.setLocalidad( gsonObj.get("localidad").getAsString() );
            	localidades.add(localidadDTO);
            }
            /* Gson gson = new Gson(); 
            LocalidadEntity[] localidades = gson.fromJson(jsonLocalidad, LocalidadEntity[].class); */
        } catch (Exception e) {
            System.out.println("Exception in NetClientGet GET - Buscar Localidades: - " + e);
        }
		return localidades;
	}
	
	public CatalogoDTO buscarRegistroCatalogoID( int catalogo, int idCatalogo ) {		
		System.out.println("Service {} - Se realiza la consulta de 'Estatus' en la Base de datos Mediante WS-Rest");
		CatalogoDTO catalogoDTO = new CatalogoDTO();
		String jsonCatalogo = "";
		String urlCatalogo   = "";
		
		try {
			switch ( catalogo ) {
				case 1: urlCatalogo = "catestatus-consultar-porid/"; 			break;
				case 2: urlCatalogo = "catlocalidades-consultar-porid/"; 		break;
				case 3: urlCatalogo = "catbodegas-consultar-porid/"; 			break;
				case 4: urlCatalogo = "catAcciones-consultar-porid/"; 			break;
				case 5: urlCatalogo = "catRegiones-consultar-porid/"; 			break;
				case 6: urlCatalogo = "catRazonsocilUsuario-consultar-porid/"; 	break;
			default: break;
			}
			
            URL url = new URL("http://" + constantes.IP_APLICAION + ":8070/catalogo/" + urlCatalogo + idCatalogo);	//your url i.e fetch data from .
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
                jsonCatalogo = output;
            }
            conn.disconnect();
            
            /* JsonParser parser = new JsonParser();
            JsonArray gsonArr = parser.parse(jsonLocalidad).getAsJsonArray();
            for (JsonElement obj : gsonArr) {
            	LocalidadDTO localidadDTO = new LocalidadDTO();
            	JsonObject   gsonObj      = obj.getAsJsonObject();
            	                 	
            	localidadDTO.setId_localidad( gsonObj.get("id").getAsInt() );
            	localidadDTO.setLocalidad( gsonObj.get("localidad").getAsString() );
            	localidades.add(localidadDTO);
            }*/
            catalogoDTO = utils.convierteJsonToObject_Catalogo(jsonCatalogo);
            /* Gson gson = new Gson(); 
            LocalidadEntity[] localidades = gson.fromJson(jsonLocalidad, LocalidadEntity[].class); */
        } catch (Exception e) {
            System.out.println("Exception in NetClientGet GET - Buscar Localidades: - " + e);
        }
		return catalogoDTO;
	}
	
}
