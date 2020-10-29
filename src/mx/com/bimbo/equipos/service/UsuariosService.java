package mx.com.bimbo.equipos.service;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import mx.com.bimbo.equipos.modelo.EquipoModelo;
import mx.com.bimbo.equipos.modelo.dto.EquipoDTO;
import mx.com.bimbo.equipos.modelo.dto.LocalidadDTO;
import mx.com.bimbo.equipos.modelo.dto.UsuarioDTO;
import mx.com.bimbo.equipos.util.Constantes;
import mx.com.bimbo.equipos.util.Utilidades;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

public class UsuariosService {
	Constantes constantes = new Constantes();
	
	public UsuarioDTO buscarRegistroUsuario( String usuario ) {		
		System.out.println("Service {} - Se realiza la consulta de un 'Usuario' en la Base de datos Mediante WS-Rest");
		UsuarioDTO usarioDTO = null;
		String jsonUsuario   = "";
		
		try {

            // URL url = new URL("http://localhost:8050/usuario/usuario-consultarPorId/" + usuario);	//your url i.e fetch data from .
            String urlServicio = "http://" + constantes.IP_APLICAION + constantes.USR_CONTEXT + "/usuario/usuario-consultarPorId/" + usuario;
			System.out.println("urlServicio: " + urlServicio);
            URL url = new URL(urlServicio);
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
                jsonUsuario = output;
            }
            conn.disconnect();
            
            Gson gson = new Gson(); 
            usarioDTO = gson.fromJson(jsonUsuario, UsuarioDTO.class); 

        } catch (Exception e) {
            System.out.println("Exception in NetClientGet GET - Buscar Usuario: - " + e);
        }
		return usarioDTO;
	}
	
	public List<UsuarioDTO> buscarUsuarios( ) {		
		System.out.println("Service {} - Se realiza la consulta de 'Usuarios' en la Base de datos Mediante WS-Rest");
		List<UsuarioDTO> usuarios = new ArrayList<UsuarioDTO>();
		String jsonLocalidad      = "";
		
		try {
			String urlServicio = "http://" + constantes.IP_APLICAION + constantes.CAT_CONTEXT + "/catalogo/catlocalidades-consultar";
			System.out.println("urlServicio: " + urlServicio);
			URL url = new URL(urlServicio);	//your url i.e fetch data from .
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
            	UsuarioDTO usuarioDTO = new UsuarioDTO();
            	JsonObject   gsonObj      = obj.getAsJsonObject();
            	                 	
            	usuarioDTO.setId_usuario( gsonObj.get("id_usuario").getAsInt() );
            	usuarioDTO.setUsuario( gsonObj.get("usuario").getAsString() );
            	usuarioDTO.setAdministrador( gsonObj.get("administrador").getAsInt() );
            	usuarios.add(usuarioDTO);
            }
            /* Gson gson = new Gson(); 
            LocalidadEntity[] localidades = gson.fromJson(jsonLocalidad, LocalidadEntity[].class); */
        } catch (Exception e) {
            System.out.println("Exception in NetClientGet GET - Buscar Localidades: - " + e);
        }
		return usuarios;
	}
	
	public EquipoDTO actualziarUsuario( EquipoModelo equipoModelo, String suaurio ) {		
		System.out.println("Service {} - Se realiza la consulta de 'Estatus' en la Base de datos Mediante WS-Rest");
		EquipoDTO  equipo = new EquipoDTO();
		Utilidades utils  = new Utilidades();
		String jsonEquipo       = "";
		
		try {
			String uriUpdateEquipo = "http://" + constantes.IP_APLICAION + ":8060/equipos/equipos-actualizar" + 
					"?id=" 		+ String.valueOf( equipoModelo.getId() )                            +
					"&usuario=" + equipoModelo.getEstatus()   		+ 
					"&admin=" 	+ equipoModelo.getRegion(); 
			
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
            System.out.println("Exception in NetClientGet GET - Buscar Localidades: - " + e);
        }
		return equipo;
	}
	
	public EquipoDTO insertarUsuario( EquipoModelo equipoModelo, String suaurio ) {		
		System.out.println("Service {} - Se realiza la consulta de 'Estatus' en la Base de datos Mediante WS-Rest");
		EquipoDTO  equipo = new EquipoDTO();
		Utilidades utils  = new Utilidades();
		String jsonEquipo       = "";
		
		try {
			String uriUpdateEquipo = "http://" + constantes.IP_APLICAION + ":8060/equipos/equipos-actualizar" + 
					"?id=" 		+ String.valueOf( equipoModelo.getId() )                            +
					"&usuario=" + equipoModelo.getEstatus()   		+ 
					"&admin=" 	+ equipoModelo.getRegion(); 
			
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
            System.out.println("Exception in NetClientGet GET - Buscar Localidades: - " + e);
        }
		return equipo;
	}
}
