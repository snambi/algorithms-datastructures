package org.github.snambi.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.random.RandomGenerator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {

    public static void main( String[] args ){

        Random random = new Random();

        IntStream ints = random.ints(100);


        System.out.printf("max = %d\n", ints.max().getAsInt());


        Stream.Builder<String> strs = Stream.builder();

        strs.accept("hh");
        strs.accept("fff");
        strs.accept("rrrr");

        System.out.printf("%s\n", strs.build().count());
    }
}
