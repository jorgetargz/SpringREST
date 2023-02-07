package com.jorgetargz.springrest.domain.usecases;

import com.jorgetargz.springrest.data.RepositoryNewspapers;
import com.jorgetargz.springrest.data.modelo.NewspaperEntity;
import com.jorgetargz.springrest.data.modelo.mappers.NewspaperMapper;
import com.jorgetargz.springrest.domain.excepciones.NotFoundException;
import com.jorgetargz.springrest.domain.modelo.Newspaper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewspapersUseCases {

    private final RepositoryNewspapers repository;
    private final NewspaperMapper newspaperMapper;

    public NewspapersUseCases(RepositoryNewspapers repository, NewspaperMapper newspaperMapper) {
        this.repository = repository;
        this.newspaperMapper = newspaperMapper;
    }

    public List<Newspaper> getAllNewspapers() {
        return repository.findAll().stream()
                .map(newspaperMapper::toNewspaper)
                .toList();
    }

    public Newspaper createNewspaper(Newspaper newspaper) {
        NewspaperEntity newspaperEntity = newspaperMapper.toNewspaperEntity(newspaper);
        NewspaperEntity entitySaved = repository.save(newspaperEntity);
        return newspaperMapper.toNewspaper(entitySaved);
    }

    public Newspaper findNewspaperById(int id) {
        NewspaperEntity newspaperEntity = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Newspaper not found"));
        return newspaperMapper.toNewspaper(newspaperEntity);
    }

    public Newspaper updateNewspaper(Newspaper newspaper) {
        NewspaperEntity newspaperEntity = newspaperMapper.toNewspaperEntity(newspaper);
        int rowsUpdated = repository.updateNewspaperById(newspaperEntity.getNameNewspaper(), newspaperEntity.getReleaseDate(), newspaperEntity.getId());
        if (rowsUpdated == 0) {
            throw new NotFoundException("Newspaper not found");
        }
        return newspaper;
    }

    public void deleteNewspaperById(int id) {
        repository.deleteById(id);
    }
}
