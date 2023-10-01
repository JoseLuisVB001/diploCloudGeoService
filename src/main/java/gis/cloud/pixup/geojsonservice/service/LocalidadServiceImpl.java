package gis.cloud.pixup.geojsonservice.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gis.cloud.pixup.geojsonservice.domain.Zona;
import gis.cloud.pixup.geojsonservice.domain.Localidad;
import gis.cloud.pixup.geojsonservice.domain.LocalidadAlreadyExistsException;
import gis.cloud.pixup.geojsonservice.repository.LocalidadRepository;

@Service
public class LocalidadServiceImpl implements LocalidadService {
	
	@Autowired
	private LocalidadRepository localidadRepository;
	
	private static final Logger LOG = 
			LoggerFactory.getLogger(LocalidadServiceImpl.class);

	@Override
	public Localidad registrarLocalidad(Localidad localidad, Zona zona) {
		// validacion localidad existente
		Optional<Localidad> localidadExistente = 
				localidadRepository.findByNumReporte(localidad.getNumReporte());
		if (localidadExistente.isPresent()) {
			throw new LocalidadAlreadyExistsException(localidad.getNumReporte());
		}
		
		// guardar localidad
		localidad.getZonas().add(zona);
		localidadRepository.save(localidad);
		LOG.info("Localidad Registrada: " + localidad);
		
		return localidad;
	}

}
