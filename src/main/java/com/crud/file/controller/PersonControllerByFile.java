package com.crud.file.controller;

import com.crud.file.entity.Person;
import com.crud.file.service.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonControllerByFile {
    @Autowired
    private PersonService personService;

    @PostMapping

    public ResponseEntity<Person> createPerson(@RequestBody Person person) throws IOException {
        return ResponseEntity.ok(personService.createPerson(person));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable String id) throws IOException {
        return ResponseEntity.ok(personService.getPerson(id));
    }

    @GetMapping
    public ResponseEntity<List<Person>> getAllPersons() throws IOException {
        return ResponseEntity.ok(personService.getAllPersons());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable String id, @RequestBody Person person) throws IOException {
        return ResponseEntity.ok(personService.updatePerson(id, person));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable String id) throws IOException {
        personService.deletePerson(id);
        return ResponseEntity.noContent().build();
    }
}
