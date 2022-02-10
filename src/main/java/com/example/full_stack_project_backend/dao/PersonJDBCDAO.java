package com.example.full_stack_project_backend.dao;

import com.example.full_stack_project_backend.model.Person;
import com.example.full_stack_project_backend.model.PersonData;

import java.util.List;

public interface PersonJDBCDAO<T> extends DAO<T> {
    public List<PersonData> dataPerson(int id);
}
