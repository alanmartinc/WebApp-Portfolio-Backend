package com.maudev.springboot.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maudev.springboot.app.models.Project;
import com.maudev.springboot.app.repository.ProjectRepository;
import com.maudev.springboot.app.service.ProjectService;

@Service("productoService")
public class ProjectServiceImpl implements ProjectService {

	// Inyecto el Repository
	// Para usar sus funciones e implementar
	// en la logica de los sevicios

	@Autowired
	ProjectRepository projectRepository;

	// con este contrato o metodo de mi capa actual
	// creo la logica para poder hacer la consulta con mi base de datos monngo

	@Override
	public Project IdProject(String idProject) {
		// Instancio un nuevo objeto proyecto
		Project project = null;

		// Envolvemos en una validacion
		// para que en caso falle por algun motivo esa consulta
		// me imprima en la consola en que parte fallo mi app
		try {

			project = projectRepository.findById(idProject);

		} catch (Exception e) {

			e.printStackTrace();
		}

		// En caso de exito devuelvo todos los datos que contiene Proyecto
		return project;

	}

	@Override
	public Project save(Project entity) {
		// Instancio un nuevo objeto Proyecto
		Project producto = null;
		
		
		// Envolvemos en una validacion
		// para que en caso falle por algun motivo esa consulta
		// me imprima en la consola en que parte fallo mi app
		try {

			producto = projectRepository.save(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// En caso de exito devuelvo todos los datos que contiene Proyecto
		return producto;
	}

	@Override
	public List<Project> findAll() {
		// Instancio una Lista de Proyectos 
		List<Project> lstProjects = new ArrayList<Project>();
		
		// Envolvemos en una validacion
		// para que en caso falle por algun motivo esa consulta
		// me imprima en la consola en que parte fallo mi app

		try {
			lstProjects = projectRepository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// En caso de exito devuelvo Lista de todos Los Proyectos 
		return lstProjects;
	}

	@Override
	public Project update(Project entity) {
		// Instancio un nuevo objeto Proyecto
		Project project = null;
		
		
		// Envolvemos en una validacion
		// para que en caso falle por algun motivo esa consulta
		// me imprima en la consola en que parte fallo mi app

		try {

			project = projectRepository.save(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// En caso de exito devuelvo todos los datos que contiene Proyecto
		return project;
	}

	@Override
	public Project deleteById(String idProject) {
		// Instancio un nuevo objeto producto
		Project project = null;

		// Envolvemos en una validacion
		// para que en caso falle por algun motivo esa consulta
		// me imprima en la consola en que parte fallo mi app
		try {

			project = projectRepository.deleteById(idProject);

		} catch (Exception e) {

			e.printStackTrace();
		}

		// En caso de exito devuelvo todos los datos que contiene Proyecto
		return project;
	}

}
