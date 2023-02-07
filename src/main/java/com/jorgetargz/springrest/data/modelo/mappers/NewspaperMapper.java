package com.jorgetargz.springrest.data.modelo.mappers;

import com.jorgetargz.springrest.data.modelo.NewspaperEntity;
import com.jorgetargz.springrest.domain.modelo.Newspaper;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class NewspaperMapper {

    public Newspaper toNewspaper(NewspaperEntity newspaper) {
        return new Newspaper(newspaper.getId(), newspaper.getNameNewspaper(), LocalDate.parse(newspaper.getReleaseDate()));
    }

    public NewspaperEntity toNewspaperEntity(Newspaper newspaper) {
        return new NewspaperEntity(newspaper.getId(), newspaper.getNameNewspaper(), newspaper.getReleaseDate().toString());
    }
}
