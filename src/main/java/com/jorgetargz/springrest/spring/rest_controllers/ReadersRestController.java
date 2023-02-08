package com.jorgetargz.springrest.spring.rest_controllers;

import com.jorgetargz.springrest.domain.modelo.Reader;
import com.jorgetargz.springrest.domain.usecases.ReaderUseCases;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/readers")
@Tag(name = "Readers API", description = "readers API")
public class ReadersRestController {


    private final ReaderUseCases readersUseCases;

    public ReadersRestController(ReaderUseCases readersUseCases) {
        this.readersUseCases = readersUseCases;
    }

    @GetMapping
    @Operation(summary = "Get all readers")
    public List<Reader> getAllReaders() {
        return readersUseCases.getAllReaders();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get reader by id")
    public Reader getReaderById(@PathVariable Long id) {
        return readersUseCases.findReaderById(id.intValue());
    }

    @PostMapping
    @Operation(summary = "Create a new reader")
    @ResponseStatus(HttpStatus.CREATED)
    public Reader createReader(@RequestBody Reader reader) {
        return readersUseCases.createReader(reader);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a reader")
    public Reader updateReader(@PathVariable Long id, @RequestBody Reader reader) {
        reader.setId(id.intValue());
        return readersUseCases.updateReader(reader);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a reader")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteReader(@PathVariable Long id) {
        readersUseCases.deleteReaderById(id.intValue());
    }
}

