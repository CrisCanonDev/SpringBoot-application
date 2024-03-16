package com.ccdev.firstWeb.controller;


import com.ccdev.firstWeb.entities.People;
import com.ccdev.firstWeb.repository.PeopleRepository;
import com.ccdev.firstWeb.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.PipedWriter;
import java.util.List;

@Controller
@RequestMapping({"/people","/"})
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
    public String showFormAddPerson(Model model){
        model.addAttribute("person",new People());
        model.addAttribute("action","/people/new");
        return "form";
    }

    @PostMapping("/new")
    public String addPerson(@ModelAttribute People person){
        peopleService.createPerson(person);
        return "redirect:/people";
    }

    @GetMapping("/edit/{id}")
    public String showFormModifPerson(@PathVariable Long id, @ModelAttribute People person, Model model){
        model.addAttribute("person",person);
        model.addAttribute("action","/people/edit/"+id);
        return "form";
    }
    @PostMapping("edit/{id}")
    public String modifyPerson(@PathVariable Long id, @ModelAttribute People person){
        peopleService.updatePerson(id,person);
        return "redirect:/people";
    }

    @GetMapping("delete/{id}")
    public String deletePerson(@PathVariable Long id){
        peopleService.deletePerson(id);
        return "redirect:/people";
    }
}
