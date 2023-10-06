package gis.cloud.pixup.geojsonservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gis.cloud.pixup.geojsonservice.domain.Reserva;
import gis.cloud.pixup.geojsonservice.repository.ReservaRepository;

@Service
public class ReservaServiceImpl implements ReservaService {
	
	@Autowired
	private ReservaRepository reservaRepository;

	@Override
	public Reserva actualizarReserva(String id, Reserva reserva) {
		Optional<Reserva> reservaExistente = reservaRepository.findById(id);
		if (reservaExistente.isPresent()) {
			Reserva reservaActualizar = reservaExistente.get();
			reservaActualizar.setNombre(reserva.getNombre());
			reservaRepository.save(reservaActualizar);
			return reservaActualizar;
		}
		return null;
	}

}
