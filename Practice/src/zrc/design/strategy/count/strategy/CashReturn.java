package zrc.design.strategy.count.strategy;

public class CashReturn extends CashSuper {
    int count;
    int returnCash;

    public CashReturn(int count, int returnCash) {
        this.count = count;
        this.returnCash = returnCash;
    }

    public double acceptCash(double money) {
        int intMoney = (int)money;
        double num = intMoney / count;
        return num > 0 ? money - count * num : money;
    }
}
