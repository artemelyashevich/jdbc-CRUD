package org.example.service.impl;

import org.example.dao.TodoDAO;
import org.example.dao.impl.TodoDAOImpl;
import org.example.model.Todo;
import org.example.service.TodoService;

import java.util.List;

public class TodoServiceImpl implements TodoService {

    private final static TodoDAO todoDAO = new TodoDAOImpl();

    @Override
    public void findTodoByPerson(int id) {
        List<Todo> todos = todoDAO.findAllTodoByPersonId(id);
        for (Todo todo : todos) {
            System.out.println(todo);
        }
    }

    @Override
    public void findAllTodos() {
        List<Todo> todos = todoDAO.findAll();
        for (Todo todo : todos) {
            System.out.println(todo);
        }
    }
}
