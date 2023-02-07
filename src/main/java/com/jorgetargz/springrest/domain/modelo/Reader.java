package com.jorgetargz.springrest.domain.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Reader {
    private Integer id;
    private String name;
    private LocalDate dateOfBirth;
}
