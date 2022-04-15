package org.vladIs.persons.dao;

import org.springframework.stereotype.Component;
import org.vladIs.persons.models.Person;

import java.util.ArrayList;
import java.util.List;


@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();

        people.add(new Person(++PEOPLE_COUNT, "Vlad", 21, "WhatIsLoveff@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Maxim", 20, "Obagad@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Liza", 22, "AbraKadabra@yandex.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Vanya", 21, "Vanya2020@gmail.com"));

    }

    public List<Person> index(){
        return people;
    }

    public Person show(int id){
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person){
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(int id, Person updatedPerson){
        Person personToBeUpdated = show(id);

        personToBeUpdated.setName(updatedPerson.getName());
        personToBeUpdated.setAge(updatedPerson.getAge());
        personToBeUpdated.setEmail(updatedPerson.getEmail());
    }

    public void delete(int id){
        people.removeIf(person -> person.getId() == id);
    }
}
