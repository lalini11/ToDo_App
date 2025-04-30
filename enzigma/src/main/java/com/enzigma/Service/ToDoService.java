package com.enzigma.Service;

import java.util.List;

import com.enzigma.Model.ToDo;

public interface ToDoService {
	
	public ToDo saveTask(ToDo todo);
	
	public List<ToDo> getAllTask();
	
	public ToDo getTaskById(Integer id);
	
	public String deleteTask(Integer id);
	
	public ToDo editTask(ToDo todo, Integer id);

}
