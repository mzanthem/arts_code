package io.github.mzanthem.leetcodetraining.test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Steamtest {

    public static void main(String[] args) {

        Stream.of("张三","李四","王二","张四五")
                .filter(x -> x.startsWith("张"))
                .mapToInt(String::length)
                .max()
                .ifPresent(System.out::println);

        System.out.println("--------------------");
        List<String> data = new ArrayList<>();
        data.add("张三");
        data.add("李四");
        data.add("王三");
        data.add("马六");
        data.stream()
                .filter(x -> x.length() == 2)
                .map(x -> x.replace("三","五"))
                .sorted()
                .filter(x -> x.contains("五"))
                .forEach(System.out::println);

        System.out.println("---------------");
        data.stream()
            .peek( x -> x = x + "1")
            .filter(x ->x.startsWith("张三"));

        data.forEach(System.out::println);

    }

}
