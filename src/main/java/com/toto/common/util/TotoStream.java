package com.toto.common.util;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Java Stream 예제를 통해 Stream 활용도를 확인한다.
 */
public class Stream {

    public static void main(String[] args) {
        Stream o = new Stream();
        o.streamFilter();
    }


    /* 1. Filter */
    private void streamFilter() {
        ArrayList<String> list = new ArrayList<String>(Arrays.asList("a","b","c"));
        list.stream()
                .filter("b"::equals)
                .forEach(System.out::println);
    }

    private void streamArray() {
        
    }
}
