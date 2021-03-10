package rich.zrc.pojo;

import org.springframework.beans.factory.FactoryBean;

public class MyFactoryBean implements FactoryBean<Airplane> {

    @Override
    public Airplane getObject() throws Exception {
        Airplane airPlane = new Airplane();
        airPlane.setType("中飞机");
        airPlane.setChibang("大翅膀");
        airPlane.setFadongji("大发动机");
        airPlane.setDabao("大炮");
        airPlane.setZhadan("大炸弹");
        airPlane.setJiguangdapao("黑色激光炮");
        return airPlane;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
