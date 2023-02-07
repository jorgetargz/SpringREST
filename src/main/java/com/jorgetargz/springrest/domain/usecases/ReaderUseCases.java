package com.jorgetargz.springrest.domain.usecases;

import com.jorgetargz.springrest.data.RepositoryReaders;
import com.jorgetargz.springrest.data.modelo.ReaderEntity;
import com.jorgetargz.springrest.data.modelo.mappers.ReaderMapper;
import com.jorgetargz.springrest.domain.excepciones.NotFoundException;
import com.jorgetargz.springrest.domain.modelo.Reader;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReaderUseCases {

    private final RepositoryReaders repository;
    private final ReaderMapper readerMapper;

    public ReaderUseCases(RepositoryReaders repository, ReaderMapper readerMapper) {
        this.repository = repository;
        this.readerMapper = readerMapper;
    }

    public List<Reader> getAllReaders() {
        return repository.findAll().stream()
                .map(readerMapper::toReader)
                .toList();
    }

    public Reader createReader(Reader reader) {
        ReaderEntity readerEntity = readerMapper.toReaderEntity(reader);
        ReaderEntity entitySaved = repository.save(readerEntity);
        return readerMapper.toReader(entitySaved);
    }

    public Reader findReaderById(int id) {
        ReaderEntity readerEntity = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Reader not found"));
        return readerMapper.toReader(readerEntity);
    }

    public Reader updateReader(Reader reader) {
        ReaderEntity readerEntity = readerMapper.toReaderEntity(reader);
        int rowsUpdated = repository.updateReaderById(readerEntity.getName(), readerEntity.getDateOfBirth(), readerEntity.getId());
        if (rowsUpdated == 0) {
            throw new NotFoundException("Reader not found");
        }
        return reader;
    }

    public void deleteReaderById(int id) {
        repository.deleteById(id);
    }
}
