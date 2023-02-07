package com.jorgetargz.springrest.data.modelo.mappers;

import com.jorgetargz.springrest.data.modelo.ReaderEntity;
import com.jorgetargz.springrest.domain.modelo.Reader;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class ReaderMapper {

    public Reader toReader(ReaderEntity reader) {
        return new Reader(reader.getId(), reader.getName(), LocalDate.parse(reader.getDateOfBirth()));
    }

    public ReaderEntity toReaderEntity(Reader reader) {
        return new ReaderEntity(reader.getId(), reader.getName(), reader.getDateOfBirth().toString());
    }
}
