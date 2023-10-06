package gis.cloud.pixup.geojsonservice.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import gis.cloud.pixup.geojsonservice.domain.Reserva;
import gis.cloud.pixup.geojsonservice.repository.ReservaRepository;
import gis.cloud.pixup.geojsonservice.service.ReservaService;

@RestController
@RequestMapping(path="api/reservas", produces="application/json")
@CrossOrigin(origins="*")
public class ReservaController {
	
	@Autowired
	private ReservaRepository reservaRepository;
	@Autowired
	private ReservaService reservaService;
	
	@GetMapping
	public List<Reserva> obtenerReservas() {
		return reservaRepository.findAll();
	}
	
	@PostMapping(consumes="application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Reserva crearReserva(@RequestBody Reserva reserva) {
		return reservaRepository.save(reserva);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Reserva> obtenerReservaPorId(@PathVariable("id") String id) {
		Optional<Reserva> reserva = reservaRepository.findById(id);
		if (reserva.isPresent()) {
			return new ResponseEntity<>(reserva.get(), HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	
	@PutMapping(path="{id}", consumes="application/json")
	public ResponseEntity<Reserva> actualizarReserva(
			@PathVariable("id") String id, @RequestBody Reserva reserva) {
		Reserva reservaActualizado = reservaService.actualizarReserva(id, reserva);
		if (reservaActualizado != null) {
			return new ResponseEntity<>(reservaActualizado, HttpStatus.OK) ;
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminarReserva(@PathVariable("id") String id) {
		reservaRepository.deleteById(id);
	}

}
