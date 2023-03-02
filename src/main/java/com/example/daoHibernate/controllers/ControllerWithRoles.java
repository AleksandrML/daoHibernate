package com.example.daoHibernate.controllers;

import com.example.daoHibernate.models.Person;
import com.example.daoHibernate.repositories.DbWorker;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.util.List;


@RestController
@RequestMapping("/roles")
public class ControllerWithRoles {

    DbWorker dbWorker;

    public ControllerWithRoles(DbWorker dbWorker) {
        this.dbWorker = dbWorker;
    }

    @GetMapping("/by-city")
    @Secured({"ROLE_READ"})
    public List<Person> fetchPersonByCity(@RequestParam("city") String city) {
        return dbWorker.getPersonByCity(city);
    }

    @GetMapping("/write")
    @RolesAllowed({"ROLE_WRITE"})
    public String writeSomethingLike(@RequestParam("something") String something) {
        return String.format("%s is written", something);
    }

    @GetMapping("/write-or-delete")
    @PreAuthorize("hasRole('ROLE_WRITE') or hasRole('ROLE_DELETE')")
    public String writeOrDeleteSomethingLike(@RequestParam("something") String something) {
        return String.format("%s is done", something);
    }

    @GetMapping("/do-something")
    @PreAuthorize("#username == authentication.principal.username")
    public String fetchPersonByNameAndSurname(@RequestParam("username") String username) {
        return String.format("%s did something", username);
    }

}
