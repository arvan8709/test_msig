package com.example.phonebook.controller;

import com.example.phonebook.model.Phonebook;
import com.example.phonebook.service.PhonebookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/phonebook")
public class PhonebookController {

    @Autowired
    private PhonebookService service;

    @PostMapping("/create")
    public ResponseEntity<Phonebook> createEntry(@RequestBody Phonebook phonebook) {
        Phonebook createdEntry = service.createEntry(phonebook);
        return ResponseEntity.ok(createdEntry);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Phonebook> getById(@PathVariable Integer id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/all")
    public ResponseEntity<List<Phonebook>> getAll() {
        List<Phonebook> entries = service.getAll();
        return ResponseEntity.ok(entries);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Phonebook>> searchByName(@RequestParam String name) {
        List<Phonebook> result = service.searchByName(name);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Phonebook> updateEntry(@PathVariable Integer id, @RequestBody Phonebook phonebook) {
        Phonebook updatedEntry = service.updateEntry(id, phonebook);
        if (updatedEntry != null) {
            return ResponseEntity.ok(updatedEntry);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteEntry(@PathVariable Integer id) {
        service.deleteEntry(id);
        return ResponseEntity.ok().build();
    }
}
