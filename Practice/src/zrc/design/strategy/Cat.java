package zrc.design.strategy;

public class Cat{
    int weight;
    int high;

    public Cat(int weight, int high) {
        this.weight = weight;
        this.high = high;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "weight=" + weight +
                ", high=" + high +
                '}';
    }
}
