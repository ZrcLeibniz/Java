package zrc.design.strategy.count.factory;

import java.util.Scanner;

public class CashFactory {
    public CashSuper create(String s) {
        CashSuper cash = null;
        switch (s) {
            case "正常收费":
                cash = new CashNormal();
                break;
            case "打8折":
                cash = new CashRebate(8);
                break;
            case"满300减100":
                cash = new CashReturn(300, 100);
                break;
        }
        return cash;
    }
}
