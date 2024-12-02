package com.notes.datagitaretriever.service;

import com.notes.datagitaretriever.model.Verse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VersesService {

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Verse> getVerses(String chapterName) {
        // Access the collection dynamically based on chapter name
        return mongoTemplate.find(new Query(), Verse.class, chapterName);
    }

    public void saveVerses(String chapterName, Verse verse) {
        // Save data to a dynamically named collection
        mongoTemplate.save(verse, chapterName);
    }

    public List<Verse> getVerse(String chapter, String verse) {
        Query query = new Query();
        query.addCriteria(Criteria.where("verse_number").is(Integer.parseInt(verse)));
        return  mongoTemplate.find(query,Verse.class,chapter);
    }
}