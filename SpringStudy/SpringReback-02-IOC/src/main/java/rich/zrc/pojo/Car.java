package rich.zrc.pojo;

public class Car {
    private String carName;
    private Integer price;
    private String color;

    @Override
    public String toString() {
        return "Car{" +
                "carName='" + carName + '\'' +
                ", price=" + price +
                ", color='" + color + '\'' +
                '}';
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public Car() {
    }

    public Car(String carName, Integer price, String color) {
        this.carName = carName;
        this.price = price;
        this.color = color;
    }
}
