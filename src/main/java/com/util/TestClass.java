package com.util;

import com.model.News;
import org.junit.Test;
import redis.clients.jedis.Jedis;


public class TestClass {


    public static void main(String[] args){
        System.out.println("测试");
    }


    @Test
    public void TestUser(){

        News news = new News();
        news.setTitle("ABCD");
        Jedis jedis = new Jedis("localhost",6379);
        jedis.set("title",news.getTitle());

        System.out.println(jedis.get("title"));

    }


}
