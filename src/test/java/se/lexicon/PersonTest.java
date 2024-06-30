package se.lexicon;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {

    @Test
    public void testPersonCreation() {
        Person person = new Person(1, "Kent", "Persson", "Kent.Persson@example.com");
        assertEquals(1, person.getId());
        assertEquals("Kent", person.getFirstName());
        assertEquals("Persson", person.getLastName());
        assertEquals("Kent.Persson@example.com", person.getEmail());
    }

    @Test
    public void testPersonSetters() {
        Person person = new Person(1, "Kent", "Persson", "Kent.Persson@example.com");
        person.setFirstName("Marie");
        person.setLastName("Persson");
        person.setEmail("Marie.Persson@example.com");

        assertEquals("Marie", person.getFirstName());
        assertEquals("Persson", person.getLastName());
        assertEquals("Marie.Persson@example.com", person.getEmail());
    }

    @Test
    public void testPersonSummary() {
        Person person = new Person(1, "Kent", "Persson", "Kent.Persson@example.com");
        String expectedSummary = "{id: 1, name: Kent Persson, email: Kent.Persson@example.com}";
        assertEquals(expectedSummary, person.getSummary());
    }

    @Test
    public void testPersonNullFields() {
        assertThrows(IllegalArgumentException.class, () -> new Person(1, null, "Persson", "Kent.Persson@example.com"));
        assertThrows(IllegalArgumentException.class, () -> new Person(1, "Kent", null, "Kent.Persson@example.com"));
        assertThrows(IllegalArgumentException.class, () -> new Person(1, "Kent", "Persson", null));
    }
}

