package com.example.full_stack_project_backend;

import com.example.full_stack_project_backend.dao.DAO;
import com.example.full_stack_project_backend.dao.PersonJDBCDAO;
import com.example.full_stack_project_backend.model.Person;
import com.example.full_stack_project_backend.model.PersonData;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class FullStackProjectBackendApplication {

    private static PersonJDBCDAO<Person> personJDBCDAO;
    private static DAO<PersonData> personDataDAO;

    public FullStackProjectBackendApplication(PersonJDBCDAO<Person> personJDBCDAO, DAO<PersonData> personDataDAO) {
        this.personJDBCDAO = personJDBCDAO;
        this.personDataDAO = personDataDAO;
    }

    public static void main(String[] args) {
        SpringApplication.run(FullStackProjectBackendApplication.class, args);


        Person person = new Person("dima", "dima nikolotov", "nikdim@rambler.com", "123456");
        personJDBCDAO.create(person);
        Optional<Person> first = personJDBCDAO.get(1);
        System.out.println(first.get());

        person.setPassword("gjeri");
        personJDBCDAO.update(person, 1);
        List<Person> personList = personJDBCDAO.list();
        personList.forEach(System.out::println);

        PersonData personData = new PersonData(2, 500, 100000, "polba");
        personDataDAO.create(personData);
        Optional<PersonData> secondPersonData = personDataDAO.get(2);
        System.out.println(secondPersonData.get());

        personData.setLastprice(1324);
        personDataDAO.update(personData, 1);

        List<PersonData> allData = personDataDAO.list();
        allData.forEach(System.out::println);

        List<PersonData> dataList = personJDBCDAO.dataPerson(2);
        dataList.forEach(System.out::println);
    }

}
