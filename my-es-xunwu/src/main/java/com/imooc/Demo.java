package com.imooc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by xuery on 2018/5/16.
 */
public class Demo {
    public static void main(String[] args) {
        String containerNo = "345";
        List<String> stringList = Arrays.asList(containerNo);
        System.out.println(stringList);

        List<String> areaCodes = new ArrayList<>();

        System.out.println(areaCodes.toString());

        System.out.println(areaCodes);

       List<String> result1 = areaCodes.stream().filter(areaCode->areaCode.equals("123")).collect(Collectors.toList());
        System.out.println(result1);

        Optional<String> result = areaCodes.stream().filter(areaCode->"def".equals(areaCode)).findAny();
        if(!result.isPresent()){
            System.out.println("empty");
        } else {
            System.out.println(result.get());
        }

        List<String> list = new ArrayList<>();
        System.out.println(list.contains(null));
    }
}
