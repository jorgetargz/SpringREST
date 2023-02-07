package com.jorgetargz.springrest.domain.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Newspaper {
    private Integer id;
    private String nameNewspaper;
    private LocalDate releaseDate;
}