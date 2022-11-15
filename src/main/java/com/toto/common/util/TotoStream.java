package com.toto.common.util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.*;

/**
 * Java Stream 예제를 통해 Stream 활용도를 확인한다.
 */
public class TotoStream {

    public static void main(String[] args) {
        TotoStream o = new TotoStream();
        // o.streamFilter(); // 1. Stream - Filter
        // o.streamArray(); // 2. Stream - 배열
        // o.streamBuilder(); // 3. Stream - Builder
        // o.streamGenerator(); // 4. Stream - Generator
        // o.streamIterator(); // 5. Stream - Iterator
        // o.streamEmpty(); // 6. Stream - empty Stream
        // o.streamPrimitive(); // 7. Stream - 기본형
        // o.streamRandom(); // 8. Stream - Random
        // o.streamDelimiter(); // 9. Stream - Delimiter
        // o.streamFileReader(); // 10. Stream - 파일 읽기
        // o.streamConcat(); // 11. Stream - Stream연결
        // o.streamFlatMap(); // 12. Stream - flatMap
        // o.streamSorted(); // 13. Stream - sorted
        // o.streamMatch(); // 14. Stream - Match
        o.streamPeek(); // 15. Stream - Peek

    }

    /* 1. Stream생성 - Filter */
    private void streamFilter() {
        ArrayList<String> list = new ArrayList<String>(Arrays.asList("a","b","c"));
        list.stream()
                .filter("b"::equals)
                .forEach(System.out::println);

        System.out.println("---------------------------------------------");

        Stream<Integer> stream = IntStream.range(1,10).boxed();
        List<Integer> iList =  stream.filter(o -> (o%2) == 0)
                .map(o -> o*10)
                .collect(Collectors.toList());
                // forEach(System.out::println);
        iList.stream().forEach(System.out::println);

    }

    /* 2. Stream생성 - 배열 */
    private void streamArray() {
        String[] array = new String[]{"a", "b", "c"};
        Stream<String> totoStream1 = Arrays.stream(array);
        Stream<String> totoStream2 = Arrays.stream(array, 1, 3); // 인덱스 1포함, 3제외 ("b", "c")
        totoStream2.forEach(System.out::println);
    }

    /* 3. Stream 생성 - Builder */
    private void streamBuilder() {
        Stream<String> stream = Stream.<String>builder()
                .add("Apple")
                .add("Banana")
                .add("Melon")
                .build();

        stream.collect(Collectors.toList()).forEach(System.out::println);
    }

    /* 4. Stream 생성 - Generator */
    private void streamGenerator() {
        Stream<String> stream = Stream.generate(() -> "Hello").limit(5);
        stream.forEach(System.out::println);

    }

    /* 5. Stream 생성 - Iterator */
    private void streamIterator() {
        Stream<Integer> stream = Stream.iterate(100, n -> n + 10).limit(5); // 100으로 시작해서 10씩 증가시킨다. 5개까지
        stream.forEach(System.out::println);
    }

    /* 6. Stream 생성 - empty Stream */
    private void streamEmpty() {
        Stream<String> stream = Stream.empty();
        stream.forEach(System.out::println);
    }

    /* 7. Stream 생성 - 기본형 */
    private void streamPrimitive() {
        IntStream intStream = IntStream.range(1,10);
        Stream<Integer> stream = IntStream.range(1,10).boxed(); // Generic 사용시 boxed 사용해야함.

        intStream.forEach(System.out::println);
        System.out.println("-----------------------------------");
        stream.forEach(System.out::println);
    }

    /* 8. Stream 생성 - Random*/
    private void streamRandom() {
        DoubleStream stream = new Random().doubles(3);
        stream.forEach(System.out::println);
    }

    /* 9. Stream 생성 - Delimiter */
    private void streamDelimiter() {
        Stream<String> stream = Pattern.compile(",").splitAsStream("Apple,Peach,Grape");
        stream.forEach(System.out::println);
    }

    /* 10. Stream 생성 - 파일 읽기 */
    private void streamFileReader() {
        Stream<String> stream = null;
        try {
            /**
             * vo.txt 파일내용
             * 손흥민
             * 이강인
             */
            stream = Files.lines(Paths.get("c:\\vo.txt"), Charset.forName("UTF-8"));
            stream.forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /* 11. Stream 생성 - Stream연결 */
    private void streamConcat() {
        Stream<String> stream1 = Stream.of("Apple", "Banana", "Melon");
        Stream<String> stream2 = Stream.of("Kim", "Lee", "Park");

        Stream<String> stream3 = Stream.concat(stream1, stream2);
        stream3.forEach(System.out::println);

    }

    /* 12. Stream 생성 - flatMap */
    private void streamFlatMap() {
        List<List<String>> list = Arrays.asList(Arrays.asList("A", "B", "C"),
                Arrays.asList("a", "b", "c"));
        List<String> flatList = list.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        flatList.stream().forEach(System.out::println);

    }

    /* 13. Stream - sorted */
    private void streamSorted() {
        List dummyList = List.of(
                new Tong("둘째바보", 48, "수원시", "조땡땡"),
                new Tong("첫째바보", 50, "남양주시","이땡땡"),
                new Tong("셋째바보", 42, "안양시","박땡땡")
        );

        List<Tong> rtnList = (List<Tong>) dummyList.stream()
                // .sorted(Comparator.comparing(Tong::getHomeTown))
                //.sorted(Comparator.comparing(Tong::getHomeTown).reversed())
                .sorted(Comparator.comparing(Tong::getAge, Comparator.reverseOrder())
                        // .thenComparing(Tong::getAge, Comparator.reverseOrder())
                        .thenComparing(Tong::getHomeTown, Comparator.reverseOrder())
                )
                .collect(Collectors.toList());
        System.out.println("-----------------------------------");
        rtnList.stream().forEach(System.out::println);
    }

    /* 14. Stream - Match */
    private void streamMatch() {
        /*
        allMatch() 모든 요소들이 매개값(Predicate)으로 주어진 조건을 만족하는지 조사
        anyMatch() 최소한 한 개의 요소가 주어진 조건에 만족하는지 조사
        noneMatch() 모든 요소들이 주어진 조건을 만족하지 않는지 조사
        */

        int[] intArr = {2, 4, 6};

        boolean result = Arrays.stream(intArr)
                .allMatch(a -> a%2 == 0);
        System.out.println("2의 배수? " + result);

        result = Arrays.stream(intArr)
                .anyMatch(a -> a%3 == 0);
        System.out.println("3의 배수가 하나라도 있나? " + result);

        result = Arrays.stream(intArr)
                .noneMatch(a -> a%3 == 0);
        System.out.println("3의 배수가 없나? " + result);
    }

    /* 15. Stream - Peek */
    private void streamPeek() {
        Stream<String> stream = Stream.of("Kim", "Lee", "Park");
        List peekList = stream.filter(s -> s.length() > 3)
                .peek(s -> System.out.println("peek length : " + s))
                .collect(Collectors.toList());
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Tong {
        private String name;
        private int age;
        private String homeTown;
        private String nick;
    }
}
