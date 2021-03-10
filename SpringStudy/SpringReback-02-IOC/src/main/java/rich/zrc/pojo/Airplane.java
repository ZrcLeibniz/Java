package rich.zrc.pojo;

public class Airplane {
    private String type;
    private String chibang;
    private String fadongji;
    private String dabao;
    private String jiguangdapao;
    private String zhadan;

    public Airplane() {
    }

    public Airplane(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Airplane{" +
                "type='" + type + '\'' +
                ", chibang='" + chibang + '\'' +
                ", fadongji='" + fadongji + '\'' +
                ", dabao='" + dabao + '\'' +
                ", jiguangdapao='" + jiguangdapao + '\'' +
                ", zhadan='" + zhadan + '\'' +
                '}';
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getChibang() {
        return chibang;
    }

    public void setChibang(String chibang) {
        this.chibang = chibang;
    }

    public String getFadongji() {
        return fadongji;
    }

    public void setFadongji(String fadongji) {
        this.fadongji = fadongji;
    }

    public String getDabao() {
        return dabao;
    }

    public void setDabao(String dabao) {
        this.dabao = dabao;
    }

    public String getJiguangdapao() {
        return jiguangdapao;
    }

    public void setJiguangdapao(String jiguangdapao) {
        this.jiguangdapao = jiguangdapao;
    }

    public String getZhadan() {
        return zhadan;
    }

    public void setZhadan(String zhadan) {
        this.zhadan = zhadan;
    }
}
