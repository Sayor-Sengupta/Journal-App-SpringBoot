package com.journalAppp.JournalApp.Repository;

import com.journalAppp.JournalApp.entity.JournalEntry;
import com.journalAppp.JournalApp.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepo extends MongoRepository<User, ObjectId> {
    User findByUsername(String username);

    void deleteByUsername(String name);
}
