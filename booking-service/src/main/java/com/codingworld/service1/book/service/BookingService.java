package com.codingworld.service1.book.service;

import com.codingworld.service1.book.modal.Book;

import java.util.List;

public interface BookingService {
    Book addBooking(Book flight);
    List<Book> getAllBooking();
    Book findById(Long id);
    void deleteBookingById(Long id);
}
