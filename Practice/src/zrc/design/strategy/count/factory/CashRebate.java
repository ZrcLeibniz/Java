package zrc.design.strategy.count.factory;

public class CashRebate extends CashSuper{
    private int rebate;

    public CashRebate(int rebate) {
        this.rebate = rebate;
    }

    @Override
    public double acceptCash(double money) {
        return money * (rebate / 10);
    }
}
