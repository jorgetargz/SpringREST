package com.jorgetargz.springrest.data;

import com.jorgetargz.springrest.data.modelo.ReaderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface RepositoryReaders extends JpaRepository<ReaderEntity, Integer> {

    @Transactional
    @Modifying
    @Query("UPDATE ReaderEntity r SET r.name = :name, r.dateOfBirth = :dateOfBirth WHERE r.id = :id")
    int updateReaderById(String name, String dateOfBirth, int id);

}
