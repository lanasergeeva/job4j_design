package ru.job4j.ood.srp;

import java.util.LinkedList;
import java.util.List;

public class Library {
    private List<Book> books = new LinkedList<>();

    public Library(List<Book> books) {
        this.books = books;
    }

    public Book findByName(String name) {
        Book rsl = null;
        for (Book book : books) {
            if (book.getName().equals(name)) {
                rsl = book;
            }
        }
        return rsl;
    }

    public Book findByAuthor(String author) {
        Book rsl = null;
        for (Book book : books) {
            if (book.getName().equals(author)) {
                rsl = book;
            }
        }
        return rsl;
    }

    public void givingBook(Book book) {
        if (books.contains(book)) {
            books.remove(book);
        }
    }

    public void getBook(Book book) {
        if (!books.contains(book)) {
            books.add(book);
        }
    }
}
