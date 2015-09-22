package core;

import core.Author;
import core.Book;
import core.Library;

import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        City c=new City("Kazan");
        City d=new City("Moscow");

        Archive arr=new Archive();

        Library lib=new Library();
        Library lib2=new Library();
        lib.setName("Kazan State Lib");
        lib2.setName("Russian Main Library");

        Author Gogol=new Author("Gogol");
        Author Pushkin=new Author("Pushkin");
        Author Tolstoy=new Author("Tolstoy");

        Pushkin.addBook(new Book("111","Evgeniy Onegin","11.12.1812"));
        Pushkin.addBook(new Book("113", "Fairytails", "12.01.1888"));
        Gogol.addBook(new Book("112","Dead souls","10.11.1812"));
        Gogol.addBook(new Book("114", "Idiot", "01.01.1799"));
        Tolstoy.addBook(new Book("110","Peace and War","07.07.1807"));

        lib.addAuthor(Pushkin);
        lib.addAuthor(Gogol);
        arr.setLib(c, lib);

        lib2.addAuthor(Pushkin);
        lib2.addAuthor(Gogol);
        lib2.addAuthor(Tolstoy);
        arr.setLib(d, lib2);

        lib.removeBook(Pushkin,"111");

        System.out.println("Allright");
    }
}
