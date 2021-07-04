package rich.zrc;

import redis.clients.jedis.Jedis;

public class TestPing {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("1.117.100.152", 6379);
        jedis.auth("rich");
        System.out.println(jedis.ping());
    }
}
