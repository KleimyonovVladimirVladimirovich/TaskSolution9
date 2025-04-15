package org.example;

import java.util.ArrayList;
import java.util.List;

// Задача 9 ---> Клеймёнов Владимир Владимирович ---> 209 группа.

public class SubsetGenerator {

    public static void main(String[] args) {
        int N = 5;
        int k = 3;
        List<List<Integer>> subsets = generateSubsets(N, k);
        System.out.println("Все " + k + "-элементы подмножества множества A из " + N + ":");
        for (List<Integer> subset : subsets) {
            System.out.println(subset);
        }
    }

    public static List<List<Integer>> generateSubsets(int N, int k) {
        List<List<Integer>> result = new ArrayList<>();
        generateSubsetsHelper(1, N, k, new ArrayList<>(), result);
        return result;
    }

    private static void generateSubsetsHelper(int start, int N, int k, List<Integer> currentSubset, List<List<Integer>> result) {
        if (currentSubset.size() == k) {
            result.add(new ArrayList<>(currentSubset));
            return;
        }
        for (int i = start; i <= N; i++) {
            currentSubset.add(i);
            generateSubsetsHelper(i + 1, N, k, currentSubset, result);
            currentSubset.remove(currentSubset.size() - 1);
        }
    }
}