package com.ccdev.firstWeb.repository;

import com.ccdev.firstWeb.entities.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeopleInterface extends JpaRepository<People, Long> {
}
