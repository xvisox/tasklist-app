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

    public void setDone() {
        this.done = true;
    }

    @Override
    public String toString() {
        String sens = " ";
        if (done==true) {
            sens = "x";
        }
        return id + ": " + "[" + sens + "] " + name;
    }

    public enum Help {
        add("adds new task to your list", 1), remove("removes task with chosen id from your list", 2), complete("marks the task as finished", 3), list("displays a list of your tasks", 4), exit("exits program", 5);
        private int number;
        private String commands;

        private Help(String s, int i) {
            commands = s;
            number = i;
        }

        public String toString() {
            return number + " " + super.toString() + ": " + commands;
        }

    }
}
