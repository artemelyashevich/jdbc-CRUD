package org.example.service;

import org.example.model.Person;

import java.util.List;

public interface PersonService {
    void createNewPerson(String name);

    void findPersonById(int id);

    List<Person> findAllPersons();

    void updatePerson(int id, String name);

    void deleteUser(int id);
}

