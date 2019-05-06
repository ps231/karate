package karate.chops.general;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ReadableSentence {

    public static void main(String[] args) {
        Set<String> dictionary = new HashSet<>();
        dictionary.add("this");
        dictionary.add("is");
        dictionary.add("a");
//        dictionary.add("we");
//        dictionary.add("some");
        dictionary.add("awesome");

        System.out.println(getReadableSentence("thisisawesome", dictionary));
    }

    private static String getReadableSentence(String text, Set<String> dictionary) {
        if (text == null || text.length() == 0 || dictionary == null || dictionary.size() == 0)
            throw new IllegalArgumentException("invalid input");

        List<Temp> wordList = new ArrayList<>();
        int endIndex = 0;
        int startIndex = 0;
        while (endIndex < text.length()) {
            Temp t = findNextWord(text, dictionary, text.substring(startIndex, endIndex), endIndex);
            if (t.wordFound) {
                wordList.add(t);
                startIndex = t.endIndex + 1;
                endIndex = t.endIndex + 1;
            } else {
                if (wordList.isEmpty())
                    return "cannot create a readable sentence";
                Temp removed = wordList.remove(wordList.size() - 1);
                startIndex = removed.endIndex + 1;
                endIndex = removed.endIndex + 1;
            }
        }
        if (!wordList.isEmpty())
            return printSentence(wordList);
        return "cannot create a readable sentence";
    }

    private static Temp findNextWord(String text, Set<String> dictionary, String intermediate, int current) {
        if (dictionary.contains(intermediate)) {
            return new Temp(intermediate, true, current - 1);
        }

        for (int i = current; i < text.length(); i++) {
            Temp temp = findNextWord(text, dictionary, intermediate + text.charAt(i), current + 1);
            if (temp.wordFound)
                return temp;
        }
        return new Temp("", false, -1);
    }

    private static String printSentence(List<Temp> wordList) {
        StringBuffer sb = new StringBuffer();
        for (Temp t : wordList)
            sb.append(t.word + " ");
        return sb.toString().substring(0, sb.toString().length() - 1);
    }

    private static class Temp {
        String word;
        boolean wordFound;
        int endIndex;

        public Temp(String word, boolean wordFound, int endIndex) {
            this.word = word;
            this.wordFound = wordFound;
            this.endIndex = endIndex;
        }
    }
}