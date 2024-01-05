package PageObjects;

import Utilities.BaseClass;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public class ValidatePage extends BaseClass {
    public ValidatePage(WebDriver driver, WebDriverWait wait) {

        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    JavascriptExecutor js = (JavascriptExecutor) driver;
    int totalWords = WordsPage.getTotalWords();
    int totalCharacters = WordsPage.getTotalCharacters();
    String dataCounted = CountPage.getDataCounted();

    String word1 = WordsPage.getWord1();
    String word2 = WordsPage.getWord2();
    String word3 = WordsPage.getWord3();
    String txt1 = CountPage.getTxt1();
    String txt2 = CountPage.getTxt2();
    String txt3 = CountPage.getTxt3();
    public void validateWebData() throws InterruptedException, IOException {
        // Extract numbers from the dataCounted string
        int[] numberDataC = extractNumbers(dataCounted);

        // Compare the extracted values with the expected values
        //Words are my logic data and txts are the web data
        try {
            verifyNumbers(numberDataC, totalWords, totalCharacters);
            System.out.println("The tests are correct.");
            // Verify that word1 is equal to txt1

            if (word1.equals(txt1)) {
                System.out.println("The string are equals.");
            } else {
                System.out.println("The string are different.");
                System.out.println(txt1);
                System.out.println(word1);
                throw new AssertionError("The fist word is different Because the program does not count compound words well and counts the words one by one in a url .");
            }

            if (word2.equals(txt2)) {
                System.out.println("The string are equals.");
            } else {
                System.out.println("The string are different.");
                System.out.println(txt2);
                System.out.println(word2);
                throw new AssertionError("The second word is different because because in the first word the counting of uppercase and lowercase letters was tested but from the second word the limit values are counted ( individual letters, numbers, pronouns in English, special characters) and these are not counted by the application.");

            }

            if (word3.equals(txt3)) {
                System.out.println("The string are equals.");
            } else {
                System.out.println("The string are different.");
                System.out.println(txt3);
                System.out.println(word3);
                throw new AssertionError("The third word is different.");

            }

            System.out.println("The test are correct.");
        } catch (AssertionError e) {
            System.out.println("Error: " + e.getMessage());
            throw new AssertionError("The test failed due to the following exception:" + e.getMessage());
        }
    }

    private static int[] extractNumbers(String chain) {
        // Split the chain by spaces and extract the numbers
        String[] parts = chain.split("\\D+");
        // \\D+ matches any non-digit

        int[] numbers = new int[parts.length];
        // Convert parts to numbers
        for (int i = 0; i < parts.length; i++) {
            numbers[i] = Integer.parseInt(parts[i]);
        }
        return numbers;
    }
    private static void verifyNumbers(int[] numbersDataC, int totalWords, int totalCharacthers) {
        // Verify that numbers are equal

        if (numbersDataC.length >= 1 && numbersDataC[0] != totalWords) {
            throw new AssertionError("The number of words on the page does not match the expected value.");
        }
        if (numbersDataC.length >= 2 && numbersDataC[1] != totalCharacthers) {

            throw new AssertionError("The number of characters on the page does not match the expected value.");
        }
    }

}