package model;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class TodoItemTaskTest {

    @Test
    public void testTodoItemTaskCreation() {
        Person creator = new Person(1, "Kent", "Persson", "kent.Persson@example.com");
        TodoItem todoItem = new TodoItem(1, "Test Title", "Test Description", LocalDate.of(2023, 12, 31), false, creator);
        Person assignee = new Person(2, "Marie", "Persson", "Marie.Persson@example.com");

        TodoItemTask todoItemTask = new TodoItemTask(1, todoItem, assignee);

        assertEquals(1, todoItemTask.getId());
        assertTrue(todoItemTask.isAssigned());
        assertEquals(todoItem, todoItemTask.getTodoItem());
        assertEquals(assignee, todoItemTask.getAssignee());
    }

    @Test
    public void testTodoItemTaskSetters() {
        Person creator = new Person(1, "Kent", "Persson", "Kent.Persson@example.com");
        TodoItem todoItem = new TodoItem(1, "Test Title", "Test Description", LocalDate.of(2023, 12, 31), false, creator);
        Person assignee = new Person(2, "Marie", "Persson", "Marie.Persson@example.com");

        TodoItemTask todoItemTask = new TodoItemTask(1, todoItem, assignee);
        todoItemTask.setAssignee(null);

        assertFalse(todoItemTask.isAssigned());
        assertNull(todoItemTask.getAssignee());
    }

    @Test
    public void testTodoItemTaskSummary() {
        Person creator = new Person(1, "Kent", "Persson", "Kent.Persson@example.com");
        TodoItem todoItem = new TodoItem(1, "Test Title", "Test Description", LocalDate.of(2023, 12, 31), false, creator);
        Person assignee = new Person(2, "Marie", "Persson", "Marie.Persson@example.com");

        TodoItemTask todoItemTask = new TodoItemTask(1, todoItem, assignee);
        String expectedSummary = "{id: 1, assigned: true, todoItem: {id: 1, title: Test Title, description: Test Description, deadline: 2023-12-31, done: false, creator: {id: 1, name: Kent Persson, email: Kent.Persson@example.com}}, assignee: {id: 2, name: Marie Persson, email: Marie.Persson@example.com}}";
        assertEquals(expectedSummary, todoItemTask.getSummary());
    }

    @Test
    public void testTodoItemTaskNullTodoItem() {
        Person assignee = new Person(2, "Marie", "Persson", "Marie.Persson@example.com");
        assertThrows(IllegalArgumentException.class, () -> new TodoItemTask(1, null, assignee));
    }
}
