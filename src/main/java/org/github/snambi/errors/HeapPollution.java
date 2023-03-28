package org.github.snambi.errors;

import java.util.ArrayList;
import java.util.List;

public class HeapPollution {

    public static void main( String[] args ){

        List<String> strings = new ArrayList<>();

        strings.add("Hello");
        strings.add("world");

        List<Integer> ints = (List<Integer>)(Object) strings;

        Integer value = ints.get(0);

        System.out.printf("First value %d", value);
    }
}
