package com.vermeg.bookstore_springboot.repository;

import com.vermeg.bookstore_springboot.entities.Categorie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieRepository extends CrudRepository<Categorie, Integer> {
}
