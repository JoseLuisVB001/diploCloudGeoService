package gis.cloud.pixup.geojsonservice.service;

import gis.cloud.pixup.geojsonservice.domain.Zona;
import gis.cloud.pixup.geojsonservice.domain.Localidad;

public interface LocalidadService {
	
	Localidad registrarLocalidad(
		Localidad localidad, Zona zona);

}
