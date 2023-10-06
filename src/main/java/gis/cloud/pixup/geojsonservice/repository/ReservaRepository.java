package gis.cloud.pixup.geojsonservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import gis.cloud.pixup.geojsonservice.domain.Reserva;

public interface ReservaRepository 
	extends MongoRepository<Reserva, String>{

}
