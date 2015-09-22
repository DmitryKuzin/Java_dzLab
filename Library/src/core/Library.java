package core;

import core.Author;
import core.Book;
import core.iLibrary;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Created by kuzin on 9/21/2015.
 */
public class Library implements iLibrary {
    public Library(){}
    public Library(String name){
        setName(name);
    }
    public String getName(){
        return name;
    }

    private TreeMap<Author,TreeSet<Book>> library=new TreeMap<>();
    private String name;
    @Override
    public void setName(String n) {
        name=n;
    }

    @Override
    public void addAuthor(Author a) {
        library.put(a,a.getBooks());
    }

    @Override
    public void addBook(Author a, Book b) {
        TreeSet<Book> set=library.get(a);
        set.add(b);
        library.put(a,set);
    }
    @Override
    public List getCreation(Author a) {
        return new ArrayList<>(library.get(a));
    }//gets the list of books of an author

    @Override
    public TreeMap<Author,TreeSet<Book>> getAll() {
        return library;
    }

    @Override
    public boolean removeBook(Author a, String ISBN) {
        TreeSet<Book> books=library.get(a);
        boolean result=books.removeIf(u -> ISBN.equals(u.getISBM()));//lambda -> hello from java 8
        library.put(a,books);
        return result;
    }
}
