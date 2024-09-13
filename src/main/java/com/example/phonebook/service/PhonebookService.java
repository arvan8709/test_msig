package com.example.phonebook.service;

import com.example.phonebook.model.Phonebook;
import com.example.phonebook.repository.PhonebookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhonebookService {

    @Autowired
    private PhonebookRepository repository;

    public Phonebook createEntry(Phonebook phonebook) {
        return repository.save(phonebook);
    }

    public Optional<Phonebook> getById(Integer id) {
        return repository.findById(id);
    }

    public List<Phonebook> getAll() {
        return repository.findAll();
    }

    public List<Phonebook> searchByName(String name) {
        return repository.findByNameContainingIgnoreCase(name);
    }

    public Phonebook updateEntry(Integer id, Phonebook updatedEntry) {
        Optional<Phonebook> existingEntry = repository.findById(id);
        if (existingEntry.isPresent()) {
            Phonebook phonebook = existingEntry.get();
            phonebook.setName(updatedEntry.getName());
            phonebook.setPhoneNumber(updatedEntry.getPhoneNumber());
            phonebook.setEmail(updatedEntry.getEmail());
            phonebook.setAddress(updatedEntry.getAddress());
            return repository.save(phonebook);
        }
        return null;
    }

    public void deleteEntry(Integer id) {
        repository.deleteById(id);
    }
}
