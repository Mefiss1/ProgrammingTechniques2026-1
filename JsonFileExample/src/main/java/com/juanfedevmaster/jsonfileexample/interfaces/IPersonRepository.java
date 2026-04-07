package com.juanfedevmaster.jsonfileexample.interfaces;

import java.util.List;

import com.juanfedevmaster.jsonfileexample.Model.Person;

public interface IPersonRepository {
    boolean saveListPeople(List<Person> peopleList);
    boolean savePerson(Person p);
    boolean find(Person p);
    List<Person> getPeople();
}
