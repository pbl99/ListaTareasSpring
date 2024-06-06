package com.palmen.app.listatareas.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.palmen.app.listatareas.models.entities.Tarea;

@Repository
public interface TareaRepository extends JpaRepository<Tarea, Integer> {

	Optional<Tarea> findByTitulo(String titulo);
}
