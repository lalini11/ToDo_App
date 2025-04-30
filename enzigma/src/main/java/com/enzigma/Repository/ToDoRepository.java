package com.enzigma.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enzigma.Model.ToDo;

public interface ToDoRepository extends JpaRepository<ToDo, Integer> {

}
