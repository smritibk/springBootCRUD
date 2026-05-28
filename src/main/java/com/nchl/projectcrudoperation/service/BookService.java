package com.nchl.projectcrudoperation.service;

import com.nchl.projectcrudoperation.dto.BookDTO;
import com.nchl.projectcrudoperation.entity.Book;
import com.nchl.projectcrudoperation.exception.BookNotFoundException;
import com.nchl.projectcrudoperation.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    //Convert to DTO
    public BookDTO mapToDTO(Book book) {
        return new BookDTO(
                book.getTitle(),
                book.getAuthor(),
                book.getGenre(),
                book.getPrice(),
                book.getAvailable()
        );
    }


    // Create Book
//    public Book addBook(Book book) {
//        return bookRepository.save(book);
//    }
    public BookDTO addBook(Book book) {
        Book savedBook = bookRepository.save(book);
        return mapToDTO(savedBook);
    }

    // Get all Books
//    public List<Book> findAllBooks() {
//        return bookRepository.findAll();
//    }

    // Get Book by ID
    public BookDTO findBookById(Integer id){
        Book existingBook=bookRepository.findById(id).orElseThrow(()->new BookNotFoundException("Book not found"));
        return mapToDTO(existingBook);

    }

    public List<BookDTO> findAllBooks() {
        List<Book> listBooks = bookRepository.findAll();
        List<BookDTO> bookDTOList = new ArrayList<>();

        for (Book book : listBooks) {
            BookDTO bookDTO = mapToDTO(book);

            bookDTOList.add(bookDTO);
        }
        return bookDTOList;
    }

    //Delete Book by ID
//    public void deleteBook(Integer id) {
//        bookRepository.deleteById(id);
//    }

    public String deleteBook(Integer id) {
        Book existingBook = bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException("Book not found"));
        String bookTitle=existingBook.getTitle();
        bookRepository.deleteById(id);
        return bookTitle;
    }

    //Update Book by ID
    public BookDTO updateBookById(Integer id, Book book) {
        Book existingBook = bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException("Book not found"));

        existingBook.setTitle(book.getTitle());
        existingBook.setAuthor(book.getAuthor());
        existingBook.setGenre(book.getGenre());
        existingBook.setPrice(book.getPrice());
        existingBook.setAvailable(book.getAvailable());

        Book savedBook = bookRepository.save(existingBook);
        return mapToDTO(savedBook);
    }


}
