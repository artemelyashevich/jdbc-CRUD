package org.example.dao;

import org.example.model.Person;
import org.example.model.Todo;

import java.util.List;

public interface PersonDAO extends AbstractDAO<Person> {
    void create(String name);

    void update(int id, String name);
}
