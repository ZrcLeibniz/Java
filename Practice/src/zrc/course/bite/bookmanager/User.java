package zrc.course.bite.bookmanager;

import zrc.course.bite.bookmanager.opperation.IOperation;

abstract public class User {
    protected String name;
    protected IOperation[] operations;

    public abstract int menu();

    public void doOperation(int choice, BookList bookList) {
        this.operations[choice - 1].work(bookList);
    }
}
