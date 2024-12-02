package com.notes.datagitaretriever.service;

import com.notes.datagitaretriever.model.Contents;
import com.notes.datagitaretriever.model.Verse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContentsService {
    @Autowired
    private MongoTemplate mongoTemplate;


    public void saveChapterData(String chapterName, Verse verse) {
        // Save data to a dynamically named collection
        mongoTemplate.save(verse, chapterName);
    }

    public List<Contents> getAllContent() {
        return mongoTemplate.findAll(Contents.class);
    }
}
