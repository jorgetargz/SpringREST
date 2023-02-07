package com.jorgetargz.springrest.data.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.util.Objects;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "newspaper")
public class NewspaperEntity {

    @Id
    private Integer id;

    @Column(name = "name_newspaper")
    private String nameNewspaper;

    @Column(name = "release_date")
    private String releaseDate;

    public NewspaperEntity(String name, String releaseDate) {
        this.nameNewspaper = name;
        this.releaseDate = releaseDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        NewspaperEntity newspaperEntity = (NewspaperEntity) o;
        return id != null && Objects.equals(id, newspaperEntity.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return nameNewspaper;
    }
}
