package org.example;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Task03 {
    public static void main(String[] args) {
        Map<Long, String> dictionary = new HashMap<>();
        dictionary.put(89116668866L, "Андрей");
        dictionary.put(89115556644L, "Сергей");
        dictionary.put(41356L, "Дмитрий");
        System.out.println(dictionary.get(dictionary.keySet().stream().min(Comparator.naturalOrder()).orElse(null)));

        String maxName = dictionary.values().stream().max(Comparator.naturalOrder()).orElse(null);
        System.out.println(dictionary.entrySet().stream().filter
                (entry -> entry.getValue().equals(maxName)).collect(Collectors.toList()));
    }


}
