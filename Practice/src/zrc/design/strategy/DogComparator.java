package zrc.design.strategy;

public class DogComparator implements Comparator<Dog>{
    @Override
    public boolean compareTo(Dog t1, Dog t2) {
        if (t1.food > t2.food) {
            return false;
        } else {
            return true;
        }
    }
}
