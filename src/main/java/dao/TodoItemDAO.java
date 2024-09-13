package dao;

import model.TodoItem;

import java.util.List;

public interface TodoItemDAO {
    void persist(TodoItem todoItem);
    TodoItem findById(int id);
    List<TodoItem> findAll();
    boolean remove(TodoItem todoItem);
}
