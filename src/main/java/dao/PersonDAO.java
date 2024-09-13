package dao;

import model.Person;

import java.util.List;

public interface PersonDAO {
    void persist(Person person);
    Person findById(int id);
    List<Person> findAll();
    boolean remove(Person person);
}
