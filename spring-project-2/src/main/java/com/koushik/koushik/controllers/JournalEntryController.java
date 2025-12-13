//package com.koushik.koushik.controllers;
//
//import com.koushik.koushik.models.JournalModel;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.*;
//
//@RestController
//@RequestMapping("/api-old")
//public class JournalEntryController {
//
//    private Map<String, JournalModel> journalEntries = new HashMap<>();
//
//    @GetMapping("/list")
//    public List<JournalModel> getAll(){
//        List<JournalModel> list = new ArrayList<>(journalEntries.values());
//        return list;
//    }
//
//    @PostMapping("/create-entry")
//    public boolean createEntry(@RequestBody JournalModel payload){
//        journalEntries.put(payload.getId(), payload);
//        return true;
//    }
//
//    @GetMapping("/list/{id}")
//    public JournalModel getJournalById(@PathVariable String id){
//
//        return journalEntries.get(id);
//
//    }
//
//    @DeleteMapping("/list/{id}")
//    public boolean deleteJournalById(@PathVariable String id){
//
//        journalEntries.remove(id);
//
//        return true;
//    }
//
//    @PostMapping("/update-journal/{id}")
//    public JournalModel updateJournalById(@RequestBody JournalModel payload, @PathVariable String id){
//        return journalEntries.put(id, payload);
//    }
//
//}
