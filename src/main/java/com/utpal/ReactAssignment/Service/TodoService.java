package com.utpal.ReactAssignment.Service;

import com.utpal.ReactAssignment.Entity.Todos;

import java.util.List;

public interface TodoService {
    public Todos saveTodos(Todos todos);

    public List<Todos> getTodos();

    public Todos getTodobyId(Long id);

    public Todos updatebyId(Long id, Todos todo);

    public boolean deletebyId(Long id);
}
