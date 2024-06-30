package se.lexicon;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class TodoItemTest {

    @Test
    public void testTodoItemCreation() {
        Person creator = new Person(1, "Kent", "Persson", "kent.Persson@example.com");
        TodoItem todoItem = new TodoItem(1, "Test Title", "Test Description", LocalDate.of(2023, 12, 31), false, creator);

        assertEquals(1, todoItem.getId());
        assertEquals("Test Title", todoItem.getTitle());
        assertEquals("Test Description", todoItem.getDescription());
        assertEquals(LocalDate.of(2023, 12, 31), todoItem.getDeadline());
        assertFalse(todoItem.isDone());
        assertEquals(creator, todoItem.getCreator());
    }

    @Test
    public void testTodoItemSetters() {
        Person creator = new Person(1, "Kent", "Persson", "kent.Persson@example.com");
        TodoItem todoItem = new TodoItem(1, "Test Title", "Test Description", LocalDate.of(2023, 12, 31), false, creator);

        todoItem.setTitle("Updated Title");
        todoItem.setDescription("Updated Description");
        todoItem.setDeadline(LocalDate.of(2024, 1, 1));
        todoItem.setDone(true);

        assertEquals("Updated Title", todoItem.getTitle());
        assertEquals("Updated Description", todoItem.getDescription());
        assertEquals(LocalDate.of(2024, 1, 1), todoItem.getDeadline());
        assertTrue(todoItem.isDone());
    }

    @Test
    public void testTodoItemSummary() {
        Person creator = new Person(1, "Kent", "Persson", "Kent.Persson@example.com");
        TodoItem todoItem = new TodoItem(1, "Test Title", "Test Description", LocalDate.of(2023, 12, 31), false, creator);
        String expectedSummary = "{id: 1, title: Test Title, description: Test Description, deadline: 2023-12-31, done: false, creator: {id: 1, name: Kent Persson, email: Kent.Persson@example.com}}";
        assertEquals(expectedSummary, todoItem.getSummary());
    }

    @Test
    public void testTodoItemOverdue() {
        Person creator = new Person(1, "Kent", "Persson", "Kent.Persson@example.com");
        TodoItem todoItem = new TodoItem(1, "Test Title", "Test Description", LocalDate.now().minusDays(1), false, creator);
        assertTrue(todoItem.isOverdue());

        todoItem.setDone(true);
        assertFalse(todoItem.isOverdue());
    }

    @Test
    public void testTodoItemNullFields() {
        Person creator = new Person(1, "Kent", "Persson", "Kent.Persson@example.com");
        assertThrows(IllegalArgumentException.class, () -> new TodoItem(1, null, "Test Description", LocalDate.of(2023, 12, 31), false, creator));
        assertThrows(IllegalArgumentException.class, () -> new TodoItem(1, "", "Test Description", LocalDate.of(2023, 12, 31), false, creator));
        assertThrows(IllegalArgumentException.class, () -> new TodoItem(1, "Test Title", "Test Description", null, false, creator));
        assertThrows(IllegalArgumentException.class, () -> new TodoItem(1, "Test Title", "Test Description", LocalDate.of(2023, 12, 31), false, null));
    }
}

