package com.example.phonebook.repository;

import com.example.phonebook.model.Phonebook;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/*
    Function ini digunakan untuk mencari daftar entri Phonebook
    di mana field name mengandung string tertentu
 */
public interface PhonebookRepository extends JpaRepository<Phonebook, Integer> {
    List<Phonebook> findByNameContainingIgnoreCase(String name);
}
