package zrc.course.bite.bookmanager.opperation;

import zrc.course.bite.bookmanager.BookList;

import java.util.Scanner;

public class DelOperation implements IOperation{
    @Override
    public void work(BookList bookList) {
        Scanner scanner = new Scanner("删除书籍");
        System.out.println("请输出要删除的书籍名字");
        String name = scanner.next();
        int i = 0;
        for (; i < bookList.getSize(); i++) {
            if (name.equals(bookList.getBook(i).getName())) {
                break;
            }
        }
        if (i >= bookList.getSize()) {
            System.out.println("书籍不存在，删除失败");
            return;
        }
        if (i == bookList.getSize() - 1) {
            bookList.setSize(bookList.getSize() - 1);
            System.out.println("删除成功");
            return;
        }
        bookList.setBook(i, bookList.getBook(bookList.getSize() - 1));
        bookList.setSize(bookList.getSize() - 1);
        System.out.println("删除成功");
    }
}
