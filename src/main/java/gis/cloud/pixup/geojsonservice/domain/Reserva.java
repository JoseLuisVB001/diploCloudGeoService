package gis.cloud.pixup.geojsonservice.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Document(collection="reservas")
public class Reserva {
	
	@Id
	private String id;
	private String nombre;

}
