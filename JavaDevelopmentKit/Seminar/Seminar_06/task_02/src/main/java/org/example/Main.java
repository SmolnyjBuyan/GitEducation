package org.example;


import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        ImmutableList<Character> name = Lists.charactersOf("Andrew");
        System.out.println("Andrew");
        System.out.println(name);
        List<Character> reverseName = Lists.reverse(name);
        System.out.println(reverseName);
        List<List<Character>> partition = Lists.partition(name, 2);
        System.out.println(partition);

        Set<Integer> first = ImmutableSet.of(1, 2, 3);
        Set<Integer> second = ImmutableSet.of(3, 4, 5);
        Set<Integer> union = Sets.union(first, second);
        System.out.println(union);
        Set<Integer> intersection = Sets.intersection(first, second);
        System.out.println(intersection);
        Set<Integer> difference = Sets.symmetricDifference(first, second);
        System.out.println(difference);
    }
}