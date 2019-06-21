package karate.chops.trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllStringMatchingPrefix {
    private TrieNode trie = new TrieNode();

    public void add(String s) {
        if (s == null || s.length() == 0)
            return;

        TrieNode iter = trie;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!iter.children.containsKey(c)) {
                iter.children.put(c, new TrieNode());
            }
            iter = iter.children.get(c);
        }
        iter.words.add(s);
    }

    public List<String> getSuggestions(String prefix) {
        List<String> suggestions = new ArrayList<>();
        if (prefix == null || prefix.length() == 0)
            return suggestions;
        TrieNode iter = trie;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (!iter.children.containsKey(c))
                return suggestions;
            iter = iter.children.get(c);
        }
        getChildSuggestions(suggestions, iter);
        return suggestions;
    }

    private void getChildSuggestions(List<String> suggestions, TrieNode iter) {
        suggestions.addAll(iter.words);
        if (iter.children.isEmpty()) {
            return;
        }
        for (Map.Entry<Character, TrieNode> e : iter.children.entrySet()) {
            getChildSuggestions(suggestions, e.getValue());
        }
    }

    private class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        List<String> words = new ArrayList<>();
    }

    public static void main(String[] args) {
        FindAllStringMatchingPrefix instance = new FindAllStringMatchingPrefix();
        instance.add("bass");
        instance.add("basket");
        instance.add("baskets");
        instance.add("ball");
        instance.add("basketball");
        instance.add("hello");
        instance.add("he");
        instance.add("hell");
        instance.add("iron");

        printSuggestions(instance.getSuggestions("bas"), "bas");
        printSuggestions(instance.getSuggestions("he"), "he");
        printSuggestions(instance.getSuggestions("hel"), "hel");
        printSuggestions(instance.getSuggestions("basket"), "basket");
        printSuggestions(instance.getSuggestions("pra"), "pra");
    }

    private static void printSuggestions(List<String> suggestions, String prefix) {
        if (suggestions.isEmpty()) {
            System.out.println("no suggestions found for prefix: " + prefix);
            return;
        }
        System.out.println("suggestions for prefix: " + prefix);
        suggestions.stream().forEach(System.out::println);
    }
}
