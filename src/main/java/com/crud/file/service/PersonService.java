package com.crud.file.service;

import com.crud.file.entity.Person;

import java.io.IOException;
import java.util.List;

public interface PersonService {

     Person createPerson(Person person)  throws IOException;

     Person getPerson(String id)  throws IOException;

     List<Person> getAllPersons() throws IOException;

     Person updatePerson(String id, Person person)  throws IOException;

     void deletePerson(String id)  throws IOException;
}