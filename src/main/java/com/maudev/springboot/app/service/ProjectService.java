package com.maudev.springboot.app.service;

import java.util.List;

import com.maudev.springboot.app.models.Project;

public interface ProjectService {

	// metodo interrface para poder utilizar tanto en Service implementacion
	// Como tambien en el Controller
	public abstract Project IdProject(String idProject);

	// Guarda un proyecto
	public abstract Project save(Project entity);

	// Obtiene Toda la Lista de proyectos existente en la base de datos
	public abstract List<Project> findAll();

	// Modifica los datos de 1 proyecto
	public abstract Project update(Project entity);
	
	//Elilmino 1 proyecto 
	public abstract Project deleteById(String idProject);
}
