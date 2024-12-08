package com.notes.datagitaretriever.controller;

import com.notes.datagitaretriever.model.Verse;
import com.notes.datagitaretriever.service.VersesService;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class VersesController {

    @Autowired
    private VersesService versesService;

    @Operation(summary = "To All Verses By Chapter", description="This API will fetch all the Verses by Provided chapter  available in the Database Table...")
    @ApiResponses(value = {@ApiResponse(responseCode="200",description="List Of Verses Found Successfully")})
    @GetMapping("/chapter/{chapter}")
    public List<Verse> getAllVerses(@PathVariable String chapter) {

        return versesService.getVerses(chapter);
    }

    @Operation(summary = "To All Verses By Chapter and Verse Number", description="This API will fetch a Verse by Provided chapter and verse number  available in the Database Table...")
    @ApiResponses(value = {@ApiResponse(responseCode="200",description="Verse Found Successfully")})

    @GetMapping("/chapter/{chapter}/{verse}")
    public List<Verse> getVerse(@PathVariable String chapter, @PathVariable String verse) {
        return versesService.getVerse(chapter,verse);
    }

    @Operation(summary = "To Get  Verses By Chapter with Pagination Feature", description="This API will fetch all the Verses by Provided chapter  with Pagination Feature available in the Database Table...")
    @ApiResponses(value = {@ApiResponse(responseCode="200",description="List Of Vereses Found Successfully")})
    @GetMapping("/chapter/group/{chapter}")
    public List<Verse> getSpecified(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "true") boolean ascending,
            @PathVariable String chapter
    ) {
        return versesService.getSpecificVerse(page,size,sortBy,ascending,chapter);
    }

    @Hidden
    @PostMapping("/chapter/{name}")
    public Verse saveVerses(@PathVariable String name, @RequestBody Verse chapter) {
        versesService.saveVerses(name, chapter);
        return chapter;
    }
}