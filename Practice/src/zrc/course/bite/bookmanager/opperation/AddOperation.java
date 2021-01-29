package zrc.course.bite.bookmanager.opperation;

import zrc.course.bite.bookmanager.Book;
import zrc.course.bite.bookmanager.BookList;

import java.util.Scanner;

public class AddOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("新增书籍");
        System.out.println("请输入新的书籍名称");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        System.out.println("请输入新书籍的作者");
        String author = scanner.next();
        System.out.println("请输入新书籍的价格");
        double price = scanner.nextDouble();
        System.out.println("请输入新书籍的类别");
        String type = scanner.next();
        Book book = new Book(name, author, price, type);
        bookList.setBook(bookList.getSize(), book);
        bookList.setSize(bookList.getSize() + 1);
        System.out.println("新增成功");
    }
}
