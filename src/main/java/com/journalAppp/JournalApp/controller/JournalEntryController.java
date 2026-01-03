//package com.journalAppp.JournalApp.controller;
//
//import com.journalAppp.JournalApp.entity.JournalEntry;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/_journal")
//public class JournalEntryController {
//
//    private Map<Long , JournalEntry> journalEntries = new HashMap<>();
//
//    @GetMapping
//    public List<JournalEntry> getAll(){
//        return new ArrayList<>(journalEntries.values());
//    }
//
//    @PostMapping
//    public boolean createEntry(@RequestBody JournalEntry myEntry ){
//        journalEntries.put(myEntry.getId(), myEntry);
//        return true;
//    }
//
//    @GetMapping("id/{id}")
//    public JournalEntry getJournalEntryById(@PathVariable Long id){
//        return journalEntries.get(id);
//    }
//
//    @DeleteMapping("id/{id}")
//    public JournalEntry deleteJournalEntryById(@PathVariable Long id){
//        return journalEntries.remove(id);
//    }
//
//    @PutMapping("id/{id}")
//    public JournalEntry updateJournalById(@PathVariable Long id, @RequestBody JournalEntry myEntry){
//       return journalEntries.put(id ,  myEntry);
//    }
//
//}
