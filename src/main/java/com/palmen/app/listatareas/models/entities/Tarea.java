package com.palmen.app.listatareas.models.entities;

import jakarta.persistence.Entity;

@Entity
public class Tarea {

	private int id;
	private String titulo;
	private String descripcion;

	public Tarea() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
