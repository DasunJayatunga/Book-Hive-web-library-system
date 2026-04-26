package com.dasun.bookhive.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "books")
@Getter                     // generates getters
@Setter                     // generates setters
@NoArgsConstructor          // generates default constructor
@AllArgsConstructor         // generates constructor with all parameters
public class Book {

    // book attributes
    /*
    NOTE: Primitive 'long' cannot be null. When a book is not yet saved to the database,
    its ID should be null (because the database will assign it). With 'long', the default
    value is 0, which conflicts with a possible real ID of 0 (usually auto‑increment starts at 1).
    This can cause Hibernate to think the entity is already persisted when it isn't,
    leading to UPDATE instead of INSERT.
    */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="book_id")
    private Long bookID;

    @Column(name="book_isbn", unique=true, nullable=false, length=20)
    private String isbn;

    @Column(name="book_title", nullable=false, length=200)
    private String title;

    @Column(name="book_author", nullable=false, length=200)
    private String author;

    @Column(name="book_publisher", length=200)
    private String publisher;

    @Column(name="book_year")
    private Integer year;       // NOTE: Integer allows null values unlike int

    @Column(name="book_bio", columnDefinition="TEXT", length=600)
    private String bio;

}
