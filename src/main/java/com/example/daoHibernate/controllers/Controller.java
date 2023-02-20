package com.example.daoHibernate.controllers;

import com.example.daoHibernate.models.Person;
import com.example.daoHibernate.repositories.DbWorker;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/persons")
public class Controller {

    DbWorker dbWorker;

    public Controller(DbWorker dbWorker) {
        this.dbWorker = dbWorker;
    }

    @GetMapping("/by-city")
    public List<Person> fetchPersonByCity(@RequestParam("city") String city) {
        return dbWorker.getPersonByCity(city);
    }

    @GetMapping("/by-age/less-than")
    public List<Person> fetchPersonByAgeLessThan(@RequestParam("age") int age) {
        return dbWorker.getPersonByAgeLessThanSorted(age);
    }

    @GetMapping("/by-name-and-surname")
    public Optional<List<Person>> fetchPersonByNameAndSurname(
            @RequestParam("name") String name,
            @RequestParam("surname") String surname) {
        return dbWorker.getPersonByNameAndSurname(name, surname);
    }

}
