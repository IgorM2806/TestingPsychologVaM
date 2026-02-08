package org.example.mainPage;

import org.openqa.selenium.By;

public class DataUploadLocators {
    public static By publicationBlockLocator = By.cssSelector("#Article1");
    public static By articleDateLocator = By.cssSelector("#Article1 .blogsubject");
    public static By contentLocator = By.cssSelector("#Article1 .blogtext span");
    public static By messageLocator = By.cssSelector("#Article1 span");
}
