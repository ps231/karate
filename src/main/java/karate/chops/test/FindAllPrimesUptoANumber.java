package karate.chops.test;

import java.util.*;

public class FindAllPrimesUptoANumber {
    public static void main(String[] args) {
        getAllPrimes(3).stream().forEach(System.out::println);
        System.out.println("--");
        getAllPrimes(2).stream().forEach(System.out::println);
        System.out.println("--");
        getAllPrimes(1).stream().forEach(System.out::println);
        System.out.println("--");
        getAllPrimes(18).stream().forEach(System.out::println);
        System.out.println("--");
    }

    public static List<Integer> getAllPrimes(int n) {
        Set<Integer> primeCandidates = new HashSet<>();
        if (n <= 1)
            return new ArrayList<>(primeCandidates);
        int i = 2;
        while (i <= n)
            primeCandidates.add(i++);
        for (int j = 2; j <= n; j++) {
            int multiple = 2;
            while (j * multiple <= n) {
                if (primeCandidates.contains(j * multiple)) {
                    primeCandidates.remove(j * multiple);
                }
                multiple++;
            }
        }
        return new ArrayList<>(primeCandidates);
    }
}