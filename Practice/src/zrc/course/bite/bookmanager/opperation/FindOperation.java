package zrc.course.bite.bookmanager.opperation;

import zrc.course.bite.bookmanager.BookList;

import java.util.Scanner;

public class FindOperation implements IOperation{
    @Override
    public void work(BookList bookList) {
        System.out.println("查找书籍");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要查找的书名");
        String name = scanner.next();
        for (int i = 0; i < bookList.getSize(); i++) {
            if (bookList.getBook(i).getName().contains(name)) {
                System.out.println(bookList.getBook(i).getName() + i);
                return;
            }
        }
        System.out.println("要查找的书籍不存在");
    }
}
