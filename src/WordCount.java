import java.io.*;
import java.util.*;
import java.util.regex.*;

public class WordCount {
    public static void main(String[] args) {
       
        String filePath = "input.txt";

        
        Map<String, Integer> wordCountMap = new TreeMap<>();

        
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                
                processLine(line, wordCountMap);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        
        displayWordCounts(wordCountMap);
    }

    private static void processLine(String line, Map<String, Integer> wordCountMap) {
        
        line = line.toLowerCase();

        
        Pattern pattern = Pattern.compile("\\b\\w+\\b");
        Matcher matcher = pattern.matcher(line);

        while (matcher.find()) {
            String word = matcher.group();

          
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
        }
    }

    private static void displayWordCounts(Map<String, Integer> wordCountMap) {
        for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
