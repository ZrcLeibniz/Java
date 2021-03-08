package rich.zrc.pojo;

import java.util.ArrayList;
import java.util.List;

public class AirplaneFactory {
    public static Airplane getAirplane() {
        Airplane airplane = new Airplane();
        airplane.setChibang("大翅膀");
        airplane.setDaodan("大导弹");
        airplane.setDapao("大大炮");
        airplane.setFadongji("大发动机");
        airplane.setJiguangpao("大激光炮");
        airplane.setZuowei("大座位");
        List<String> arrayList = new ArrayList<>();
        arrayList.add("炸弹1");
        arrayList.add("炸弹2");
        arrayList.add("炸弹3");
        arrayList.add("炸弹4");
        arrayList.add("炸弹5");
        arrayList.add("炸弹6");
        airplane.setZhanda(arrayList);
        return airplane;
    }

    public Airplane getAirplaneII() {
        Airplane airplane = new Airplane();
        airplane.setChibang("大翅膀");
        airplane.setDaodan("大导弹");
        airplane.setDapao("大大炮");
        airplane.setFadongji("大发动机");
        airplane.setJiguangpao("大激光炮");
        airplane.setZuowei("大座位");
        List<String> arrayList = new ArrayList<>();
        arrayList.add("炸弹1");
        arrayList.add("炸弹2");
        arrayList.add("炸弹3");
        arrayList.add("炸弹4");
        arrayList.add("炸弹5");
        arrayList.add("炸弹6");
        airplane.setZhanda(arrayList);
        return airplane;
    }
}
