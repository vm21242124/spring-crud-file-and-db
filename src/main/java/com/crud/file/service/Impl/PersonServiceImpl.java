package com.crud.file.service.Impl;

import com.crud.file.entity.Person;
import com.crud.file.service.PersonService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class PersonServiceImpl implements PersonService {
    private static final String DIRECTORY = "data/";
    private final ObjectMapper objectMapper = new ObjectMapper();

    public PersonServiceImpl() {
        new File(DIRECTORY).mkdirs();
    }

    @Override
    public Person createPerson(Person person) throws IOException {
        person.setId(UUID.randomUUID().toString());
        objectMapper.writeValue(new File(DIRECTORY + person.getId() + ".json"), person);
        return person;
    }

    @Override
    public Person getPerson(String id) throws IOException {
        return objectMapper.readValue(new File(DIRECTORY + id + ".json"), Person.class);
    }

    @Override
    public List<Person> getAllPersons() throws IOException {
        List<Person> persons = new ArrayList<>();
        Files.list(Paths.get(DIRECTORY)).forEach(path -> {
            try {
                persons.add(objectMapper.readValue(path.toFile(), Person.class));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        return persons;
    }

    @Override
    public Person updatePerson(String id, Person person) throws IOException {
        person.setId(id);
        objectMapper.writeValue(new File(DIRECTORY + id + ".json"), person);
        return person;
    }

    @Override
    public void deletePerson(String id) throws IOException {
        Files.deleteIfExists(Paths.get(DIRECTORY + id + ".json"));
    }
}
