package com.nchl.projectcrudoperation.controller;

import com.nchl.projectcrudoperation.dto.ApiResponseDTO;
import com.nchl.projectcrudoperation.dto.BookDTO;
import com.nchl.projectcrudoperation.entity.Book;
import com.nchl.projectcrudoperation.service.BookService;
import com.nchl.projectcrudoperation.utils.IdEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;


@Controller

public class BookController {

    @Autowired
    BookService bookService;

    //    @PostMapping
//    public Book createBook(@RequestBody Book book){
//        return bookService.addBook(book);
//
//    }

//    @PostMapping
//    public ResponseEntity<ApiResponseDTO<BookDTO>> addBook(@RequestBody Book book) {
//        BookDTO bookDTO = bookService.addBook(book);
//        ApiResponseDTO<BookDTO> responseDTO = new ApiResponseDTO<>(
//                LocalDateTime.now(),
//                "success",
//                "Book added successfully",
//                bookDTO
//
//        );
//        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
//    }

    @GetMapping("/books/add")
    public String bookAddForm(Model model){

        model.addAttribute("book", new Book()); // Creating an empty initializer for object Book

        return "add-book";
    }

    @PostMapping("/books/add")
    public String saveBook(@ModelAttribute("book") Book book){
        bookService.addBook(book);
        return "redirect:/books";
    }

//    @GetMapping
//    public List<BookDTO> findAllBooks() {
//        return bookService.findAllBooks();
//    }

    @GetMapping("/books")
    public String booksPage(Model model) {
//        String name="The Adventures of Huckleberry Finn";
//        model.addAttribute("bookName",name );

//        BookDTO bookDTO = new BookDTO(
//                "The Lord of the Rings", "J.R.R. Tolkein", "fantasy", 600.00, true
//        );
        List<BookDTO> bookDTO=bookService.findAllBooks();
//
        model.addAttribute("books", bookDTO);
        return "books";
    }


//    @GetMapping("/{id}")
//    public ResponseEntity<ApiResponseDTO<BookDTO>> findBook(@PathVariable Integer id){
//        BookDTO bookDTO=bookService.findBookById(id);
//        ApiResponseDTO<BookDTO> responseDTO=new ApiResponseDTO<>(
//                LocalDateTime.now(),
//                "success",
//                "Book found",
//                bookDTO
//        );
//        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
//    }
//
//    @GetMapping
//    public ResponseEntity<ApiResponseDTO<List<BookDTO>>> findAllBooks() {
//        List<BookDTO> bookDTOList = bookService.findAllBooks();
//        ApiResponseDTO<List<BookDTO>> responseDTO = new ApiResponseDTO<>(
//                LocalDateTime.now(),
//                "success",
//                "Here is the list of books",
//                bookDTOList
//        );
//        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
//    }

//    @PutMapping("/{id}")
//    public BookDTO updateBook(@PathVariable Integer id, @RequestBody Book book) {
//        return bookService.updateBookById(id, book);
//    }

//    @PutMapping("/{id}")
//    public ResponseEntity<ApiResponseDTO<BookDTO>> updateBook(@PathVariable Integer id, @RequestBody Book book) {
//        BookDTO updatedBookDTO = bookService.updateBookById(id, book);
//        ApiResponseDTO<BookDTO> responseDTO = new ApiResponseDTO<>(
//                LocalDateTime.now(),
//                "success",
//                "Book updated successfully",
//                updatedBookDTO
//        );
//        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
//
//    }

    @GetMapping("/books/update/{encodedId}")
    public String editForm(@PathVariable String encodedId, Model model){
        Integer id= IdEncoder.decode(encodedId);
        Book existingBook=bookService.findBookForUpdate(id);
//        BookDTO existingBookDTO=bookService.findBookById(id);

        model.addAttribute("book", existingBook);
        model.addAttribute("encodedId", IdEncoder.encode(existingBook.getId()));
        return "edit-book";
    }

    @PostMapping("/books/update/{encodedId}")
    public String updateBook(@PathVariable String encodedId,@ModelAttribute Book book){
        Integer id=IdEncoder.decode(encodedId);
        book.setId(id);
        bookService.updateBookById(id, book);
        return "redirect:/books";
    }

//    @DeleteMapping("/{id}")
//    public String deleteBook(@PathVariable Integer id) {
//        bookService.deleteBook(id);
//
//        return "Book deleted successfully";
//    }

//    @DeleteMapping("/{id}")
//    public ResponseEntity<ApiResponseDTO<String>> deleteBook(@PathVariable Integer id) {
//        String bookTitle= bookService.deleteBook(id);
//        ApiResponseDTO<String> responseDTO =new ApiResponseDTO<>(
//                LocalDateTime.now(),
//                "success",
//                String.format("Deleted book: %s", bookTitle),
//                null
//        );
//
//        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
//    }

    @GetMapping("/books/delete/{id}")
    public String deleteBook(@PathVariable Integer id){
        bookService.deleteBook(id);
        return "redirect:/books";
    }
}
