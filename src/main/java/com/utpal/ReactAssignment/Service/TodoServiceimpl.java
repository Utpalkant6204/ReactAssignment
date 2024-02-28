package com.utpal.ReactAssignment.Service;

import com.utpal.ReactAssignment.Entity.Todos;
import com.utpal.ReactAssignment.Repository.TodosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TodoServiceimpl implements TodoService {

    @Autowired
    private TodosRepository todosRepository;


    @Override
    public Todos saveTodos(Todos todos) {
        return todosRepository.save(todos);
    }

    @Override
    public List<Todos> getTodos() {
        return todosRepository.findAll();
    }

    @Override
    public Todos getTodobyId(Long id) {
        Optional<Todos> Todos1 = todosRepository.findById(id);
        if(Todos1.isPresent()){
            return Todos1.get();
        }
        return null;
    }

    @Override
    public Todos updatebyId(Long id, Todos todo) {
        Todos todoExist =todosRepository.findById(id).get();

        if(Objects.nonNull(todoExist.getData()) && !"".equalsIgnoreCase(todo.getData())){
            todoExist.setData(todo.getData());
        }

        return todosRepository.save(todoExist);
    }

    @Override
    public boolean deletebyId(Long id) {
        todosRepository.deleteById(id);
        Optional<Todos> Todos1 = todosRepository.findById(id);
        if(Todos1.isPresent()){
            return false;
        }
        return true;
    }
}
