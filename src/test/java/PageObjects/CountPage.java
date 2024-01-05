package PageObjects;

import Utilities.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CountPage extends BaseClass {

    public CountPage(WebDriver driver, WebDriverWait wait) {

        super(driver, wait);
        PageFactory.initElements(driver, this);
    }
    JavascriptExecutor js = (JavascriptExecutor) driver;
    private String readText;
    private static String dataCounted;
    private static String txt3;
    private static String txt1;
    private static String txt2;
    public static String getDataCounted() {
        return dataCounted;
    }
    public static String getTxt1() {
        return txt1;
    }
    public static String getTxt2() {
        return txt2;
    }
    public static String getTxt3() {
        return txt3;
    }

    public void countWebData(String Test1 ) throws InterruptedException, IOException {


        // Obtain the txt to test
        Path filePath = Paths.get(Test1);
        readText = new String(Files.readAllBytes(filePath));
        System.out.println("Original Text:\n" + readText);
        // Convert to lowercase and delete spaces
        readText = readText.toLowerCase().trim();
        // Convert jumps in spaces
        readText = readText.replaceAll("[\\n\\r]+", " ");
        driver.findElement(By.id("box")).sendKeys(readText);// get web count
        dataCounted = driver.findElement(By.xpath("//div[@id='top_counter']/div/h1/span ")).getText();
        System.out.println(dataCounted);
        String firstW = driver.findElement(By.xpath("//div[@id='kwd-accordion-data']/a")).getText();
        String first=  firstW.replaceAll("\\([^)]*\\)", "");
        // Convert the string so I can compare with my data
        txt1= first.replaceAll("\\n", "").trim();
        System.out.println(txt1);
        String secondW = driver.findElement(By.xpath("//div[@id='kwd-accordion-data']/a[2]")).getText();
        String second=  secondW.replaceAll("\\([^)]*\\)", "");
        txt2= second.replaceAll("\\n", "").trim();
        System.out.println(txt2);
        String thirdW = driver.findElement(By.xpath("//div[@id='kwd-accordion-data']/a[3]")).getText();
        // Eliminar contenido dentro de paréntesis
        String third = thirdW.replaceAll("\\([^)]*\\)", "");
        // Eliminar saltos de línea
        txt3 = third.replaceAll("\\n", "").trim();
        System.out.println("Texto original:\n" + txt3);
        System.out.println("\nText for validation:\n" + txt3);
    }
}
