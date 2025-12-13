package com.koushik.koushik.controllers;

import com.koushik.koushik.models.JournalModel;
import com.koushik.koushik.services.JournalEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class JournalEntryControllerV2 {

    @Autowired
    JournalEntryService service;

    private Map<String, JournalModel> journalEntries = new HashMap<>();

    @GetMapping("/list")
    public List<JournalModel> getAll(){
        List<JournalModel> list = service.getAllJournal();
        return list;
    }

    @PostMapping("/create-entry")
    public ResponseEntity<JournalModel> createEntry(@RequestBody JournalModel payload) {
        try {
            payload.setDate(LocalDateTime.now());
            service.createJournal(payload);
            return new ResponseEntity<>(payload, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<?> getJournalById(@PathVariable ObjectId id){

        Optional<JournalModel>  journalEntry = Optional.ofNullable(service.getjournalById(id));

        if(journalEntry.isPresent()){
            return new ResponseEntity<>(journalEntry.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/list/{id}")
    public ResponseEntity<?> deleteJournalById(@PathVariable ObjectId id){

        service.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/update-journal/{id}")
    public JournalModel updateJournalById(@RequestBody JournalModel payload, @PathVariable ObjectId id){
        JournalModel old = service.getjournalById(id);
        if(old != null){
            old.setContent(payload.getContent() != null || payload.getContent().equals("") ? payload.getContent() : old.getContent());
            old.setTitle(payload.getTitle() != null || payload.getTitle().equals("") ? payload.getTitle() : old.getTitle());
        };

        service.createJournal(old);

        return old;
    }

}
