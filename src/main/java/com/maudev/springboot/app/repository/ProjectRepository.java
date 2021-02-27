package com.maudev.springboot.app.repository;

import java.io.Serializable;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.maudev.springboot.app.models.Project;

@Repository("projectRepository")
public interface ProjectRepository extends MongoRepository<Project, Serializable> {
	// DENTRO DE ESTE BLOQUE DE CODIGO VOY A HACER LAS CONSULTAS
	// QUE NECESITE CONTRA MONGO DB

	// internamente Actua como una Querry de consulta
	// Busca en base de datos un producto por medio del ID
	Project findById(String id);
	// Elimina en base de datos un producto por medio del ID
	Project deleteById(String id);

}
