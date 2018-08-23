package pl.coderslab;

import pl.coderslab.entity.Book;

public class BookValidator {

    public static boolean  validate(Book book){
        if(book.getTitle().equals("")){
          return false;
        }

        return true;
    }
}
