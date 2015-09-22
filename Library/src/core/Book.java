package core;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by kuzin on 9/21/2015.
 */
public class Book implements Comparable<Book>{
    public Book(){}
    public Book(String isbn,String name,String date_ddMMyyyy){
        setISBN(isbn);
        setName(name);
        try {
            setDate(date_ddMMyyyy);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    public Book(String isbn, Author a,String name,String date_ddMMyyyy){
       setISBN(isbn);
        setAuthor(a,true);
        setName(name);
        try {
            setDate(date_ddMMyyyy);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    private String ISBN;
    private Author author;
    private String name;
    private Date d;
    public String getISBM(){
        return ISBN;
    }
    public void setISBN(String isbn){
        ISBN=isbn;
    }
    public Author getAuthor(){
        return author;
    }
    public void setAuthor(Author a){
        author = a;
    }
    public void setAuthor(Author a,boolean sayAuthorAboutBook){
        if(sayAuthorAboutBook) {
            a.addBook(this);
        }
        author = a;
    }
    public String getName(){
        return name;
    }
    public void setName(String bookName){
        name=bookName;
    }
    public String getDate(){
        return new SimpleDateFormat().format(d);
    }
    public void setDate(String ddMMyyyy) throws ParseException {
        d=new SimpleDateFormat("dd.MM.yyyy").parse(ddMMyyyy);
    }
    @Override
    public int compareTo(Book o) {
        return getDate().compareTo(o.getDate());
    }

    @Override
    public boolean equals(Object obj) {
        return obj.hashCode()==hashCode();
    }

    @Override
    public int hashCode() {
        return new Integer(ISBN);
    }
}
