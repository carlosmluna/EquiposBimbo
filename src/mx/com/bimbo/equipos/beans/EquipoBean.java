package mx.com.bimbo.equipos.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpSession;

import mx.com.bimbo.equipos.modelo.EquipoModelo;
import mx.com.bimbo.equipos.modelo.dto.EquipoDTO;
import mx.com.bimbo.equipos.modelo.dto.LocalidadDTO;
import mx.com.bimbo.equipos.service.CatalogosService;
import mx.com.bimbo.equipos.service.EquipoService;
import mx.com.bimbo.equipos.util.Constantes;

@ManagedBean(name = "equipoBean", eager = true)
@RequestScoped
public class EquipoBean {
	EquipoModelo equipoModelo;
		
	public EquipoModelo getEquipoModelo() {
		return equipoModelo;
	}
	public void setEquipoModelo(EquipoModelo equipoModelo) {
		this.equipoModelo = equipoModelo;
	}


	// Instancio Objetos
	CatalogosService catalogoService = new CatalogosService();
	EquipoService    equipoService   = new EquipoService();
	
	
	public EquipoBean() {
		String equipoEditar = "N";
				
		FacesContext context = javax.faces.context.FacesContext.getCurrentInstance();
		HttpSession session  = (HttpSession) context.getExternalContext().getSession(false);
		equipoEditar   = (String) session.getAttribute("editar");
		
		equipoModelo = new EquipoModelo();
		
		if ( equipoEditar.equals("N") ) 		{	// limpio campos de pantalla				
			this.consultaListaLocalidades();			// Lleno la lista de localidades	
			this.limpiaCamposPantalla();	
		} 
		if ( equipoEditar.equals("S") ) 		{
			this.consultaListaLocalidades();			// Lleno la lista de localidades	
			equipoModelo = (EquipoModelo) session.getAttribute("equipoModelDTO");			
			session.setAttribute("editar", "G");
		}		
		// inicializazaCamposPantallaPrueba();
	}
	
	
	// Limpio campos de pantalla
	private void limpiaCamposPantalla() {
		equipoModelo.setId(0);
		equipoModelo.setEstatus( Constantes.CHAR_VACIO );  
		equipoModelo.setRegion( Constantes.CHAR_VACIO );
		equipoModelo.setLocalidad( Constantes.CHAR_VACIO );
		equipoModelo.setBodega( Constantes.CHAR_VACIO );
		equipoModelo.setRazon( Constantes.CHAR_VACIO );
		equipoModelo.setEmpleado( Constantes.CHAR_VACIO );
		equipoModelo.setSerie_cambio( Constantes.CHAR_VACIO ); 
		equipoModelo.setNombre_cambio( Constantes.CHAR_VACIO );
		equipoModelo.setEstatus_cambio( Constantes.CHAR_VACIO );
		equipoModelo.setMarca( Constantes.CHAR_VACIO );
		equipoModelo.setModelo( Constantes.CHAR_VACIO );
		equipoModelo.setNombre_nuevo( Constantes.CHAR_VACIO ); 
		equipoModelo.setSerie_nuevo( Constantes.CHAR_VACIO );   
		equipoModelo.setModelo_nuevo( Constantes.CHAR_VACIO );   
		equipoModelo.setOrden( Constantes.CHAR_VACIO );
		equipoModelo.setAccion( Constantes.CHAR_VACIO );  
		equipoModelo.setProgramado( Constantes.CHAR_VACIO );   
		equipoModelo.setProveedor( Constantes.CHAR_VACIO );     
		equipoModelo.setComentarios( Constantes.CHAR_VACIO );    
		equipoModelo.setArchivo( Constantes.CHAR_VACIO );
		equipoModelo.setGarantia( Constantes.CHAR_VACIO ); 
		equipoModelo.setSistema( Constantes.CHAR_VACIO );	
		equipoModelo.getLocalidadesList( ).clear();
	}
		
	
	private void consultaListaLocalidades() {
		List<SelectItem> localidadesList = new ArrayList<SelectItem>();
		
		List<LocalidadDTO> localidades = catalogoService.buscarLocalidadMSSericio();
		for ( int ind=0; ind<localidades.size(); ind++ ) {
			SelectItem itmLocalidad = new SelectItem();
			
			itmLocalidad.setValue( localidades.get(ind).getId_localidad() );
			itmLocalidad.setLabel( localidades.get(ind).getLocalidad() );
			localidadesList.add(itmLocalidad);
		}		
		equipoModelo.setLocalidadesList(localidadesList);
	}
	
	private void inicializazaCamposPantallaPrueba() {
		equipoModelo.setId(5);
		equipoModelo.setEstatus( "3" );  
		equipoModelo.setRegion( "6" );
		equipoModelo.setLocalidad( "1" );
		equipoModelo.setBodega( "7" );
		equipoModelo.setRazon( "13" );
		equipoModelo.setEmpleado( "1232164" );
		equipoModelo.setSerie_cambio( "MXL225085S" ); 
		equipoModelo.setNombre_cambio( "Juan Carlos Andres Fierro Ortiz" );
		equipoModelo.setEstatus_cambio( "Missing" );
		equipoModelo.setMarca( "Hewlett-Packard" );
		equipoModelo.setModelo( "8200 ELITE" );
		equipoModelo.setNombre_nuevo( "CARLOS LUNA FERNANDEZ" ); 
		equipoModelo.setSerie_nuevo( "7654321" );   
		equipoModelo.setModelo_nuevo( "DELL VOSTRO 123" );   
		equipoModelo.setOrden( "4499001" );
		equipoModelo.setAccion( "2" );  
		equipoModelo.setProgramado( "05-ENE-2020" );   
		equipoModelo.setProveedor( "LBG" );     
		equipoModelo.setComentarios( "Equipo sale del proyecto ya que esta en Missng" );    
		equipoModelo.setArchivo( "ArchivoPrueba.txt" );
		equipoModelo.setGarantia( "31-ENE-2023" ); 
		equipoModelo.setSistema( "Windos 7 Professional Edition" );	
		equipoModelo.setModificado_por( "Administrador" );
		equipoModelo.setFecha_modifica( "01-OCT-2020" );
		// equipoModelo.setLocalidadesList( null );
	}
	
	public void actualizaInformacionEquipo() {
		/* FacesContext context  = javax.faces.context.FacesContext.getCurrentInstance();
		HttpSession session   = (HttpSession) context.getExternalContext().getSession(false);
		String usuario = (String) session.getAttribute("usaurio"); */
		String usuario = "SysAdmin";
		
		// Actualiza el registro de la pantalla
		EquipoDTO equipoDTO = equipoService.actualziarEquipoMSServivio( equipoModelo, usuario!=null ? usuario : "sysadmin" );
		FacesContext fcesContext = FacesContext.getCurrentInstance();
		if ( equipoDTO.getId()==0 ) {
			fcesContext.addMessage(null, new FacesMessage("Error",  "Ocurrio un Error al Guardar") );
		} else {
			fcesContext.addMessage(null, new FacesMessage("Successful",  "Equipo Actualizado") );
		}
		System.out.println("Actualizado: " + equipoDTO.toString());
	}
	
	/* public void obtenerRegistroEquipoSeleccionado( EquipoDTO equipo ) {
		// Obtengo el registro del equipo
		EquipoDTO equipoDTO = equipoService.buscarRegistroEquipoMSSericio( equipo.getId() );
		
		// Coloco el valor de resultado del Servicio en el modelo
		EquipoModelo equipoModelo = new EquipoModelo();
		equipoModelo.setId( equipoDTO.getId() );
		equipoModelo.setEstatus( equipoDTO.getEstatus() );
		equipoModelo.setRegion( equipoDTO.getRegion() );
		equipoModelo.setLocalidad( equipoDTO.getLocalidad() );
		equipoModelo.setBodega( equipoDTO.getBodega() );
		equipoModelo.setRazon( equipoDTO.getRazon() );
		equipoModelo.setEmpleado( equipoDTO.getEmpleado() ); 
		equipoModelo.setSerie_cambio( equipoDTO.getSerie_cambio() );
		equipoModelo.setNombre_cambio( equipoDTO.getNombre_cambio() );
		equipoModelo.setEstatus_cambio( equipoDTO.getEstatus_cambio() ); 
		equipoModelo.setMarca( equipoDTO.getMarca() );
		equipoModelo.setModelo( equipoDTO.getModelo() );
		equipoModelo.setNombre_nuevo( equipoDTO.getNombre_nuevo() );
		equipoModelo.setSerie_nuevo( equipoDTO.getSerie_nuevo() );
		equipoModelo.setModelo_nuevo( equipoDTO.getModelo_nuevo() ); 
		equipoModelo.setOrden( equipoDTO.getOrden() );
		equipoModelo.setAccion( equipoDTO.getAccion() );
		equipoModelo.setProgramado( equipoDTO.getProgramado() );   
		equipoModelo.setProveedor( equipoDTO.getProveedor() );
		equipoModelo.setComentarios( equipoDTO.getComentarios() );
		equipoModelo.setArchivo( equipoDTO.getArchivo() );
		equipoModelo.setGarantia( equipoDTO.getGarantia() );
		equipoModelo.setSistema( equipoDTO.getSistema() );
		equipoModelo.setModificado_por("CLUNA");
		equipoModelo.setFecha_modifica("01-OCT-2020");
	} */
	
	public String regresarBusqueda() {
		return "buscarEquipo";
	}
	
	public String salirSesionUsuario() {
		return "login";
	}
}
