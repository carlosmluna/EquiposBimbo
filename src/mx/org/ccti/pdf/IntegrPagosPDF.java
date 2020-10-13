package mx.org.ccti.pdf;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet; */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import mx.org.ccti.modelo.CampoBO;
import mx.org.ccti.modelo.IntegrPagoModelo;

public class IntegrPagosPDF {

	public String llenaPlantilla(List<CampoBO> campos, String claveTramite) throws Exception {		
		String url = "";
		String plantilla = null;
		
		if (!claveTramite.isEmpty()){
			try {
				/*
				 * Iniciamos sesion en el reposiorio desde aqui para no tener que hacerlo
				 * cada vez que necesitemos traer una imagen
				 */			
				String nombreReporte = "reporteTempPago.xlsx";
				String nombreReporteConvertido = "reporteTempPago.pdf";
				
				if (claveTramite.equals("0006")) {
					plantilla = "/opt/reportes/pagoAguaPotable.xlsx"; 			// Comentar para desarrolo en PC
					// plantilla = "C://opt//reportes//pagoAguaPotable.xlsx"; 	// Descomentar para desarrolo en PC
				} else {
					plantilla = "/opt/reportes/pagoPredial.xlsx"; 				// Comentar para desarrolo en PC
					// plantilla = "C://opt//reportes//pagoPredial.xlsx";		// Descomentar para desarrolo en PC
				}
				
				/* InputStream is = new FileInputStream(plantilla);
				Workbook wb = new XSSFWorkbook(is);
				
				// Ciclo principal del reporte
				for (int i = 0; i < wb.getNumberOfSheets(); i++) {
					Sheet sheet = wb.getSheetAt(i);		
					
					for (Row row : sheet) {
						for (Cell cell : row) {
							switch (cell.getCellType()) {
								// Ignora las celdas que no son string
								case Cell.CELL_TYPE_STRING:
									String cellContents = cell.getStringCellValue();
									cell.setCellValue(getConvertedString(cellContents, campos));
							}
						}
					}
				} */	
				
				/*
				 * Termina procesamiento de plantilla, procedemos a generar archivo de salida,
				 * convertir a PDF y subirlo al repositorio
				 */
				FileOutputStream out = new FileOutputStream("/opt/reportes/" + nombreReporte);			// Comentar para desarrolo en PC
				// FileOutputStream out = new FileOutputStream("C://opt//reportes//" + nombreReporte);	// Desomentar para desarrolo en PC
				// wb.write(out);
				out.close();				
					
				OOfficeConverter.convertToPDF("/opt/reportes/" + nombreReporte, "/opt/reportes/"  + nombreReporteConvertido);				// Comentar para desarrolo en PC
				// OOfficeConverter.convertToPDF("C://opt//reportes//" + nombreReporte, "C://opt//reportes//"  + nombreReporteConvertido);	// Descomentar para desarrolo en PC
				System.out.println("OIRAM11: pdf " + nombreReporteConvertido);
				url = "/opt/reportes/" + nombreReporteConvertido;		
				System.out.println("Url: " + url);
			} catch (Exception ex) {
				ex.printStackTrace();
				System.err.println("Error en llenaPlantilla: " + ex);
				throw new Exception("Error: " + ex.getMessage());
			} finally {
				//AlfrescoUtil.cerrarSesion();
			}
			
		}
		return url;
	}	
	
	/**
	 * Utilizando expresiones regulares busca los tags xml dentro
	 * de cada una de las celdas del libro, por cada celda encontrada
	 * realiza una busqueda en la lista de campos y si lo encuentra
	 * asigna el valor, si no asigna caracter vacio ""
	 * 
	 * @param source	El texto de una celda del libro xlsx
	 * @param campos	La lista de campos global
	 * @return			El texto con los valores esperados
	 */
	private String getConvertedString(String source, List<CampoBO> campos) {
		String value = "";
		// Busca campos xml con formato predefinido, por ejemplo <CI_nom_ciudadano>
		Pattern pat = Pattern.compile("<[\\w]+>");
		Matcher mat = pat.matcher(source);
		CampoBO c;
		int idx;
		StringBuffer sb = new StringBuffer();
		
		while (mat.find()) {
			c = new CampoBO();
			if (mat.group().equals("<folio_general>")) { // probar si si queda
				c.setXmlCampo("CI_tipo_tramite");
				idx = Collections.binarySearch(campos, c);				
			} else {
				// Quitamos los <> para buscar en la lista
				c.setXmlCampo(mat.group().substring(1, mat.group().length() -1));
				idx = Collections.binarySearch(campos, c);
				if (idx > -1 && campos.get(idx).getValor() != null) {				
					mat.appendReplacement(sb, campos.get(idx).getValor());
				} else {
					mat.appendReplacement(sb, "");
				}
			}					
		}
		mat.appendTail(sb);
		value = sb.toString();
		return value;
	}
	
	/**
	 * Abro en una nueva ventana el formato de pago para impresion
	 * @param source	Plnatilla de pago xls
	 * @param campos	La lista de campos global
	 * @return			Abrir la Plantilla de pago en formato PDF
	 */
	public String visualizaArchivoPDF(String urlReporte, IntegrPagoModelo integrPagoModelo) {
        byte[] bytes = new byte[2000];
        FileInputStream is = null;
		int    read = 0;
        
        try {
        	is = new FileInputStream( urlReporte );
        } catch (FileNotFoundException ex) {
        	integrPagoModelo.setMensaje("Error al abrir PDF");
            System.err.println("Error abriendo PDF" + ex);
        }
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        response.setContentType("application/pdf");
        response.addHeader("Content-disposition", "attachment; filename=/" + urlReporte );		// Descomentar para produccion
        // response.addHeader("Content-disposition", "attachment; filename=/c:" + urlReporte );	// Descomentar para desarrollo en la PC
        ServletOutputStream os;
        try {
            os = response.getOutputStream();
            while ((read = is.read(bytes)) != -1) {
                os.write(bytes, 0, read); }
            os.flush();
            os.close();
            System.out.println("DESCARGANDO");
            FacesContext.getCurrentInstance().responseComplete();
        } catch (IOException ex) {
        	integrPagoModelo.setMensaje("No se puede accesar al PDF");
            System.err.println("Error en servletOutpusStream\n" + ex);
        }	
        
        return "";
	}	
}
