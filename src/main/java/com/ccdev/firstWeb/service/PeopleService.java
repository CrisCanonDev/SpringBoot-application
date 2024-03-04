package com.ccdev.firstWeb.service;

import com.ccdev.firstWeb.entities.People;
import java.util.List;

public interface PeopleService {
    List<People> obtainAll();
    People obtainById(Long id);
    People createPerson(People person);
    People updatePerson(Long id, People person);
    void deletePerson(Long id);
    Long quanityOfPeople();

}
