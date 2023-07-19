package org.example.dao.impl;

import org.example.dao.PersonDAO;
import org.example.database.DBUtils;
import org.example.model.Person;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PersonDAOImpl implements PersonDAO {

    private static final Connection connection = new DBUtils().getConnection();

    @Override
    public void create(String name) {
        Statement statement;
        try {
            String query = String.format("INSERT INTO person (name) VALUES('%s');", name);
            statement = connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("Person created!");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public Person findById(int id) {
        Statement statement;
        ResultSet resultSet;
        try {
            String query = String.format("SELECT * FROM person WHERE id=%s", id);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                return new Person(resultSet.getString("name"), resultSet.getInt("id"));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public void update(int id, String name) {
        Statement statement;
        try {
            String query = String.format("UPDATE person SET name='%s' WHERE id=%s;", name, id);
            statement = connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("Person updated!");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void delete(int id) {
        Statement statement;
        try {
            String query = String.format("DELETE FROM person WHERE id=%s", id);
            statement = connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("Person deleted!");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public List<Person> findAll() {
        List<Person> persons = new ArrayList<>();
        Statement statement;
        try {
            String query = "SELECT * FROM person";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                persons.add(new Person(resultSet.getString("name"), resultSet.getInt("id")));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return persons;
    }
}
