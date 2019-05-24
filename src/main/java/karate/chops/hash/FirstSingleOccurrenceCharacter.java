package karate.chops.hash;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

//abcab - c
//abccab - ""
//abcdeffffeaaabbafeec - d
//abcdeffffeaaabbafeecz - d
//abcdeffffeaaabbafeeczd - z

public class FirstSingleOccurrenceCharacter {
    public static void main(String... args) {
        System.out.println(getFirstSingleOccurrenceCharacter("abcab"));
        System.out.println(getFirstSingleOccurrenceCharacter("abccab"));
        System.out.println(getFirstSingleOccurrenceCharacter("abcdeffffeaaabbafeec"));
        System.out.println(getFirstSingleOccurrenceCharacter("abcdeffffeaaabbafeecz"));
        System.out.println(getFirstSingleOccurrenceCharacter("abcdeffffeaaabbafeeczd"));
    }

    private static String getFirstSingleOccurrenceCharacter(String s) {
        if (s == null || s.length() == 0)
            return null;

        Set<Character> firstOccurrence = new LinkedHashSet<>();
        Set<Character> multipleOccurrence = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (firstOccurrence.contains(c)) {
                firstOccurrence.remove(c);
                multipleOccurrence.add(c);
            } else if (!multipleOccurrence.contains(c)) {
                firstOccurrence.add(c);
            }
        }

        if (firstOccurrence.isEmpty())
            return "";
        return firstOccurrence.iterator().next().toString();
    }
}
