package com.example.daoHibernate.models;

import lombok.Data;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
public class PersonKey implements Serializable {
    private String name;
    private String surname;
    private int age;

}
