package dao;

import model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CollectionPersonDAO implements PersonDAO {
    private List<Person> persons = new ArrayList<>();

    @Override
    public void persist(Person person) {
        persons.add(person);
    }

    @Override
    public Person findById(int id) {
        Optional<Person> result = persons.stream()
                .filter(person -> person.getId() == id)
                .findFirst();
        return result.orElse(null);
    }

    @Override
    public List<Person> findAll() {
        return new ArrayList<>(persons);
    }

    @Override
    public boolean remove(Person person) {
        return persons.remove(person);
    }
}
