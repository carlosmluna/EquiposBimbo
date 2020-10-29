package mx.com.bimbo.equipos.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpSession;

import mx.com.bimbo.equipos.modelo.EquipoBusquedaModelo;
import mx.com.bimbo.equipos.modelo.EquipoModelo;
import mx.com.bimbo.equipos.modelo.dto.EquipoBusquedaDTO;
import mx.com.bimbo.equipos.modelo.dto.EquipoDTO;
import mx.com.bimbo.equipos.modelo.dto.LocalidadDTO;
import mx.com.bimbo.equipos.service.CatalogosService;
import mx.com.bimbo.equipos.service.EquipoService;
import mx.com.bimbo.equipos.util.Constantes;


@ManagedBean(name = "equipoBusBean", eager = true)
@SessionScoped
public class EquipoBusquedaBean {	
	
	private EquipoBusquedaModelo equipoBusquedaModelo;
	
	public EquipoBusquedaModelo getEquipoBusquedaModelo() {
		return equipoBusquedaModelo;
	}
	public void setEquipoBusquedaModelo(EquipoBusquedaModelo equipoBusquedaModelo) {
		this.equipoBusquedaModelo = equipoBusquedaModelo;
	}

	// Instancio Objetos
	CatalogosService catalogoService = new CatalogosService();
	EquipoService    equipoService   = new EquipoService();

	
	public EquipoBusquedaBean() {
		equipoBusquedaModelo = new EquipoBusquedaModelo();
		this.limpiaCamposPantalla();		// limpio campos de pantalla	
		this.consultaListaLocalidades();	// Lleno combo Localidades	
	}	
	
	
	// Limpio campos de pantalla
	public void limpiaCamposPantalla() {
		equipoBusquedaModelo.setEstatus( Constantes.CHAR_VACIO );  
		equipoBusquedaModelo.setRegion( Constantes.CHAR_VACIO );
		equipoBusquedaModelo.setLocalidad( Constantes.CHAR_VACIO );
		equipoBusquedaModelo.setBodega( Constantes.CHAR_VACIO );
		equipoBusquedaModelo.setRazonSocial( Constantes.CHAR_VACIO );
		equipoBusquedaModelo.setModelo( Constantes.CHAR_VACIO );
		equipoBusquedaModelo.setAccion( Constantes.CHAR_VACIO );
		equipoBusquedaModelo.setEquiposList( null );
	}
		
	private void consultaListaLocalidades() {
		List<SelectItem> localidadesList = new ArrayList<SelectItem>();
		
		List<LocalidadDTO> localidades = catalogoService.buscarLocalidades();
		for ( int ind=0; ind<localidades.size(); ind++ ) {
			SelectItem itmLocalidad = new SelectItem();
			
			itmLocalidad.setValue( localidades.get(ind).getId_localidad() );
			itmLocalidad.setLabel( localidades.get(ind).getLocalidad() );
			localidadesList.add(itmLocalidad);
		}		
		equipoBusquedaModelo.setLocalidadesList(localidadesList);
	}
	
	public void buscarEquiposFiltrosPantalla() {
		EquipoService equipoService = new EquipoService();
		// String request = "{\"id\":1}";
		
		// 21/Oct/2020 - CMLFJ - Se comenta por que se solicita que no se haga la validacion del estatus requerido
		/* FacesContext fcesContext = FacesContext.getCurrentInstance();
		if ( equipoBusquedaModelo.getEstatus().equals("") ) {
			fcesContext.addMessage(null, new FacesMessage("Error", "Seleccione un 'Estatus' para realizar la busqueda") );
		} else {
			// buscarEquiposMSSericio( equipoBusquedaModelo );
			List<EquipoDTO> equiposDTO = equipoService.buscarEquiposPorDTO( equipoBusquedaModelo ); 	
			equipoBusquedaModelo.setEquipos(equiposDTO);
		} */
		
		List<EquipoDTO> equiposDTO = equipoService.buscarEquiposPorDTO( equipoBusquedaModelo ); 	
		equipoBusquedaModelo.setEquipos(equiposDTO);
	}
	
	public String buscaRegistroEquipo( EquipoDTO equipo ) {
		String pagina = "";
		
		EquipoService equipoService = new EquipoService();
		EquipoModelo  equipoModelo  = new EquipoModelo();
		
		EquipoDTO equipoDto = equipoService.buscarRegistroEquipoPorID( equipo.getId() );
		
		equipoModelo.setId( equipoDto.getId() );
		equipoModelo.setEstatus( equipoDto.getEstatus() !=null ? equipoDto.getEstatus() : "" );
		equipoModelo.setRegion( equipoDto.getRegion() !=null ? equipoDto.getRegion() : "" );
		equipoModelo.setLocalidad( equipoDto.getLocalidad() !=null ? equipoDto.getLocalidad() : "" );
		equipoModelo.setBodega( equipoDto.getBodega() !=null ? equipoDto.getBodega() : "" );
		equipoModelo.setRazon( equipoDto.getRazon() !=null ? equipoDto.getRazon() : "" );
		// Informacion del Equipo a Reemplazar
		equipoModelo.setEmpleado( equipoDto.getEmpleado() !=null ? equipoDto.getEmpleado() : "" );
		equipoModelo.setNombre_cambio( equipoDto.getNombre_cambio() !=null ? equipoDto.getNombre_cambio() : "" );
		equipoModelo.setSerie_cambio( equipoDto.getSerie_cambio() !=null ? equipoDto.getSerie_cambio() : "" );		
		equipoModelo.setEstatus_cambio( equipoDto.getEstatus_cambio() !=null ? equipoDto.getEstatus_cambio() : "" );
		equipoModelo.setMarca( equipoDto.getMarca() !=null ? equipoDto.getMarca() : "" );
		equipoModelo.setModelo( equipoDto.getModelo() !=null ? equipoDto.getModelo() : "" );
		// Informacion del Equipo Nuevo
		equipoModelo.setNombre_nuevo( equipoDto.getNombre_nuevo() !=null ? equipoDto.getNombre_nuevo() : "" );
		equipoModelo.setSerie_nuevo( equipoDto.getSerie_nuevo() !=null ? equipoDto.getSerie_nuevo() : "" );
		equipoModelo.setAlta( equipoDto.getAlta() !=null ? equipoDto.getAlta() : "" );
		equipoModelo.setModelo_nuevo( equipoDto.getModelo_nuevo() !=null ? equipoDto.getModelo_nuevo() : "" );
		equipoModelo.setGarantia( equipoDto.getGarantia() !=null ? equipoDto.getGarantia() : "" ); 
		equipoModelo.setSistema( equipoDto.getSistema() !=null ? equipoDto.getSistema() : "" );			
		equipoModelo.setOrden( equipoDto.getOrden() !=null ? equipoDto.getOrden() : "" );
		equipoModelo.setComentarios( equipoDto.getComentarios() !=null ? equipoDto.getComentarios() : ""  );   
		equipoModelo.setProgramado( equipoDto.getProgramado() !=null ? equipoDto.getProgramado() : "" ); 
		equipoModelo.setProveedor( equipoDto.getProveedor() !=null ? equipoDto.getProveedor() : "" );     
		equipoModelo.setEstatus_control( equipoDto.getEstatus_control() !=null ? equipoDto.getEstatus_control() : "" );
		equipoModelo.setAccion( equipoDto.getAccion() !=null ? equipoDto.getAccion() : "" );	 	
		//  Obtengo los ids
		equipoModelo.setEst( equipoDto.getEst() );
		equipoModelo.setReg( equipoDto.getReg() );
		equipoModelo.setLoc( equipoDto.getLoc() );
		equipoModelo.setBod( equipoDto.getBod() );
		equipoModelo.setRaz( equipoDto.getRaz() );
		equipoModelo.setAcc( equipoDto.getAcc() );
		equipoModelo.setCtrl( equipoDto.getCtrl() );
		// Informacion del Actualizacion del Registro
		equipoModelo.setModificado_por( equipoDto.getUsuario_modifica() !=null ? equipoDto.getUsuario_modifica() : "" );
		equipoModelo.setFecha_modifica( equipoDto.getFecha_modifica() !=null ? equipoDto.getFecha_modifica() : "" );
		// equipoModelo.setNombre_recambio( equipoDto.getNombre_recambio() !=null ? equipoDto.getNombre_recambio() : "" );	
		// equipoModelo.setSerie_renombre( equipoDto.getSerie_renombre() !=null ? equipoDto.getSerie_renombre() : "" );
		// 26Oct2020 - Campos Nuevos
		equipoModelo.setMes_renovacion( equipoDto.getMes_renovacion()!=null ? equipoDto.getMes_renovacion() : "" );
		equipoModelo.setTicket( equipoDto.getTicket()!=null ? equipoDto.getTicket() : "" );
		equipoModelo.setComm_control( equipoDto.getComm_control()!=null ? equipoDto.getComm_control() : "" );
		
		FacesContext context  = javax.faces.context.FacesContext.getCurrentInstance();
		HttpSession session   = (HttpSession) context.getExternalContext().getSession(false);
		session.setAttribute("equipoModelDTO", equipoModelo);
		session.setAttribute("editar", "S");
		
		// int administrador = (Integer) session.getAttribute("administrador");
		int administrador = 1;
		if ( administrador == 1 ) {
			pagina = "equipo";    } 
		else { 
			pagina = "updEquipo"; }
		
		return pagina;
	}
	
	public String cerrarSesionBsuqueda() {
		FacesContext context  = javax.faces.context.FacesContext.getCurrentInstance();
		HttpSession session   = (HttpSession) context.getExternalContext().getSession(false);
		session.setAttribute("usuario", "");
		return "login";
	}
}
