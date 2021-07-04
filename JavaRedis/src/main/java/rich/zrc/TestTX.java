package rich.zrc;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

public class TestTX {
    public boolean transMethod() {
        Jedis jedis = new Jedis("1.117.100.152", 6379);
        jedis.auth("rich");
        int balance;
        int debt;
        int amtToSubtract = 10;
        balance = Integer.parseInt(jedis.get("balance"));
        jedis.watch("balance");
        if (balance < amtToSubtract) {
            jedis.unwatch();
            System.out.println("modify");
            return false;
        } else {
            System.out.println("******************");
            Transaction transaction = jedis.multi();
            transaction.decrBy("balance", amtToSubtract);
            transaction.incrBy("debt", amtToSubtract);
            transaction.exec();
            balance = Integer.parseInt(jedis.get("balance"));
            debt = Integer.parseInt(jedis.get("debt"));
            System.out.println(balance);
            System.out.println(debt);
            return true;
        }
    }

    public static void main(String[] args) {
        TestTX test = new TestTX();
        boolean b = test.transMethod();
        System.out.println(b);
    }
}
