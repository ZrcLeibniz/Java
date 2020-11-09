package rich.zrc.demo01;

public class Proxy implements Rent {
    private Host host;

    public Proxy() {
    }

    public Proxy(Host host) {
        this.host = host;
    }

    @Override
    public void rent() {
        seeHouse();
        free();
        paper();
        host.rent();
    }

    public void seeHouse() {
        System.out.println("中介带你看房");
    }

    public void free() {
        System.out.println("收中介费");
    }

    public void paper() {
        System.out.println("签合同");
    }
}
