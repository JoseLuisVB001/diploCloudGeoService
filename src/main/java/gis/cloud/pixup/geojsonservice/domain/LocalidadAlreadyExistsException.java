package gis.cloud.pixup.geojsonservice.domain;

public class LocalidadAlreadyExistsException extends RuntimeException {
	
	public LocalidadAlreadyExistsException(String numReporte) {
		super("Ya existe una localidad registrada con ese número de reporte: " + numReporte);
	}

}
