package gis.cloud.pixup.geojsonservice.dto;

import gis.cloud.pixup.geojsonservice.domain.Zona;
import gis.cloud.pixup.geojsonservice.domain.Localidad;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RegistroLocalidadRequest {
	
	@NotNull
	@Valid
	private Localidad localidad;
	@NotNull
	@Valid
	private Zona zona;

}
