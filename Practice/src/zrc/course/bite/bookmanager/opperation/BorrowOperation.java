package zrc.course.bite.bookmanager.opperation;

import zrc.course.bite.bookmanager.BookList;

import java.util.Scanner;

public class BorrowOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("借阅书籍");
        System.out.println("请输入借阅书籍的名称");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        int i = 0;
        for (; i < bookList.getSize(); i++) {
            if (bookList.getBook(i).getName().equals(name)) {
                break;
            }
        }
        if (i >= bookList.getSize()) {
            System.out.println("书籍不存在");
            return;
        }
        if (bookList.getBook(i).isBorrowed()) {
            System.out.println("书籍已经被借出");
            return;
        }
        bookList.getBook(i).setBorrowed(true);
        System.out.println("借阅成功");
    }
}
