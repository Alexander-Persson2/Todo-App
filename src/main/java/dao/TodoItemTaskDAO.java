package dao;

import model.TodoItemTask;

import java.util.List;

public interface TodoItemTaskDAO {
    void persist(TodoItemTask todoItemTask);
    TodoItemTask findById(int id);
    List<TodoItemTask> findAll();
    boolean remove(TodoItemTask todoItemTask);
}
