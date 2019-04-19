package karate.chops.hash;


import java.util.*;


// Parents are above children:

// 1   2   4
//  \ /   / \
//   3   5   8
//    \ / \   \
//     6   7   10

// Write a function that takes the graph, as well as two of the individuals in our dataset, as its inputs and returns true if and only if they share at least one ancestor.

// Sample input and output:

// hasCommonAncestor(parentChildPairs, 3, 8) => false
// hasCommonAncestor(parentChildPairs, 5, 8) => true
// hasCommonAncestor(parentChildPairs, 6, 8) => true
// hasCommonAncestor(parentChildPairs, 1, 3) => false

class FamilyGraph {


    private static boolean hasCommonAncestor(int[][] parentChildPairs, int p1, int p2) {

        Map<Integer, List<Integer>> familyMap = new HashMap<>();

        for (int[] pair : parentChildPairs) {
            if (!familyMap.containsKey(pair[1])) {
                familyMap.put(pair[1], new ArrayList<Integer>());
            }
            List<Integer> existingParents = familyMap.get(pair[1]);
            existingParents.add(pair[0]);
            familyMap.put(pair[1], existingParents);

            if (!familyMap.containsKey(pair[0])) {
                familyMap.put(pair[0], new ArrayList<Integer>());
            }
        }

        List<Integer> p1Ancestors = findAncestor(familyMap, p1);
        List<Integer> p2Ancestors = findAncestor(familyMap, p2);

        boolean foundAncestor = getIntersection(p1Ancestors, p2Ancestors);
        return foundAncestor;
    }


    private static boolean getIntersection(List<Integer> p1, List<Integer> p2) {
        Set<Integer> s1 = new HashSet<>(p1);

        for (int i : p2) {
            if (s1.contains(i))
                return true;
        }

        return false;
    }


    private static List<Integer> findAncestor(Map<Integer, List<Integer>> familyMap, int p) {
        List<Integer> ancestors = new ArrayList<>();
        helper(familyMap, p, ancestors);
        return ancestors;
    }

    private static void helper(Map<Integer, List<Integer>> familyMap, Integer p, List<Integer> ancestors) {
        if (familyMap.get(p).isEmpty())
            return;

        for (int i = 0; i < familyMap.get(p).size(); i++) {
            ancestors.add(familyMap.get(p).get(i));
            helper(familyMap, familyMap.get(p).get(i), ancestors);
        }
    }

    // Your function here:

    private static FamilyResults findNodesWithZeroAndOneParents(int[][] parentChildPairs) {

        //check for input

        Map<Integer, List<Integer>> familyMap = new HashMap<>();

        for (int[] pair : parentChildPairs) {
            if (!familyMap.containsKey(pair[1])) {
                familyMap.put(pair[1], new ArrayList<Integer>());
            }
            List<Integer> existingParents = familyMap.get(pair[1]);
            existingParents.add(pair[0]);
            familyMap.put(pair[1], existingParents);

            if (!familyMap.containsKey(pair[0])) {
                familyMap.put(pair[0], new ArrayList<Integer>());
            }
        }

        FamilyResults results = new FamilyResults();

        List<Integer> zeroParentIndividuals = new ArrayList<>();
        List<Integer> oneParentIndividuals = new ArrayList<>();

        for (int person : familyMap.keySet()) {
            if (familyMap.get(person).size() == 0)
                zeroParentIndividuals.add(person);
            if (familyMap.get(person).size() == 1)
                oneParentIndividuals.add(person);
        }
        results.individualsWithZeroParents = zeroParentIndividuals;
        results.individualsWithOneParent = oneParentIndividuals;

        return results;
    }


    private static class FamilyResults {
        List<Integer> individualsWithZeroParents;
        List<Integer> individualsWithOneParent;

        //getter,setters
    }

    public static void main(String[] args) {
        // { parent, child }
        int[][] parentChildPairs = new int[][]{
                {1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7},
                {4, 5}, {4, 8}, {8, 10}
        };

        FamilyResults results = findNodesWithZeroAndOneParents(parentChildPairs);

        System.out.println(results.individualsWithZeroParents);

        System.out.println(results.individualsWithOneParent);


        System.out.println(hasCommonAncestor(parentChildPairs, 6, 8));
        System.out.println(hasCommonAncestor(parentChildPairs, 1, 3));
        System.out.println(hasCommonAncestor(parentChildPairs, 5, 8));
        System.out.println(hasCommonAncestor(parentChildPairs, 8, 3));

    }
}



