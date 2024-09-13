package dao;

import model.TodoItemTask;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CollectionTodoItemTaskDAO implements TodoItemTaskDAO {
    private List<TodoItemTask> todoItemTasks = new ArrayList<>();

    @Override
    public void persist(TodoItemTask todoItemTask) {
        todoItemTasks.add(todoItemTask);
    }

    @Override
    public TodoItemTask findById(int id) {
        Optional<TodoItemTask> result = todoItemTasks.stream()
                .filter(task -> task.getId() == id)
                .findFirst();
        return result.orElse(null);
    }

    @Override
    public List<TodoItemTask> findAll() {
        return new ArrayList<>(todoItemTasks);
    }

    @Override
    public boolean remove(TodoItemTask todoItemTask) {
        return todoItemTasks.remove(todoItemTask);
    }
}
