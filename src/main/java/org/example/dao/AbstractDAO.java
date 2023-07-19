package org.example.dao;

import java.util.List;

public interface AbstractDAO<T> {
    void delete(int id);

    T findById(int id);

    List<T> findAll();
}
