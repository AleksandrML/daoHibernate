package com.example.daoHibernate.repositories;

import com.example.daoHibernate.models.Person;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class DbWorker {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public List<Person> getPersonByCity(String city) {
        String queryJsql = "SELECT p FROM Person p WHERE lower(p.cityOfLiving) = :city";
        TypedQuery<Person> typedQuery = entityManager.createQuery(queryJsql, Person.class);
        typedQuery.setParameter("city", city.toLowerCase());
        return typedQuery.getResultList();
    }

}
