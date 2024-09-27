package com.codingworld.service1.book.repository;

import com.codingworld.service1.book.modal.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Book,Long> {
}
