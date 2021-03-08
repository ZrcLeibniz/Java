package rich.zrc.pojo;

import java.util.List;

public class Airplane {
    private String fadongji;
    private String chibang;
    private String dapao;
    private String daodan;
    private String jiguangpao;
    private String zuowei;
    private List<String> zhanda;

    public Airplane() {
    }

    public Airplane(String fadongji, String chibang, String dapao, String daodan, String jiguangpao, String zuowei, List<String> zhanda) {
        this.fadongji = fadongji;
        this.chibang = chibang;
        this.dapao = dapao;
        this.daodan = daodan;
        this.jiguangpao = jiguangpao;
        this.zuowei = zuowei;
        this.zhanda = zhanda;
    }

    public String getFadongji() {
        return fadongji;
    }

    public void setFadongji(String fadongji) {
        this.fadongji = fadongji;
    }

    public String getChibang() {
        return chibang;
    }

    public void setChibang(String chibang) {
        this.chibang = chibang;
    }

    public String getDapao() {
        return dapao;
    }

    public void setDapao(String dapao) {
        this.dapao = dapao;
    }

    public String getDaodan() {
        return daodan;
    }

    public void setDaodan(String daodan) {
        this.daodan = daodan;
    }

    public String getJiguangpao() {
        return jiguangpao;
    }

    public void setJiguangpao(String jiguangpao) {
        this.jiguangpao = jiguangpao;
    }

    public String getZuowei() {
        return zuowei;
    }

    public void setZuowei(String zuowei) {
        this.zuowei = zuowei;
    }

    public List<String> getZhanda() {
        return zhanda;
    }

    public void setZhanda(List<String> zhanda) {
        this.zhanda = zhanda;
    }

    @Override
    public String toString() {
        return "Airplane{" +
                "fadongji='" + fadongji + '\'' +
                ", chibang='" + chibang + '\'' +
                ", dapao='" + dapao + '\'' +
                ", daodan='" + daodan + '\'' +
                ", jiguangpao='" + jiguangpao + '\'' +
                ", zuowei='" + zuowei + '\'' +
                ", zhanda=" + zhanda +
                '}';
    }
}
