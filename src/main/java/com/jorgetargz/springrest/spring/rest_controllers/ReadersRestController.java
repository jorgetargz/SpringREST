package com.jorgetargz.springrest.spring.rest_controllers;

import com.jorgetargz.springrest.domain.modelo.Reader;
import com.jorgetargz.springrest.domain.usecases.ReaderUseCases;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/readers")
public class ReadersRestController {


    private final ReaderUseCases readersUseCases;

    public ReadersRestController(ReaderUseCases readersUseCases) {
        this.readersUseCases = readersUseCases;
    }

    @GetMapping
    public List<Reader> getAllReaders() {
        return readersUseCases.getAllReaders();
    }

    @GetMapping("/{id}")
    public Reader getReaderById(@PathVariable Long id) {
        return readersUseCases.findReaderById(id.intValue());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Reader createReader(@RequestBody Reader reader) {
        return readersUseCases.createReader(reader);
    }

    @PutMapping("/{id}")
    public Reader updateReader(@PathVariable Long id, @RequestBody Reader reader) {
        reader.setId(id.intValue());
        return readersUseCases.updateReader(reader);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteReader(@PathVariable Long id) {
        readersUseCases.deleteReaderById(id.intValue());
    }
}

