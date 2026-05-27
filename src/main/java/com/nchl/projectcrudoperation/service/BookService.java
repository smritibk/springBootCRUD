package com.nchl.projectcrudoperation.service;

import com.nchl.projectcrudoperation.entity.Book;
import com.nchl.projectcrudoperation.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    // Create Book
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    // Get all Books
    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    //Delete Book by ID
    public void deleteBook(Integer id) {
        bookRepository.deleteById(id);
    }

    //Update Book by ID
    public Book updateBookById(Integer id, Book book) {
        Book existingBook = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));

        System.out.println(existingBook.getAuthor());
        existingBook.setTitle(book.getTitle());
        existingBook.setAuthor(book.getAuthor());
        existingBook.setGenre(book.getGenre());
        existingBook.setPrice(book.getPrice());
        existingBook.setAvailable(book.getAvailable());

        System.out.println(existingBook.getAuthor());
        return bookRepository.save(existingBook);
    }


}
