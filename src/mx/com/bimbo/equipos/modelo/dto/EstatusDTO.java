package mx.com.bimbo.equipos.modelo.dto;

public class EstatusDTO {
	// Declaro los atributos de la clase
	private Integer cveEstatus;
	private String  descripcion;
	
	
	// Metodos Contructores de la clase
	public EstatusDTO() { }
	
	public EstatusDTO(Integer cveEstatus, String descripcion) {
		this.cveEstatus  = cveEstatus;
		this.descripcion = descripcion;
	}
	
	
	public Integer getCveEstatus() {
		return cveEstatus;
	}
	public void setCveEstatus(Integer cveEstatus) {
		this.cveEstatus = cveEstatus;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	@Override
	public String toString() {
		return "EstatusEntity [cveEstatus=" + cveEstatus + ", descripcion=" + descripcion + "]";
	}
}
