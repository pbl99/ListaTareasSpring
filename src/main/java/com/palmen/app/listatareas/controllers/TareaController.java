package com.palmen.app.listatareas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.palmen.app.listatareas.models.entities.Tarea;
import com.palmen.app.listatareas.services.TareaService;

@Controller
public class TareaController {

	@Autowired
	private TareaService tareaService;

	@GetMapping("/")
	public String tareas() {
		return "index";
	}

	@PostMapping("/crearTarea")
	public String crearTarea(Tarea tarea) {
		tareaService.crearTarea(tarea);
		return "index";
	}

	@PostMapping("/actualizarTarea")
	public String actualizarTarea(Tarea tarea) {
		tareaService.actualizarTarea(tarea.getId(), tarea.getTitulo(), tarea.getDescripcion());
		return "index";
	}

	@PostMapping("/encontrarTarea")
	public String encontrarTarea(Tarea tarea) {
		tareaService.encontrarTareaPorId(tarea.getId());
		return "index";
	}

	@PostMapping("/eliminarTarea")
	public String eliminarTarea(String titulo) {
		tareaService.eliminarTareaPorTitulo(titulo);
		return "index";
	}

}
