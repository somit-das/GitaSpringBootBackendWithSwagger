package com.notes.datagitaretriever.model;

import lombok.Getter;
import lombok.Setter;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter
public class Contents {
    @Id
    private String id;
    private String name;
    private String name_transliterated;
    private String name_translated;
    private String verses_count;
    private String chapter_number;
    private String name_meaning;
    private String chapter_summary;
}
