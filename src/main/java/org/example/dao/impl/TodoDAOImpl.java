package org.example.dao.impl;

import org.example.dao.TodoDAO;
import org.example.database.DBUtils;
import org.example.model.Todo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TodoDAOImpl implements TodoDAO  {

    private static final Connection connection = new DBUtils().getConnection();

    @Override
    public List<Todo> findAllTodoByPersonId(int id) {
        List<Todo> todos = new ArrayList<>();
        Statement statement;
        try {
            String query = String.format("SELECT * FROM todo WHERE person_id=%s", id);
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                todos.add(new Todo(resultSet.getString("text"), resultSet.getInt("person_id"), resultSet.getInt("id")));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return todos;
    }

    @Override
    public List<Todo> findAll() {
        List<Todo> todos = new ArrayList<>();
        Statement statement;
        try {
            String query = "SELECT * FROM todo";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                todos.add(new Todo(resultSet.getString("text"), resultSet.getInt("person_id"), resultSet.getInt("id")));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return todos;
    }

    @Override
    public void create(String text, int person_id) {
        Statement statement;
        try {
            String query = String.format("INSERT INTO todo (text, person_id) VALUES('%s', '%s');", text, person_id);
            statement = connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("Todo created!");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void delete(int id) {
        Statement statement;
        try {
            String query = String.format("DELETE FROM todo WHERE id=%s", id);
            statement = connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("Todo deleted!");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void update(int id, String text) {
        Statement statement;
        try {
            String query = String.format("UPDATE todo SET text='%s' WHERE id=%s;", text, id);
            statement = connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("Todo updated!");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public Todo findById(int id) {
        return null;
    }
}
