package com.palmen.app.listatareas.services;

import java.util.List;
import java.util.Optional;

import com.palmen.app.listatareas.models.entities.Tarea;

public interface ITareaService {
	Tarea crearTarea(Tarea tarea);

	void actualizarTarea(Integer id, String titulo, String descripcion);

	Optional<Tarea> encontrarTareaPorId(Integer id);

	List<Tarea> encontrarTareas();

	void eliminarTareaPorTitulo(String titulo);

}
