package rich.zrc.pojo;

public class AirPlaneInstanceFactory {
    public Airplane getAirplane(String type) {
        Airplane airPlane = new Airplane(type);
        airPlane.setChibang("大翅膀");
        airPlane.setFadongji("大发动机");
        airPlane.setDabao("大炮");
        airPlane.setZhadan("大炸弹");
        airPlane.setJiguangdapao("黑色激光炮");
        return airPlane;
    }
}
