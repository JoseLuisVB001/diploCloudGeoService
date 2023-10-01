package gis.cloud.pixup.geojsonservice.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Zona {
	
	@NotBlank(message="Tipo de zona no puede quedar vacío")
	private String tipo;
	@NotBlank(message="La cantidad de zonas de un tipo no puede quedar vacía")
	@Size(min=1, max=30, message="La cantidad de zonas de un tipo debe contener entre {min} y {max}")
	private String cantidad;
	private String numero;

}
