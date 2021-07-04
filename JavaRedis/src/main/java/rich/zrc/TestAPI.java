package rich.zrc;

import redis.clients.jedis.Jedis;

import java.util.Set;

public class TestAPI {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("1.117.100.152", 6379);
        jedis.auth("rich");
        jedis.set("k1", "v1");
        jedis.set("k2", "v2");
        jedis.set("k3", "v3");
        System.out.println(jedis.get("k1"));
        Set<String> keys = jedis.keys("*");
        for (String key : keys) {
            System.out.println(key);
        }
    }
}
