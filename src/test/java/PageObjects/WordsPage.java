package PageObjects;
import Utilities.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
public class WordsPage extends BaseClass {
    public WordsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }
    private String readText;
    private static int totalWords;
    private static int totalCharacters;
    private static String word1 = null;
    private static String word2 = null;
    private static String word3 = null;
    public static int getTotalWords() {
        return totalWords;
    }
    public static int getTotalCharacters() {
        return totalCharacters;
    }
    public static String getWord1() {
        return word1;
    }
    public static String getWord2() {
        return word2;
    }
    public static String getWord3() {
        return word3;
    }




        public void readTest(List<String> testFiles) throws InterruptedException, IOException {
            for (String testFile : testFiles) {
                Path filePath = Paths.get(testFile);
                // Read the string array to process
                readText = new String(Files.readAllBytes(filePath));
                // Logic to process
                System.out.println("Processing file: " + testFile);


                System.out.println("Texto original:\n" + readText);
                readText = readText.toLowerCase().trim();
                readText = readText.replaceAll("[\\n\\r]+", " ");
                // Obtain words array
                String[] words = countWords(readText);
                // Found the most repeated word
                Map<String, Integer> counterWords = new HashMap<>();
                for (String word : words) {
                    counterWords.put(word, counterWords.getOrDefault(word, 0) + 1);
                }
                // Order the map for frequency of words
                List<Map.Entry<String, Integer>> listOrderedWords = new ArrayList<>(counterWords.entrySet());
                listOrderedWords.sort(Map.Entry.<String, Integer>comparingByValue().reversed());
                // Show and save the three words more repeated
                int counter = 0;
                for (Map.Entry<String, Integer> entry : listOrderedWords) {
                    if (counter < 3) {
                        System.out.println("Word: " + entry.getKey() + ", Repeats: " + entry.getValue());
                        counter++;
                        // Asociar las words a las variables
                        if (counter == 1) {
                            word1 = entry.getValue() + " " + entry.getKey();
                        } else if (counter == 2) {
                            word2 = entry.getValue() + " " + entry.getKey();
                        } else if (counter == 3) {
                            word3 = entry.getValue() + " " + entry.getKey();
                        }
                    } else {
                        break;
                    }
                }
// Show the results
                System.out.println(word1);
                System.out.println(word2);
                System.out.println(word3);
                //// Count total words y characters
                totalWords = words.length;
                totalCharacters = readText.length();
                // show the results
                System.out.println("Total words: " + totalWords);
                System.out.println("Total characters: " + totalCharacters);
            }
    }
            private static String[] countWords (String texto){
                return texto.split("\\s+");
            }
        }

