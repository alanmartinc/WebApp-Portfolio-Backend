package com.maudev.springboot.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.maudev.springboot.app.models.Project;
import com.maudev.springboot.app.service.ProjectService;

@RestController
@CrossOrigin
public class ProjectController {

	@Autowired
	private ProjectService projectService;

	// Metodo POST para crear un nuevo Proyecto
	// Persisto o Guardo en la BBDD
	@PostMapping(value = "/project", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Project> save(@RequestBody Project project) {

		Project projectData = projectService.save(project);

		// Si el servicio me devolvio un resultado exitoso o 200
		// devuelvo al FrontEnd todos los datos del Proyecto Creado
		return ResponseEntity.ok(projectData);

	}

	// Metodo GET para obtener toda la lista de Proyectos
	// existentes en nuestra base de datos
	@GetMapping(value = "/projects", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> findAll() {
		// Instancio un nueva lista de Proyectos
		List<Project> projects = new ArrayList<Project>();

		// llamo al servicio creado y obtengo la lista
		projects = projectService.findAll();

		// Si el servicio me devolvio un resultado exitoso o 200
		// devuelvo al FrontEnd toda la lista de Proyectos
		return ResponseEntity.ok(projects);
	}

	// Metodo GET para obtener los datos de 1 idProject por su ID
	@GetMapping(value = "/projects/{idProject}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Project> findByIdProject(@PathVariable String idProject) {

		// Instancio un nuevo objeto Proyecto
		Project project = new Project();

		// llamo al servicio creado y le paso por parametro el idProject
		project = projectService.IdProject(idProject);

		// Si el servicio me devolvio un resultado exitoso o 200
		// devuelvo al FrontEnd todos los datos del Proyecto solicitado
		return ResponseEntity.ok(project);
	}

	// Metodo PUT para modificar un producto existente
	// Persisto y actualizo en la BBDD
	@PutMapping(value = "/project", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Project> updateProject(@RequestBody Project project) {

		// llamo al servicio creado y le paso los nuevos datos
		// NO TENGO QUE MODIFICAR EL ID, tiene que ser el mismo
		Project projectData = projectService.save(project);

		// Si el servicio me devolvio un resultado exitoso o 200
		// devuelvo al FrontEnd todos los datos del Producto actualizado
		return ResponseEntity.ok(projectData);

	}

	// Metodo DELETE para eliminar los datos de 1 Proyecto por su ID
	@DeleteMapping(value = "/project/{idProject}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Project> deleteFindByIdProject(@PathVariable String idProject) {

		// Instancio un nuevo objeto Proyecto
		Project project = new Project();

		// llamor al servicio creado y le paso por parametro el idProject
		project = projectService.deleteById(idProject);

		// Si el servicio me devolvio un resultado exitoso o 200
		// Elimino todos los datos del Producto solicitado
		return ResponseEntity.ok(project);
	}

}
