Feature: As a Qa automator, I want to create a automation to test https://wordcounter.net/

  Scenario: Test with a long string of characters to validate the veracity of the content, in addition to testing words in another language. Finally, line jumps are not considered as a character
    Given  The information from the text file "Test1.txt" to be tested is collected and the internal count is done.
    When The web count the data sent "Test1.txt".
    Then It is validated that the values are correct

  Scenario: Test with words that have limit values, such as one letter and pronouns in English, special characters, numbers.Also test upper and lower case.
   Given The information from the text file "Test2.txt" with limit values to be tested is collected and the internal count is done.
    When The web count the data sent "Test2.txt".
    Then It is validated that the values are correct

  Scenario: Test compound words and urls.
    Given The information from the text file "Test3.txt" with url and compound values to be tested is collected and the internal count is done.
    When The web count the data sent "Test3.txt".
    Then It is validated that the values are correct

  Scenario: Test urls to see bad count in the global preloader.
    Given The information from the text file "Test4.txt" with url to be tested is collected and the internal count is done.
    When The web count the data sent "Test4.txt".
    Then It is validated that the values are correct