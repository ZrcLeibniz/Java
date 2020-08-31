package zrc.simulate;

public class Oracle implements JDBC{
    @Override
    public void generation() {
        System.out.println("连接Oracle数据库");
    }
}
