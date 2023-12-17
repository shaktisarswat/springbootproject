package com.spring.springbootproject.api.controller;

import com.spring.springbootproject.api.entities.Book;
import com.spring.springbootproject.api.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    //    @ResponseBody // when we use restcontroller
//    @RequestMapping(value = "/books", method = RequestMethod.GET)
    @GetMapping("/books") // above line can be combined in this keyword
    public List<Book> getBooks() {
        System.out.println("!! Books controller called !!");
        return bookService.getBooksList();
    }

    @GetMapping("/books/{id}")
    public Book getBook(@PathVariable("id") int id) {
        System.out.println("!! Book controller by Id called !!");
        return bookService.getBookById(id);
    }

    @PostMapping("/books")
    public List<Book> addBooks(@RequestBody List<Book> bookList) {
        System.out.println("!! Books Adding Controller Called !!");
        return bookService.addBooks(bookList);
    }

    @DeleteMapping("/books/{id}")
    public List<Book> deleteBook(@PathVariable("id") int id) {
        System.out.println("!! Delete Book Controller Called !!");
        return bookService.deleteBookById(id);
    }

    @PutMapping("/books/{id}")
    public Book updateBook(@RequestBody Book book, @PathVariable("id") int id)
    {
        System.out.println("!! Update Book Controller Called !!");
        return bookService.updateBookById(book, id);
    }
}
