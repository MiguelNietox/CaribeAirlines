package co.edu.uniquindio.estructurasDatos.ProyectoFinal.persistencia;

import co.edu.uniquindio.estructurasDatos.ProyectoFinal.model.Aerolinea;

public class Persistencia {

	public static final String RUTA_ARCHIVO_MODELO_MARKETONLY_XML = "C:/td/persistencia/model.xml";

//	------------------------------------SERIALIZACION  y XML -------------------------------------------


	public static Aerolinea cargarRecursoMarketplaceXML() {

		Aerolinea aerolinea = null;

		try {
			aerolinea = (Aerolinea)ArchivoUtil.cargarRecursoSerializadoXML(RUTA_ARCHIVO_MODELO_MARKETONLY_XML);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return aerolinea;
	}

	public static void guardarRecursoMarketplaceXML(Aerolinea aerolinea) {

		System.out.println(aerolinea.getListaUsuarios().getTamanio());
		try {
			ArchivoUtil.salvarRecursoSerializadoXML(RUTA_ARCHIVO_MODELO_MARKETONLY_XML, aerolinea);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
