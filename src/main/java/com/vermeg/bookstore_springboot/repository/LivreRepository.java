package com.vermeg.bookstore_springboot.repository;

import com.vermeg.bookstore_springboot.entities.Admin;
import com.vermeg.bookstore_springboot.entities.Livre;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivreRepository extends CrudRepository<Livre, Integer> {
}
