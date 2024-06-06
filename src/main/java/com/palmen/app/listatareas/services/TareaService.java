package com.palmen.app.listatareas.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.palmen.app.listatareas.models.entities.Tarea;
import com.palmen.app.listatareas.repositories.TareaRepository;

@Service
public class TareaService {

	@Autowired
	private TareaRepository tareaRepository;

	@Transactional
	public Tarea crearTarea(Tarea tarea) {
		return tareaRepository.save(tarea);
	}

	@Transactional
	public void actualizarTarea(Integer id, String titulo, String descripcion) {
		Optional<Tarea> optionalTarea = tareaRepository.findById(id);

		// Si la tarea existe
		if (optionalTarea.isPresent()) {
			Tarea tarea = optionalTarea.get();
			tarea.setTitulo(titulo);
			tarea.setDescripcion(descripcion);
			tareaRepository.save(tarea);
		} else {
			// Manejar el caso en que la tarea no existe
			throw new IllegalArgumentException("Tarea no encontrada con id: " + id);
		}
	}

	@Transactional(readOnly = true)
	public Optional<Tarea> encontrarTareaPorId(Integer id) {
		return tareaRepository.findById(id);
	}

	@Transactional
	public void eliminarTareaPorTitulo(String titulo) {
		Optional<Tarea> tareaOptional = tareaRepository.findByTitulo(titulo);
		tareaOptional.ifPresent(tareaRepository::delete);
	}
}
