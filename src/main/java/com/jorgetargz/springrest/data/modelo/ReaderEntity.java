package com.jorgetargz.springrest.data.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor

@Entity
@Table(name = "reader")
public class ReaderEntity {

    @Id
    private Integer id;

    @Column(name = "name_reader")
    private String name;

    @Column(name = "birth_reader")
    private String dateOfBirth;


    public ReaderEntity(int id, String nameInput, String birthdayInput) {
        this.id = id;
        this.name = nameInput;
        this.dateOfBirth = birthdayInput;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ReaderEntity readerEntity = (ReaderEntity) o;
        return id != null && Objects.equals(id, readerEntity.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
