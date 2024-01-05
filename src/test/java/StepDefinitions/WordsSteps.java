package StepDefinitions;

import PageObjects.CountPage;
import PageObjects.WordsPage;
import PageObjects.ValidatePage;
import Utilities.PropertiesReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

public class WordsSteps {

    private WebDriver driver = Hooks.driver;
    private WebDriverWait wait;

    public WordsSteps() throws Exception {

        PropertiesReader propertiesReader = new PropertiesReader();
        this.wait = new WebDriverWait(driver, propertiesReader.getTimeout());
    }



    @Given("Link page")
    public void linkPage() throws InterruptedException {

        WordsPage link = new WordsPage(driver, wait);
       // link.clickButton();
    }

    @When("Move in windows")
    public void moveWindows() throws InterruptedException {

        WordsPage link = new WordsPage(driver, wait);
        //link.moveWindows();
    }



    @When("Submit email using \"(.*)\" and password using \"(.*)\"")
    public void submitEmailPassword(String email, String password) throws InterruptedException {

        ValidatePage login = new ValidatePage(driver, wait);
        CountPage home = new CountPage(driver, wait);

    }

    @Given("The information from the text file {string} to be tested is collected and the internal count is done.")
    public void theInformationFromTheTextFileToBeTestedIsCollectedAndTheInternalCountIsDone(String Test1) throws IOException, InterruptedException  {

            WordsPage word = new WordsPage(driver, wait);
        word.readTest(Arrays.asList(Test1));    }

    @When("The web count the data sent {string}.")
    public void theWebCountTheDataSent(String Test1) throws InterruptedException, IOException {
        CountPage count = new CountPage(driver, wait);
        count.countWebData(Test1);
    }

    @Then("It is validated that the values are correct")
    public void itIsValidatedThatTheValuesAreCorrect() throws IOException, InterruptedException {
        ValidatePage validate = new ValidatePage(driver, wait);
        validate.validateWebData();
    }

    @Given("The information from the text file {string} with limit values to be tested is collected and the internal count is done.")
    public void theInformationFromTheTextFileWithLimitValuesToBeTestedIsCollectedAndTheInternalCountIsDone(String Test2) throws IOException, InterruptedException {
        WordsPage word = new WordsPage(driver, wait);
        word.readTest(Arrays.asList(Test2));
    }

    @Given("The information from the text file {string} with url and compound values to be tested is collected and the internal count is done.")
    public void theInformationFromTheTextFileWithUrlAndCompoundValuesToBeTestedIsCollectedAndTheInternalCountIsDone(String Test3) throws IOException, InterruptedException{
        WordsPage word = new WordsPage(driver, wait);
        word.readTest(Arrays.asList(Test3));
    }

    @Given("The information from the text file {string} with url to be tested is collected and the internal count is done.")
    public void theInformationFromTheTextFileWithUrlToBeTestedIsCollectedAndTheInternalCountIsDone(String Test4) throws IOException, InterruptedException {
        WordsPage word = new WordsPage(driver, wait);
        word.readTest(Arrays.asList(Test4));
    }

    @Given("The information from the text file {string}.")
    public void theInformationFromTheTextFile(String Test1) throws IOException, InterruptedException {
        CountPage count = new CountPage(driver, wait);
        count.countWebData2(Test1);
    }
}
