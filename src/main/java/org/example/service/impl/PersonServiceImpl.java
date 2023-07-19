package org.example.service.impl;

import org.example.dao.PersonDAO;
import org.example.dao.impl.PersonDAOImpl;
import org.example.model.Person;
import org.example.service.PersonService;

import java.util.List;

public class PersonServiceImpl implements PersonService {

    private static final PersonDAO personDAO = new PersonDAOImpl();

    @Override
    public void createNewPerson(String name) {
        personDAO.create(name);
    }

    @Override
    public void findPersonById(int id) {
        Person person = personDAO.findById(id);
        System.out.println(person);
    }

    @Override
    public List<Person> findAllPersons() {
        return personDAO.findAll();
    }

    @Override
    public void updatePerson(int id, String name) {
        personDAO.update(id, name);
    }

    @Override
    public void deleteUser(int id) {
        personDAO.delete(id);
    }
}
