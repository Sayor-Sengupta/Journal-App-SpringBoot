package com.journalAppp.JournalApp.Repository;

import com.journalAppp.JournalApp.entity.JournalEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JournalEntryRepo extends MongoRepository<JournalEntry , ObjectId> {

}
