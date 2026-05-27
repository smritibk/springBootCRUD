package com.nchl.projectcrudoperation.controller;

import com.nchl.projectcrudoperation.entity.Book;
import com.nchl.projectcrudoperation.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    BookService bookService;

//    @PostMapping
//    public Book createBook(@RequestBody Book book){
//        return bookService.addBook(book);
//
//    }

    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody Book book){
        return ResponseEntity.ok(bookService.addBook(book));
    }

    @GetMapping
    public List<Book> findAllBooks(){
        return bookService.findAllBooks();
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Integer id, @RequestBody Book book){
        return bookService.updateBookById(id, book);
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable Integer id){
        bookService.deleteBook(id);

        return "Book deleted successfully";
    }
}
