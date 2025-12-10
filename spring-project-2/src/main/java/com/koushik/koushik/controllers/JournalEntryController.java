package com.koushik.koushik.controllers;

import com.koushik.koushik.models.JournalModel;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class JournalEntryController {

    private Map<Long, JournalModel> journalEntries = new HashMap<>();

    @GetMapping("/list")
    public List<JournalModel> getAll(){
        List<JournalModel> list = new ArrayList<>(journalEntries.values());
        return list;
    }

    @PostMapping("/create-entry")
    public boolean createEntry(@RequestBody JournalModel payload){
        journalEntries.put(payload.getId(), payload);
        return true;
    }

}
