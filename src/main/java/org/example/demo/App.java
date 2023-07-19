package org.example.demo;

import org.example.service.DBManager;
import org.example.service.impl.DBManagerImpl;
import org.example.utils.Information;

public class App {

    public static DBManager dbManager = new DBManagerImpl();
    public static Information information = new Information();

    public static void main(String[] args) {
        dbManager.createTables();
        information.printAllPersons();
        information.printAllTodos();
        information.printInfoPersonById(1);
        information.printTodoByPersonId(2);
    }
}
