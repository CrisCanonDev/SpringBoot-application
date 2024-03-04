package com.ccdev.firstWeb.controller;


import com.ccdev.firstWeb.entities.People;
import com.ccdev.firstWeb.repository.PeopleRepository;
import com.ccdev.firstWeb.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/people")
public class PeopleController {
    @Autowired
    private PeopleService peopleService;

    @GetMapping
    public String listPeople(Model model){
        List<People> people = peopleService.obtainAll();
        model.addAttribute("listPeople", people);
        return "list";
    }

    @GetMapping("/new")
    public String showForm(Model model){
        model.addAttribute("person",new People());
        model.addAttribute("action","/people/new");
        return "form";
    }

    @PostMapping("/new")
    public String addPerson(@ModelAttribute People person){
        peopleService.createPerson(person);
        return "redirect:/personas";
    }

}
