package com.company.todolist.db;

import com.company.todolist.Task;
import com.sun.org.apache.xml.internal.security.Init;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class InFileDataBase implements DataBase {

    private File dbCsv = new File("db.txt");
    private List<Task> tasks = new ArrayList<>();
    private static AtomicInteger count;

    public InFileDataBase() {
        initDB();
        try {
            List<String> lines = Files.readAllLines(dbCsv.toPath());
            count = new AtomicInteger(lines.size());
            for (String task : lines) {
                Task task1 = new Task();
                String[] fields = task.split(",");
                for (String field : fields) {
                    String[] prop = field.split(":");
                    String key = prop[0];
                    String value = prop[1];
                    switch (key) {
                        case "id":
                            int id = Integer.parseInt(value);
                            task1.setId(id);
                            break;
                        case "name":
                            task1.setName(value);
                            break;
                        case "done":
                            boolean bol = Boolean.getBoolean(value);
                            task1.setDone(bol);
                            break;
                    }
                }
                tasks.add(task1);
            }
        } catch (IOException e) {
           System.out.println(e.getMessage());
            e.printStackTrace();
        }


    }

    @Override
    public void save(Task task) {
        task.setId(count.getAndIncrement());
        tasks.add(task);
        String cos = "id:" + task.getId() + ",name:" + task.getName() + ",done:" + task.getDone();
        try {
            Files.write(dbCsv.toPath(), Arrays.asList(cos),StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Collection<Task> getAll() {
        return tasks;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public Task get(int id) {
        return null;
    }

    public void initDB() {
        try {
            dbCsv.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
