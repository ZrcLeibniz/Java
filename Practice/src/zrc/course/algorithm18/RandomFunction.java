package zrc.course.algorithm18;

/*
给定一个函数f，可以1~5的数字等概率返回一个。请加工出1~7的数字等概率返回一个的函数g
 */
public class RandomFunction {
    public int f() {
        return (int) (Math.random() * 5) + 1;
    }

    public int random0And1() {
        int res = 0;
        do {
            res = f();
        } while (res == 3);
        return res > 3 ? 1 : 0;
    }

    public int g() {
        int res = 0;
        do {
            res = (random0And1() << 2 + random0And1() << 1 + random0And1());
        } while (res == 7);
        return res;
    }

    /*
    给定一个函数f，以p概率返回0，以1-p概率返回1。请加工出等概率返回0和1的的函数g
    p = 1/3
     */
    public int fII() {
        int res = (int) (Math.random() * 3 + 1);
        return res == 1 ? 0 : 1;
    }

    public int gII() {
        int result = 0;
        do {
            result = (random0And1() << 1 + random0And1());
        } while (result == 0 || result == 3);
        return result == 2 ? 1 : 0;
    }
}
