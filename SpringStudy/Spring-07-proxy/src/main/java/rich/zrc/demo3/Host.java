package rich.zrc.demo3;

import rich.zrc.demo01.Rent;

public class Host implements Rent {
    @Override
    public void rent() {
        System.out.println("房东要出租房子");
    }
}
