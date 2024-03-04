package com.ccdev.firstWeb.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_people")
public class People {
    @Id
    private Long id;
    private String name;
    private int age;
}
