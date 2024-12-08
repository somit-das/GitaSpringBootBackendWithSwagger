package com.notes.datagitaretriever.service;

import com.notes.datagitaretriever.model.Verse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
        return  mongoTemplate.find(query, Verse.class,chapter);
    }

    public List<Verse> getSpecificVerse(int page, int size, String sortBy, boolean ascending, String chapter) {

        Query query = new Query();
        Sort sort = ascending ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page, size);
//        query.addCriteria(Criteria.where("chapter").is(chapter));
        query.with(pageable);
        query.with(sort);
//        return  verseRepository.findAll(pageable);
        return mongoTemplate.find(query,Verse.class,chapter);
    }


}