package com.koushik.koushik.services;


import com.koushik.koushik.models.JournalModel;
import com.koushik.koushik.repository.JournalEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JournalEntryService {

    @Autowired
    JournalEntryRepository repo;

    public void createJournal(JournalModel data){
        repo.save(data);
    }

    public List<JournalModel> getAllJournal() {

        return repo.findAll();
    }

    public JournalModel getjournalById(ObjectId id) {
        return repo.findById(id).orElse(null);
    }

    public void deleteById(ObjectId id) {
        repo.deleteById(id);
    }

}
