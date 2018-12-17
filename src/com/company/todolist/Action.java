package com.company.todolist;

public enum Action {
    ADD("adds new task to your list", 1),
    REMOVE("removes task with chosen id from your list", 2),
    COMPLETE("marks the task as finished", 3),
    LIST("displays a list of your tasks", 4),
    EXIT("exits program", 5),
    HELP("prints this help", 6);

    private int number;
    private String description;

    Action(String s, int i) {
        description = s;
        number = i;
    }

    public String toString() {
        return number + " " + super.toString() + ": " + description;
    }

}
