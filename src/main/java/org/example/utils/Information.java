package org.example.utils;

import org.example.service.PersonService;
import org.example.service.TodoService;
import org.example.service.impl.PersonServiceImpl;
import org.example.service.impl.TodoServiceImpl;

public class Information {
    private final PersonService personService = new PersonServiceImpl();
    private final TodoService todoService = new TodoServiceImpl();

    public void printAllPersons() {
        personService.findAllPersons();
    }

    public void printAllTodos() {
        todoService.findAllTodos();
    }

    public void printInfoPersonById(int id) {
        personService.findPersonById(id);
    }

    public void printTodoByPersonId(int id) {
        todoService.findTodoByPerson(id);
    }
}
