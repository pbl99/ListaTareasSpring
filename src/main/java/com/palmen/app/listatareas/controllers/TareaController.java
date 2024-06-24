package com.palmen.app.listatareas.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.palmen.app.listatareas.models.entities.Tarea;
import com.palmen.app.listatareas.services.ITareaService;

@Controller
public class TareaController {

	@Autowired
	private ITareaService tareaService;

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

	@PostMapping("/encontrarTareaPorId")
	public String encontrarTareaPorId(Tarea tarea, Model model) {
		Optional<Tarea> tareaEncontrada = tareaService.encontrarTareaPorId(tarea.getId());
		model.addAttribute("tarea", tareaEncontrada.get());
		return "ver-tareas";
	}

	@PostMapping("/encontrarTareas")
	public String encontrarTareas(Model model) {
		List<Tarea> tareas = tareaService.encontrarTareas();
		model.addAttribute("tarea", tareas);
		return "ver-tareas";
	}

	@PostMapping("/eliminarTarea")
	public String eliminarTarea(String titulo) {
		tareaService.eliminarTareaPorTitulo(titulo);
		return "index";
	}

}
