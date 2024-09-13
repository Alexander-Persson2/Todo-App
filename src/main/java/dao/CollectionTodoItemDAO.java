package dao;

import model.TodoItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CollectionTodoItemDAO implements TodoItemDAO {
    private List<TodoItem> todoItems = new ArrayList<>();

    @Override
    public void persist(TodoItem todoItem) {
        todoItems.add(todoItem);
    }

    @Override
    public TodoItem findById(int id) {
        Optional<TodoItem> result = todoItems.stream()
                .filter(item -> item.getTodo_id() == id)
                .findFirst();
        return result.orElse(null);
    }

    @Override
    public List<TodoItem> findAll() {
        return new ArrayList<>(todoItems);
    }

    @Override
    public boolean remove(TodoItem todoItem) {
        return todoItems.remove(todoItem);
    }
}
