package gis.cloud.pixup.geojsonservice.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
		info = @Info(
			version = "v1",
			title = "Pixup GeoJSON Microservice Endpoints", 
			description = "Definición de los Endpoints de "
					+ "GeoJSON Service para el sistema Pixup", 
			contact = @Contact(
				name = "GIS", 
				url = "https://www.interactivos.com.mx/", 
			email = "jlvillarreal.benitez@gmail.com.mx")))
public class OpenApiConfig {

}
