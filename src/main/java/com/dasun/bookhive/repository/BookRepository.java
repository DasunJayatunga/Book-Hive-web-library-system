package com.dasun.bookhive.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dasun.bookhive.model.Book;

/*
Provides methods such as,
    save(Entity):   Save or update a record
    findById(id):   Return one record
    findAll():      Return all records
    deleteById(id): Delete a record
    count():        return total number of records
*/
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    
    // Method to find book based on title
    List<Book> findByNameContainingIgnoreCase(String title);
}
