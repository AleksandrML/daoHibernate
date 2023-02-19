package com.example.daoHibernate.controllers;

import com.example.daoHibernate.models.Person;
import com.example.daoHibernate.repositories.DbWorker;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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

}
