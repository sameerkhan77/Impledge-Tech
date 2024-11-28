//Impledge Technical
import java.io.*;
import java.util.*;

public class CompoundWords {

    public static void main(String[] args) {
        String inputFile1 = "Input_01.txt";
        String inputFile2 = "Input_02.txt";

        processFile(inputFile1);
        processFile(inputFile2);
    }

    public static void processFile(String fileName) {
        try {
            // reading all the words from the file
            List<String> words = readWordsFromFile(fileName);
            
            // startTime -> to store start time
            long startTime = System.currentTimeMillis();

            // finding the longest and second longest compounded words
            String[] result = findLongestCompoundWords(words);

            // endTime -> to store end time
            long endTime = System.currentTimeMillis();
            long timeTaken = endTime - startTime;

            // print the results
            System.out.println("\nResults for file: " + fileName);
            System.out.println("Longest Compound Word: " + result[0]);
            System.out.println("Second Longest Compound Word: " + result[1]);
            System.out.println("Time taken to process file: " + timeTaken + " milliseconds");

        } catch (IOException e) {
            System.err.println("Error processing file: " + fileName);
            e.printStackTrace();
        }
    }

    public static List<String> readWordsFromFile(String fileName) throws IOException {
        List<String> words = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                words.add(line.trim());
            }
        }
        return words;
    }

    public static String[] findLongestCompoundWords(List<String> words) {
        // using a HashSet for efficient lookup
        Set<String> wordSet = new HashSet<>(words);
        List<String> compoundedWords = new ArrayList<>();

        for (String word : words) {
            if (isCompoundWord(word, wordSet)) {
                compoundedWords.add(word);
            }
        }

        // sorting compounded words by length in descending order
        compoundedWords.sort((a, b) -> b.length() - a.length());

        String longest = compoundedWords.size() > 0 ? compoundedWords.get(0) : "";
        String secondLongest = compoundedWords.size() > 1 ? compoundedWords.get(1) : "";

        return new String[]{longest, secondLongest};
    }

    public static boolean isCompoundWord(String word, Set<String> wordSet) {
        return isCompoundWordHelper(word, wordSet, true);
    }

    private static boolean isCompoundWordHelper(String word, Set<String> wordSet, boolean isOriginalWord) {
        // base case
        if (wordSet.contains(word) && !isOriginalWord) {
            return true;
        }

        for (int i = 1; i < word.length(); i++) {
            String prefix = word.substring(0, i);
            String suffix = word.substring(i);

            if (wordSet.contains(prefix) && isCompoundWordHelper(suffix, wordSet, false)) {
                return true;
            }
        }

        return false;
    }
}
