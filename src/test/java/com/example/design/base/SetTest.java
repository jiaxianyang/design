package com.example.design.base;

import org.assertj.core.util.Sets;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class SetTest {

    public static void main(String[] args) {
        Set<Long> sets1 = Sets.newHashSet();
        sets1.add(1L);
        Set<Long> sets2 = Sets.newHashSet();
        sets2.add(2L);

        Set<Set<Long>> sets = Sets.newHashSet();
        sets.add(sets1);
        sets.add(sets2);

        Set<Long> collect = sets.stream().flatMap(Collection::stream).collect(Collectors.toSet());
        System.out.println(collect);
    }
}
