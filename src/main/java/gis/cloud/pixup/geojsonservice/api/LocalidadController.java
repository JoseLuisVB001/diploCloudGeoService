package gis.cloud.pixup.geojsonservice.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import gis.cloud.pixup.geojsonservice.domain.Localidad;
import gis.cloud.pixup.geojsonservice.dto.RegistroLocalidadRequest;
import gis.cloud.pixup.geojsonservice.service.LocalidadService;

@RestController
public class LocalidadController implements LocalidadApi {

	@Autowired
	private LocalidadService localidadService;
	
	@Override
	public Localidad registrarLocalidad(
			RegistroLocalidadRequest request) {
		return localidadService.registrarLocalidad(
			request.getLocalidad(), request.getZona());
	}

}
