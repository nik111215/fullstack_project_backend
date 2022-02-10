package com.example.full_stack_project_backend.controller;

import com.example.full_stack_project_backend.dao.DAO;
import com.example.full_stack_project_backend.dao.PersonJDBCDAO;
import com.example.full_stack_project_backend.model.Person;
import com.example.full_stack_project_backend.model.PersonData;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Collection;
import java.util.List;


@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
public class Controller {
    private final PersonJDBCDAO<Person> personJDBCDAO;
    private final DAO<PersonData> dataDAO;

    public Controller(PersonJDBCDAO<Person> personJDBCDAO, DAO<PersonData> dataDAO) {
        this.personJDBCDAO = personJDBCDAO;
        this.dataDAO = dataDAO;
    }

    @GetMapping("/data")
    public List<PersonData> getData() {
        return dataDAO.list();
    }

    @GetMapping("/person_data/{id}")
    public List<PersonData> getPersonData(@PathVariable int id) {
        return personJDBCDAO.dataPerson(id);
    }

    @PostMapping("/post_new_data")
    public ResponseEntity<Void> addData(@RequestBody PersonData personData) {
        dataDAO.create(personData);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/delete_data/{id}")
    public ResponseEntity<Void> deleteData(@PathVariable int id) {
        dataDAO.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/person")
    public  List<Person> getPerson() {
        return personJDBCDAO.list();
    }
}
