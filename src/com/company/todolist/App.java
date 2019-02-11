package com.company.todolist;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private static Scanner scanner = new Scanner(System.in);
    private List<Task> todolist = new ArrayList<>();

    public static void main(String[] args) {
        App app = new App();
        try {
            List<String> lines = Files.readAllLines(Paths.get("text.txt"));
            for (int i = 1; i <= 3; i++) {
                System.out.println("Enter login: ");
                String loginByUser = scanner.nextLine();
                System.out.println("Enter password: ");
                String passwordByUser = scanner.nextLine();
                if (loginByUser.equals(lines.get(0)) && (passwordByUser.equals(lines.get(1)))) {
                    System.out.println("You managed to log in.");
                    i = 10;
                    app.run();
                } else {
                    int c = 3 - i;
                    System.out.println("Password or login incorrect. Attempts left: " + c);
                }
            }
        } catch (IOException ex) {
            System.out.println("error" + ex);
        }
    }

    private void run() {
        System.out.println("Welcome in your private ToDoList!");
        System.out.println("Write 'help' to display the commands which you can use.");

        Action command = readCommand();

        while (command != null) {

            switch (command) {
                case ADD:
                    addTask();
                    break;
                case REMOVE:
                    removeTask();
                    break;
                case LIST:
                    listTasks();
                    break;
                case COMPLETE:
                    completeTask();
                    break;
                case HELP:
                    printHelp();
                    break;
                case EXIT:
                    System.exit(0);
            }

            command = readCommand();
        }
    }

    private Action readCommand() {
        try {
            return Action.valueOf(scanner.nextLine().toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid command");
            return readCommand();
        }
    }

    private void addTask() {
        String task = scanner.nextLine();
        todolist.add(new Task(task));
    }

    private void listTasks() {
        for (Task task : todolist) {
            System.out.println(task);
        }
    }

    private void completeTask() {
        String word = scanner.nextLine();
        int id = Integer.parseInt(word);
        Task task = todolist.get(id);
        task.setDone(true);
    }

    private void removeTask() {
        String word = scanner.nextLine();
        int id = Integer.parseInt(word);
        todolist.remove(id);
    }

    private void printHelp() {
        for (Action action : Action.values()) {
            System.out.println(action);
        }
    }
}
