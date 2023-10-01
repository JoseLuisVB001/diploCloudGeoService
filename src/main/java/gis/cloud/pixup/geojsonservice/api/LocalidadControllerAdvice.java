package gis.cloud.pixup.geojsonservice.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import gis.cloud.pixup.geojsonservice.domain.LocalidadAlreadyExistsException;

@RestControllerAdvice
public class LocalidadControllerAdvice {
	
	@ExceptionHandler(LocalidadAlreadyExistsException.class)
	@ResponseStatus(HttpStatus.CONFLICT)
	private String localidadAlreadyExistsHandler(
			LocalidadAlreadyExistsException exception) {
		return exception.getMessage();
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	private String validatorHandler(
			MethodArgumentNotValidException exception) {
		return "Existen errores de validacion en el payload";
	}

}
