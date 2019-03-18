package com.company.todolist.db;

import com.company.todolist.Task;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class InMemoryDataBase implements  DataBase{
    private Map <Integer,Task> todolist = new HashMap<>();

    private static final AtomicInteger count = new AtomicInteger();

    @Override
    public void save(Task task) {
        task.setId(count.getAndIncrement());
        todolist.put(task.getId(), task);
    }

    @Override
    public Collection<Task> getAll() {
        return todolist.values();
    }

    @Override
    public boolean delete(int id) {
        Task remove = todolist.remove(id);
        return remove != null;
    }

    @Override
    public Task get(int id) {
        return todolist.get(id);
    }
}
