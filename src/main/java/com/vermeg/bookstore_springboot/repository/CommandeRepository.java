package com.vermeg.bookstore_springboot.repository;

import com.vermeg.bookstore_springboot.entities.Commande;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandeRepository extends CrudRepository<Commande, Integer> {

}
