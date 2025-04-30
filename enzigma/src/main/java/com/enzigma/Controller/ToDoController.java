package com.enzigma.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.enzigma.Model.ToDo;
import com.enzigma.Service.ToDoService;

@RestController
public class ToDoController {
	@Autowired
	private ToDoService toDoService;
	
	@PostMapping("/saveTask")
	public ResponseEntity<?> saveTask(@RequestBody ToDo todo){
		return new ResponseEntity<>(toDoService.saveTask(todo), HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	public ResponseEntity<?> getAllTask() {
		return new ResponseEntity<>(toDoService.getAllTask(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getTaskById(@PathVariable Integer id) {
		return new ResponseEntity<>(toDoService.getTaskById(id), HttpStatus.OK);
	}
	
	
	@DeleteMapping("/deleteTask/{id}")
	public ResponseEntity<?> deleteTask(@PathVariable Integer id) {
	    String message = toDoService.deleteTask(id);
	    return new ResponseEntity<>(message, HttpStatus.OK);
	}

	
	@PostMapping("/editTask/{id}")
	public ResponseEntity<?> editProduct(@RequestBody ToDo todo, @PathVariable Integer id){
		return new ResponseEntity<>(toDoService.editTask(todo, id), HttpStatus.CREATED);
	}
}
