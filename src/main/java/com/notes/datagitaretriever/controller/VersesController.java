package com.notes.datagitaretriever.controller;

import com.notes.datagitaretriever.model.Verse;
import com.notes.datagitaretriever.service.VersesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chapter")
public class VersesController {

    @Autowired
    private VersesService versesService;

    @GetMapping("/{chapter}")
    public List<Verse> getAllVerses(@PathVariable String chapter) {

        return versesService.getVerses(chapter);
    }

    @GetMapping("/{chapter}/{verse}")
    public List<Verse> getVerse(@PathVariable String chapter, @PathVariable String verse) {
        return versesService.getVerse(chapter,verse);
    }

    @PostMapping("/{name}")
    public Verse saveVerses(@PathVariable String name, @RequestBody Verse chapter) {
        versesService.saveVerses(name, chapter);
        return chapter;
    }
}