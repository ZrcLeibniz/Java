package zrc.design.strategy;

public class CatComparator implements Comparator<Cat> {

    @Override
    public boolean compareTo(Cat t1, Cat t2) {
        if (t1.high > t2.high) {
            return false;
        } else {
            return true;
        }
    }
}
