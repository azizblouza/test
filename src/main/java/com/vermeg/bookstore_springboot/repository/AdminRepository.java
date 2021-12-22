package com.vermeg.bookstore_springboot.repository;

import com.vermeg.bookstore_springboot.entities.Admin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends CrudRepository<Admin, Integer> {
}
