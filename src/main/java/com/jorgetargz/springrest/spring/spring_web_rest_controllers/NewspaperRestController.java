package com.jorgetargz.springrest.spring.spring_web_rest_controllers;

import com.jorgetargz.springrest.domain.modelo.Newspaper;
import com.jorgetargz.springrest.domain.usecases.NewspapersUseCases;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/newspapers")
public class NewspaperRestController {


    private final NewspapersUseCases newspapersUseCases;

    public NewspaperRestController(NewspapersUseCases newspapersUseCases) {
        this.newspapersUseCases = newspapersUseCases;
    }

    @GetMapping
    public List<Newspaper> getAllUsers() {
        return newspapersUseCases.getAllNewspapers();
    }

    @GetMapping("/{id}")
    public Newspaper getNewspaperById(@PathVariable Long id) {
        return newspapersUseCases.findNewspaperById(id.intValue());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Newspaper createNewspaper(@RequestBody Newspaper newspaper) {
        return newspapersUseCases.createNewspaper(newspaper);
    }

    @PutMapping("/{id}")
    public Newspaper updateNewspaper(@PathVariable Long id, @RequestBody Newspaper newspaper) {
        newspaper.setId(id.intValue());
        return newspapersUseCases.updateNewspaper(newspaper);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteNewspaper(@PathVariable Long id) {
        newspapersUseCases.deleteNewspaperById(id.intValue());
    }
}

