package gis.cloud.pixup.geojsonservice.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import gis.cloud.pixup.geojsonservice.domain.Localidad;

public interface LocalidadRepository 
	extends MongoRepository<Localidad, String>{
	
	Optional<Localidad> findByNumReporte(String numReporte);

}
