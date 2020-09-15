package zrc.design.strategy.count.factory;

public class CashNormal extends CashSuper{
    @Override
    public double acceptCash(double money) {
        return money;
    }
}
