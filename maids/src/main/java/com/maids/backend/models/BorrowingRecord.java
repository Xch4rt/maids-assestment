package com.maids.backend.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
public class BorrowingRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "bookId")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "patronId")
    private Patron patron;

    private LocalDate borrowDate;

    private LocalDate returnDate;

}
