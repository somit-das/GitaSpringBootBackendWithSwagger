package com.notes.datagitaretriever.model;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Document
@Getter
@Service
public class Verse {
    @Id
    private String id;
    
    private String verse_number;
    private String chapter_number;
    private String slug;
    private String text;
    private String transliteration;
    private String   word_meanings;
    private ArrayList<String> translations;
    private ArrayList<String> commentaries;


}