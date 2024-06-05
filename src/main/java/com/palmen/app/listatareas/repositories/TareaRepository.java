package com.palmen.app.listatareas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.palmen.app.listatareas.models.entities.Tarea;

public interface TareaRepository extends JpaRepository<Tarea, Long>{

}
