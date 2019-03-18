package com.company.todolist.db;

import com.company.todolist.Task;

import java.util.Collection;

public interface DataBase {

    void save(Task task);

    Collection<Task> getAll();

    boolean delete (int id);

    Task get (int id);
}
