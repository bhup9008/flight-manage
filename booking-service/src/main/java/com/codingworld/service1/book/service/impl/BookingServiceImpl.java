package com.codingworld.service1.book.service.impl;

import com.codingworld.service1.book.controller.BookingController;
import com.codingworld.service1.book.modal.Book;
import com.codingworld.service1.book.repository.BookingRepository;
import com.codingworld.service1.book.service.BookingService;
import com.codingworld.service1.comman.dto.User;
import com.codingworld.service1.comman.exception.ResoureNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService {

    Logger logger= LoggerFactory.getLogger(BookingController.class);

    @Autowired
    private RestTemplate template;

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public Book addBooking(Book book) {
        logger.info("BookingServiceImpl class {} and {}",book);
      /*  try {
            User user = template.getForObject("http://USER-SERVICE//user/name/" + name, User.class);
        }catch (Exception ex){
            logger.error("error in fetch user {}",ex);
        }*/
        logger.info("BookingServiceImpl class");
        return null;
    }

    @Override
    public List<Book> getAllBooking() {
        return bookingRepository.findAll();
    }

    @Override
    public Book findById(Long id) {
        Book book1=null;
        Optional<Book> book=bookingRepository.findById(id);
        if(book.isPresent()){
            book1=book.get();
        }else {
            throw new ResoureNotFoundException("Book id not available in database");
        }
        return book1;
    }

    @Override
    public void deleteBookingById(Long id) {
        Optional<Book> book=bookingRepository.findById(id);
        bookingRepository.delete(book.get());
    }
}
