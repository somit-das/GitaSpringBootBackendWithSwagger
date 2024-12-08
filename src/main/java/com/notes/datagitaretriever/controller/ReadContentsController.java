package com.notes.datagitaretriever.controller;

import com.notes.datagitaretriever.model.Contents;
import com.notes.datagitaretriever.service.ContentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/contents")
public class ReadContentsController {

    @Autowired
    private ContentsService contentsService;

    @GetMapping()
    public List<Contents> getAllContents() {
        return contentsService.getAllContent();
    }

}