package com.ccdev.firstWeb.service.impl;

import com.ccdev.firstWeb.entities.People;
import com.ccdev.firstWeb.repository.PeopleRepository;
import com.ccdev.firstWeb.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PeopleServiceImpl implements PeopleService {
    @Autowired
    private PeopleRepository peopleRepository;
    @Override
    public List<People> obtainAll() {
        return peopleRepository.findAll();
    }

    @Override
    public People obtainById(Long id) {
        return peopleRepository.findById(id).orElse(null);
    }

    @Override
    public People createPerson(People person) {
        return peopleRepository.save(person);
    }

    @Override
    public People updatePerson(Long id, People person) {
        People personDDBB = peopleRepository.findById(id).orElse(null);
        if(personDDBB != null){
            personDDBB.setName(person.getName());
            personDDBB.setAge(person.getAge());
            return personDDBB;
        }
        return null;
    }
    @Override
    public void deletePerson(Long id) {
        peopleRepository.deleteById(id);
    }
    @Override
    public Long quanityOfPeople(){
        return  peopleRepository.count();
    }
}
