package com.journalAppp.JournalApp.service;

import com.journalAppp.JournalApp.Repository.JournalEntryRepo;
import com.journalAppp.JournalApp.Repository.UserRepo;
import com.journalAppp.JournalApp.entity.JournalEntry;
import com.journalAppp.JournalApp.entity.User;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class JournalEntryService {

    @Autowired
    private JournalEntryRepo journalEntryRepo;

    private static final Logger logger = LoggerFactory.getLogger(JournalEntryService.class);

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepo userRepo;

    @Transactional
    public void saveEntry(JournalEntry journalEntry, String username) {
       try {
           User user = userService.findByUsername(username);
           journalEntry.setDate(LocalDateTime.now());
           JournalEntry saved =  journalEntryRepo.save(journalEntry);
           user.getJournalEntries().add(saved);
           userService.saveUser(user);
       }
       catch (Exception e) {
           System.out.println(e);
           throw new RuntimeException("An error occurred while saving entry",e);
       }
    }
   public void saveEntry(JournalEntry journalEntry) {
       journalEntryRepo.save(journalEntry);
    }

    public List<JournalEntry> getAll(){
        return journalEntryRepo.findAll();
    }

    public Optional<JournalEntry> findById(ObjectId id){
        return journalEntryRepo.findById(id);
    }

    @Transactional
    public void deleteById(ObjectId id, String username){
        try {
            User user = userService.findByUsername(username);
            boolean removed =user.getJournalEntries().removeIf( x -> x.getId().equals(id));
            if (removed){
                userService.saveUser(user);
                journalEntryRepo.deleteById(id);
            }
        } catch (Exception e) {
            System.out.println(e);
            throw new RuntimeException("An error occurred while deleting entry",e);

        }


    }


}
