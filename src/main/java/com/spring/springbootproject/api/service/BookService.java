package com.spring.springbootproject.api.service;

import com.spring.springbootproject.api.entities.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookService {

    private static List<Book> booklists = new ArrayList<>();

    static {
        booklists.add(new Book(1, "Java", "Shakti"));
        booklists.add(new Book(2, "CPP", "Sandeep"));
        booklists.add(new Book(3, "Python", "Jay"));
    }

    public List<Book> getBooksList() {
        return booklists;
    }

    public Book getBookById(int id) {
        return booklists.stream().filter(book -> book.getId() == id).findFirst().get();
    }

    public List<Book> addBooks(List<Book> books) {
        System.out.println("!! Book Adding Service Called !!");
        booklists.addAll(books);
        return books;
    }

    public List<Book> deleteBookById(int id) {
        System.out.println("!! Book Delete By ID Service Called !!");
        booklists = booklists.stream().filter(book -> book.getId() != id).collect(Collectors.toList());
        return booklists;
    }

    public Book updateBookById(Book book, int id) {
        System.out.println("!! Book Update By ID Service Called !!");
        booklists.stream().map(b -> {
            if (b.getId() == id) {
                b.setAuthor(book.getAuthor());
                b.setName(book.getName());
            }
            return b;
        }).collect(Collectors.toList());
        return book;
    }
}
