package com.nchl.projectcrudoperation.controller;

import com.nchl.projectcrudoperation.dto.ApiResponseDTO;
import com.nchl.projectcrudoperation.dto.BookDTO;
import com.nchl.projectcrudoperation.entity.Book;
import com.nchl.projectcrudoperation.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/book")
@CrossOrigin(origins = "http://localhost:5174")
public class BookController {

    @Autowired
    BookService bookService;

    //    @PostMapping
//    public Book createBook(@RequestBody Book book){
//        return bookService.addBook(book);
//
//    }

    @PostMapping
    public ResponseEntity<ApiResponseDTO<BookDTO>> addBook(@RequestBody Book book) {
        BookDTO bookDTO = bookService.addBook(book);
        ApiResponseDTO<BookDTO> responseDTO = new ApiResponseDTO<>(
                LocalDateTime.now(),
                "success",
                "Book added successfully",
                bookDTO

        );
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

//    @GetMapping
//    public List<BookDTO> findAllBooks() {
//        return bookService.findAllBooks();
//    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseDTO<BookDTO>> findBook(@PathVariable Integer id){
        BookDTO bookDTO=bookService.findBookById(id);
        ApiResponseDTO<BookDTO> responseDTO=new ApiResponseDTO<>(
                LocalDateTime.now(),
                "success",
                "Book found",
                bookDTO
        );
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<ApiResponseDTO<List<BookDTO>>> findAllBooks() {
        List<BookDTO> bookDTOList = bookService.findAllBooks();
        ApiResponseDTO<List<BookDTO>> responseDTO = new ApiResponseDTO<>(
                LocalDateTime.now(),
                "success",
                "Here is the list of books",
                bookDTOList
        );
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

//    @PutMapping("/{id}")
//    public BookDTO updateBook(@PathVariable Integer id, @RequestBody Book book) {
//        return bookService.updateBookById(id, book);
//    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponseDTO<BookDTO>> updateBook(@PathVariable Integer id, @RequestBody Book book) {
        BookDTO updatedBookDTO = bookService.updateBookById(id, book);
        ApiResponseDTO<BookDTO> responseDTO = new ApiResponseDTO<>(
                LocalDateTime.now(),
                "success",
                "Book updated successfully",
                updatedBookDTO
        );
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);

    }

//    @DeleteMapping("/{id}")
//    public String deleteBook(@PathVariable Integer id) {
//        bookService.deleteBook(id);
//
//        return "Book deleted successfully";
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponseDTO<String>> deleteBook(@PathVariable Integer id) {
        String bookTitle= bookService.deleteBook(id);
        ApiResponseDTO<String> responseDTO =new ApiResponseDTO<>(
                LocalDateTime.now(),
                "success",
                String.format("Deleted book: %s", bookTitle),
                null
        );

        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
