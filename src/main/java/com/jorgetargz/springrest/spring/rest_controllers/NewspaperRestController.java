package com.jorgetargz.springrest.spring.rest_controllers;

import com.jorgetargz.springrest.domain.modelo.Newspaper;
import com.jorgetargz.springrest.domain.usecases.NewspapersUseCases;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/newspapers")
@Tag(name = "Newspapers API", description = "newspapers API")
public class NewspaperRestController {


    private final NewspapersUseCases newspapersUseCases;

    public NewspaperRestController(NewspapersUseCases newspapersUseCases) {
        this.newspapersUseCases = newspapersUseCases;
    }

    @GetMapping
    @Operation(summary = "Get all newspapers")
    public List<Newspaper> getAllUsers() {
        return newspapersUseCases.getAllNewspapers();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get newspaper by id")
    public Newspaper getNewspaperById(@PathVariable Long id) {
        return newspapersUseCases.findNewspaperById(id.intValue());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create a new newspaper")
    public Newspaper createNewspaper(@RequestBody Newspaper newspaper) {
        return newspapersUseCases.createNewspaper(newspaper);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a newspaper")
    public Newspaper updateNewspaper(@PathVariable Long id, @RequestBody Newspaper newspaper) {
        newspaper.setId(id.intValue());
        return newspapersUseCases.updateNewspaper(newspaper);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a newspaper")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteNewspaper(@PathVariable Long id) {
        newspapersUseCases.deleteNewspaperById(id.intValue());
    }
}

