package zrc.course.bite.bookmanager;

public class Book {
    private String name;
    private String author;
    private double price;
    private String type;
    private boolean isBorrowed = false;

    public Book(String name, String author, double price, String type) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.type = type;
    }

    @Override
    public String toString() {
        return "书籍【" +
                "名称:'" + name + '\'' +
                ", 作者:'" + author + '\'' +
                ", 价格:" + price +
                ", 类型:'" + type + '\'' +
                ", 是否借出:" + isBorrowed +
                '】';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }
}