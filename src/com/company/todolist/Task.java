package com.company.todolist;

public class Task {
    private String name;
    private boolean done;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Task(String name) {
        this.name = name;
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
