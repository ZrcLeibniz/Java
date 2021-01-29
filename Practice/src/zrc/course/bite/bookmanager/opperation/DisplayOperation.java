package zrc.course.bite.bookmanager.opperation;

import zrc.course.bite.bookmanager.BookList;

public class DisplayOperation implements IOperation {

    @Override
    public void work(BookList bookList) {
        for (int i = 0; i < bookList.getSize(); i++) {
            System.out.println(bookList.getBook(i));
        }
    }
}
