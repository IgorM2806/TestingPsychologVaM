package org.example.mainPage;

import org.openqa.selenium.By;

public class ContactFormsLocators {
    public static By cFMailElementLocator = By.cssSelector("#wb_Text8");
    public static By mailElementLocator = By.cssSelector("#formListView li:first-child p");
    public static By callMeLocator = By.cssSelector("#formListView li:nth-child(2) p");
    public static By locationLocator =  By.cssSelector("#formListView li:nth-child(3) p");
}
