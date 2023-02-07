package com.jorgetargz.springrest.data;

import com.jorgetargz.springrest.data.modelo.NewspaperEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface RepositoryNewspapers extends JpaRepository<NewspaperEntity, Integer> {

    @Transactional
    @Modifying
    @Query("UPDATE NewspaperEntity n SET n.nameNewspaper = :name, n.releaseDate = :date WHERE n.id = :id")
    int updateNewspaperById(String name, String date, int id);

}
