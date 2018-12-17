package com.company.todolist;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class App {
    static Scanner sc = new Scanner(System.in);
    List<Task> todolist = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        App app = new App();
        try {
            List<String> lines = Files.readAllLines(Paths.get("C:/Program Files (x86)/Programowanie/text.txt"));
            for (int i = 1; i <= 3; i++) {
                System.out.println("Enter login: ");
                String loginByUser = sc.nextLine();
                System.out.println("Enter password: ");
                String passwordByUser = sc.nextLine();
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
            System.out.println("error");
        }
    }

    public void run() {
        System.out.println("Welcome in your private ToDoList!");
        System.out.println("Write 'help' to display the commands which you can use.");
        String command = sc.nextLine();
        while (!command.equals("exit")) {
            switch (command) {
                case "add":
                    addTask();
                    break;
                case "remove":
                    removeTask();
                    break;
                case "list":
                    listTasks();
                    break;
                case "complete":
                    completeTask();
                    break;
                case "help":
                    helpTask();
                    break;
                default:
                    System.out.println("Invalid command");
                    break;
            }
            command = sc.nextLine();
        }
    }

    private void addTask() {
        String task = sc.nextLine();
        todolist.add(new Task(task));
    }

    private void listTasks() {
        for (Task task : todolist) {
            System.out.println(task);
        }
    }

    private void completeTask() {
        String word = sc.nextLine();
        int id = Integer.parseInt(word);
        Task task = todolist.get(id);
        task.setDone();
    }

    private void removeTask() {
        String word = sc.nextLine();
        int id = Integer.parseInt(word);
        todolist.remove(id);
    }

    private void helpTask() {
        for (Task.Help dnm : Task.Help.values()) {
            System.out.println(dnm);
        }
    }
}
