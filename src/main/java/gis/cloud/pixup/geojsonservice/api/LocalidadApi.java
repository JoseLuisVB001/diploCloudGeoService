package gis.cloud.pixup.geojsonservice.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import gis.cloud.pixup.geojsonservice.domain.Localidad;
import gis.cloud.pixup.geojsonservice.dto.RegistroLocalidadRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@RequestMapping(path="api/localidades", produces="application/json")
@CrossOrigin(origins="*")
@Tag(name="localidad", description="API del Recurso Localidad")
public interface LocalidadApi {
	
	@Operation(summary = "Registrar Localidad")
	@ApiResponses(value = { 
	  @ApiResponse(responseCode = "201", 
		description = "Localidad Creada Exitosamente", 
	    content = { 
	    	@Content(mediaType="application/json", 
	    	schema = @Schema(implementation=Localidad.class)) }),
	  @ApiResponse(responseCode = "409", 
	  	description="Ya existe una localidad con el número de reporte especificado", 
	    content = @Content) })
	@PostMapping(path="registro", consumes="application/json")
	@ResponseStatus(HttpStatus.CREATED)
	Localidad registrarLocalidad(
		@NotNull @Valid @RequestBody RegistroLocalidadRequest request);

}
