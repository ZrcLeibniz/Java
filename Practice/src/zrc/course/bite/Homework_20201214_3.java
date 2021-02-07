package zrc.course.bite;

public class Homework_20201214_3 {
    public static void main(String[] args) {
        Homework_20201214_3 test = new Homework_20201214_3();
        System.out.println(test.getBinaryOneNumber(14));
    }

    public int getBinaryOneNumber(int i) {
        int count = 0;
        while (i != 0) {
            i = i & (i - 1);
            count++;
        }
        return count;
    }
}
