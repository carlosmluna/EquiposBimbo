package mx.org.ccti.pdf;

import java.io.File;

/* import com.artofsolving.jodconverter.DocumentConverter;
import com.artofsolving.jodconverter.openoffice.connection.OpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.connection.SocketOpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.converter.OpenOfficeDocumentConverter; */

public class OOfficeConverter {
	/**
	 * Convierte un archivo de cualquier tipo a pdf utilizando un servicio de openoffice
	 * que corre en segundo plano, por default en localhost y puerto 8100
	 * 
	 * @param input			El archivo a convertir
	 * @param output		El archivo convertido
	 * @throws Exception	Alguna excepcion que surja durante el proceso
	 */
	public static void convertToPDF(String input, String output) throws Exception {
		/* OpenOfficeConnection connection = new SocketOpenOfficeConnection(8100);		
		try {
			connection.connect();

			File inputFile = new File(input);
			File outputFile = new File(output);

			DocumentConverter converter = new OpenOfficeDocumentConverter(connection);
			converter.convert(inputFile, outputFile);

		} finally {
			connection.disconnect();
		} */
	}
}
