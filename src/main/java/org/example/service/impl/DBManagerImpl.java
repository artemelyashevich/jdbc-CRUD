package org.example.service.impl;

import org.example.database.DBUtils;
import org.example.service.DBManager;

import java.sql.*;

public class DBManagerImpl implements DBManager {

    private static final DBUtils dbUtils = new DBUtils();
    private static final Connection connection = dbUtils.getConnection();

    public void createTables() {
        try {
            if (!dbUtils.checkTables(connection)) {
                creteTablePerson();
                createTableTodo();
                generateDataPerson();
                generateDataTodo();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void dropTables() {
        Statement statement;
        try {
            String query1 = "DROP TABLE todo";
            String query2 = "DROP TABLE person";
            statement = connection.createStatement();
            statement.executeUpdate(query1);
            statement.executeUpdate(query2);
            System.out.println("Tables deleted!");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private static void creteTablePerson() {
        Statement statement;
        try {
            String query = "CREATE TABLE person (id SERIAL, name varchar(200), primary key(id));";
            statement = connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("Table 'person' created!");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private static void createTableTodo() {
        Statement statement;
        try {
            String query = "CREATE TABLE todo (id SERIAL, text text, person_id INT, primary key(id), FOREIGN KEY (person_id) REFERENCES person(id));";
            statement = connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("Table 'todo created!");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private static void generateDataPerson() {
        Statement statement;
        try {
            String query1 = "INSERT INTO person (name) VALUES('user1');";
            String query2 = "INSERT INTO person (name) VALUES('user2');";
            String query3 = "INSERT INTO person (name) VALUES('user3');";
            statement = connection.createStatement();
            statement.executeUpdate(query1);
            statement.executeUpdate(query2);
            statement.executeUpdate(query3);
            System.out.println("Fake users added!");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private static void generateDataTodo() {
        Statement statement;
        try {
            String query1 = "INSERT INTO todo (text, person_id) VALUES('todo 1', 2);";
            String query2 = "INSERT INTO todo (text, person_id) VALUES('todo 2', 3);";
            String query3 = "INSERT INTO todo (text, person_id) VALUES('todo 3', 2);";
            statement = connection.createStatement();
            statement.executeUpdate(query1);
            statement.executeUpdate(query2);
            statement.executeUpdate(query3);
            System.out.println("Fake todos added!");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
