package com.koushik.koushik.repository;

import com.koushik.koushik.models.JournalModel;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface JournalEntryRepository  extends MongoRepository<JournalModel, ObjectId> {

}
