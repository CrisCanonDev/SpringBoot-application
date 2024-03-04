package com.ccdev.firstWeb.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_people")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class People {
    @Id
    private Long id;
    private String name;
    private int age;

}
