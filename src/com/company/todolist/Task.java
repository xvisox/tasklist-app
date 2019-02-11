package com.company.todolist;

import java.util.concurrent.atomic.AtomicInteger;

public class Task {
    private String name;
    private boolean done;
    private int id;
    private static AtomicInteger count = new AtomicInteger();

    public Task(String name) {
        this.name = name;
        this.id = count.getAndIncrement();
        this.done = false;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public String toString() {
        String sens = " ";
        if (done) {
            sens = "x";
        }
        return id + ": " + "[" + sens + "] " + name;
    }
}
