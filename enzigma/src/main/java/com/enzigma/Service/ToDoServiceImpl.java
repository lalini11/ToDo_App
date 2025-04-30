package com.enzigma.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enzigma.Model.ToDo;
import com.enzigma.Repository.ToDoRepository;

@Service
public class ToDoServiceImpl implements ToDoService {

	@Autowired
	private ToDoRepository toDoRepo;
	
	@Override
	public ToDo saveTask(ToDo todo) {
		return toDoRepo.save(todo);
	}

	@Override
	public List<ToDo> getAllTask() {
		return toDoRepo.findAll();
	}

	@Override
	public ToDo getTaskById(Integer id) {
		return toDoRepo.findById(id)
		        .orElseThrow(() -> new RuntimeException("Task not found with id: " + id));
	}

	@Override
	public String deleteTask(Integer id) {
		 ToDo todo = toDoRepo.findById(id)
			        .orElseThrow(() -> new RuntimeException("Task not found with ID: " + id));
			    
			    toDoRepo.delete(todo);
			    return "Product Deleted Successfully";
	}

	@Override
	public ToDo editTask(ToDo todo, Integer id) {
		ToDo oldTask = toDoRepo.findById(id).get();
		
		oldTask.setDate(todo.getDate());
		oldTask.setTask(todo.getTask());
		oldTask.setDescription(todo.getDescription());
		oldTask.setStatus(todo.getStatus());
		return toDoRepo.save(oldTask);
	}

}
