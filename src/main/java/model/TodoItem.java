package model;

import java.time.LocalDate;
import java.util.Objects;

public class TodoItem {
    private int todo_id;
    private String title;
    private String description;
    private LocalDate deadline;
    private boolean done;
    private Person assignee;

    public TodoItem(int todo_id, String title, String description, LocalDate deadline, boolean done, Person assignee) {
        if (title == null || title.isEmpty() || deadline == null) {
            throw new IllegalArgumentException("Fields cannot be null or empty");
        }
        this.todo_id = todo_id;
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.done = done;
        this.assignee = assignee;
    }

    public int getTodo_id() {
        return todo_id;
    }

    public void setTodo_id(int todo_id) {
        this.todo_id = todo_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Title cannot be null or empty");
        }
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        if (deadline == null) {
            throw new IllegalArgumentException("Deadline cannot be null");
        }
        this.deadline = deadline;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public Person getAssignee() {
        return assignee;
    }

    public void setAssignee(Person assignee) {
        this.assignee = assignee;
    }

    public boolean isOverdue() {
        return !done && LocalDate.now().isAfter(deadline);
    }

    @Override
    public String toString() {
        return "TodoItem{" +
                "todo_id=" + todo_id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", deadline=" + deadline +
                ", done=" + done +
                ", assignee=" + (assignee != null ? assignee.getId() : null) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TodoItem todoItem = (TodoItem) o;
        return todo_id == todoItem.todo_id &&
                done == todoItem.done &&
                assignee == todoItem.assignee &&
                Objects.equals(title, todoItem.title) &&
                Objects.equals(description, todoItem.description) &&
                Objects.equals(deadline, todoItem.deadline);
    }

    @Override
    public int hashCode() {
        return Objects.hash(todo_id, title, description, deadline, done, assignee);
    }
}

