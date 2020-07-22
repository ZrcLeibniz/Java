package zrc.io;

import java.io.Serializable;

public class Bean implements Serializable {
    private static final long serialVersionUID = -2488844184983199673L;
//    private static final long serialVersionUID = 1L;


    private int no;
    private String name;

    public Bean(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Bean{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
