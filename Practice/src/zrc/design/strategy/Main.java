package zrc.design.strategy;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] a = {9, 2, 3, 5, 7, 1, 4};
        Cat[] cats = {new Cat(3, 3), new Cat(7, 7), new Cat(1, 1)};
        Dog[] dogs = {new Dog(3), new Dog(7), new Dog(1)};
        Sorter sorter = new Sorter();
        CatComparator catComparator = new CatComparator();
        DogComparator dogComparator = new DogComparator();
        sorter.sort(dogs, dogComparator);
        System.out.println(Arrays.toString(dogs));
    }
}
