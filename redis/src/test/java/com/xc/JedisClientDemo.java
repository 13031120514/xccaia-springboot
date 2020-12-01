package com.xc;


import com.xc.util.JedisConnectionUtils;
import redis.clients.jedis.Jedis;

public class JedisClientDemo {

    public static void main(String[] args) {


        Jedis jedis = JedisConnectionUtils.getJedis();

        jedis.set("xccaia", "xccaia1");
        String result = jedis.get("xccaia");
        System.out.println(result);
    }

}
