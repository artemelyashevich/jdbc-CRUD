package org.example.dao;

import org.example.model.Todo;

import java.util.List;

public interface TodoDAO extends AbstractDAO<Todo> {
    List<Todo> findAllTodoByPersonId(int id);

    void create(String text, int person_id);

    void update(int id, String text);
}
