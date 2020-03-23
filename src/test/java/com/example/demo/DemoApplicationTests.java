package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.xml.crypto.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.stream.Stream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Test
    public void streamTest(){
        Stream.generate(() -> new Random().nextInt(100)).limit(15).forEach(System.out::println);
    }

    @Test
    public void weiYunSuan(){
        int x = 3;
        int y = 4;
        x = x ^ y;
        y = x ^ y;
        x = x ^ y;
        System.out.println(x);
        System.out.println(y);
    }

    @Test
    public void daoJiShi() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        Long startTime = date.getTime()/1000;
        Date date1 = sdf.parse("2020-01-20 17:00:00");
        Long endTime = date1.getTime()/1000;
        Long time = endTime - startTime;
        while (time > 0){
            time--;
            try {
                Thread.sleep(1000);
                int hour = (int)(time / (60*60));
                long hh = time / 60 / 60 % 60;
                long mm = time / 60 % 60;
                long ss = time % 60;
                System.out.println("还剩" + hh + "小时" + mm + "分钟" + ss + "秒");
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

    }

    @Test
    public void ATest(){
        A a = new A();
        a = null;
        System.out.println(null != a);
    }

}
