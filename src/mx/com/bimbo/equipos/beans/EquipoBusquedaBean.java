package mx.com.bimbo.equipos.beans;

import java.util.ArrayList;
import java.util.List;

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
		
		List<LocalidadDTO> localidades = catalogoService.buscarLocalidadMSSericio();
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
		
		// buscarEquiposMSSericio( equipoBusquedaModelo );
		List<EquipoDTO> equiposDTO = equipoService.buscarEquiposPorDTOMSSericio( equipoBusquedaModelo ); 	
		equipoBusquedaModelo.setEquipos(equiposDTO);
	}
	
	public String buscaRegistroEquipo( EquipoDTO equipo ) {
		String pagina = "";
		
		EquipoService equipoService = new EquipoService();
		EquipoModelo  equipoModelo  = new EquipoModelo();
		
		EquipoDTO equipoDto = equipoService.buscarRegistroEquipoMSSericio( equipo.getId() );
		equipoModelo.setId( equipoDto.getId() );
		equipoModelo.setEstatus( equipoDto.getEstatus() !=null ? equipoDto.getEstatus() : "" );
		equipoModelo.setRegion( equipoDto.getRegion() !=null ? equipoDto.getRegion() : "" );
		equipoModelo.setLocalidad( equipoDto.getLocalidad() !=null ? equipoDto.getLocalidad() : "" );
		equipoModelo.setBodega( equipoDto.getBodega() !=null ? equipoDto.getBodega() : "" );
		equipoModelo.setRazon( equipoDto.getRazon() !=null ? equipoDto.getRazon() : "" );
		equipoModelo.setEmpleado( equipoDto.getEmpleado() !=null ? equipoDto.getEmpleado() : "" );
		equipoModelo.setSerie_cambio( equipoDto.getSerie_cambio() !=null ? equipoDto.getSerie_cambio() : "" );
		equipoModelo.setNombre_cambio( equipoDto.getNombre_cambio() !=null ? equipoDto.getNombre_cambio() : "" );
		equipoModelo.setEstatus_cambio( equipoDto.getEstatus_cambio() !=null ? equipoDto.getEstatus_cambio() : "" );
		equipoModelo.setMarca( equipoDto.getMarca() !=null ? equipoDto.getMarca() : "" );
		equipoModelo.setModelo( equipoDto.getModelo() !=null ? equipoDto.getModelo() : "" );
		equipoModelo.setNombre_nuevo( equipoDto.getNombre_nuevo() !=null ? equipoDto.getNombre_nuevo() : "" );
		equipoModelo.setSerie_nuevo( equipoDto.getSerie_nuevo() !=null ? equipoDto.getSerie_nuevo() : "" );
		equipoModelo.setModelo_nuevo( equipoDto.getModelo_nuevo() !=null ? equipoDto.getModelo_nuevo() : "" );
		equipoModelo.setOrden( equipoDto.getOrden() !=null ? equipoDto.getOrden() : "" );
		equipoModelo.setAccion( equipoDto.getAccion() !=null ? equipoDto.getAccion() : "" );
		equipoModelo.setProgramado( equipoDto.getProgramado() !=null ? equipoDto.getProgramado() : "" );   
		equipoModelo.setProveedor( equipoDto.getProveedor() !=null ? equipoDto.getProveedor() : "" );     
		equipoModelo.setComentarios( equipoDto.getComentarios() !=null ? equipoDto.getComentarios() : ""  );    
		equipoModelo.setArchivo( equipoDto.getArchivo() !=null ? equipoDto.getArchivo() : "" );
		equipoModelo.setGarantia( equipoDto.getGarantia() !=null ? equipoDto.getGarantia() : "" ); 
		equipoModelo.setSistema( equipoDto.getSistema() !=null ? equipoDto.getSistema() : "" );	
		//  Obtengo los ids
		equipoModelo.setEst( equipoDto.getEst() );
		equipoModelo.setReg( equipoDto.getReg() );
		equipoModelo.setLoc( equipoDto.getLoc() );
		equipoModelo.setBod( equipoDto.getBod() );
		equipoModelo.setRaz( equipoDto.getRaz() );
		equipoModelo.setAcc( equipoDto.getAcc() );
		// Obtengo los campos nuevos
		equipoModelo.setAlta( equipoDto.getAlta() !=null ? equipoDto.getAlta() : "" );
		equipoModelo.setEstatus_control( equipoDto.getEstatus_control() !=null ? equipoDto.getEstatus_control() : "" );
		equipoModelo.setNombre_recambio( equipoDto.getNombre_recambio() !=null ? equipoDto.getNombre_recambio() : "" );	
		equipoModelo.setSerie_renombre( equipoDto.getSerie_renombre() !=null ? equipoDto.getSerie_renombre() : "" );
		
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
