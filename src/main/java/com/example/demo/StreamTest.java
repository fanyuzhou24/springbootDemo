package com.example.demo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("张三","张三","李四","王五");
        list.stream().distinct()
                .collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println(list.stream()
                .filter(item -> {
                return "李四".equals(item);
                }).collect(Collectors.toList()));
    }
}
