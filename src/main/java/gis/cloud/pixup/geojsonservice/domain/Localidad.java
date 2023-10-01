package gis.cloud.pixup.geojsonservice.domain;

import java.util.Collection;
import java.util.LinkedHashSet;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Document(collection="localidades")
public class Localidad {
	
	@Id
	private String id;
	@NotBlank(message="Nombre no puede quedar vacío")
	private String nombre;
	private String coorX;
	private String coorY;
	private String altitud;
	@NotBlank(message="Número de reporte no puede quedar vacío")
	private String numReporte;
	private String tipoReporte;
	private Collection<Zona> zonas = new LinkedHashSet<>();

}
