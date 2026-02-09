package org.example.educationPage;

import org.openqa.selenium.By;

public class EducationPageLocators {
    public static By headerLocator = By.id("Heading1");
    public static By mainPointLocator = By.cssSelector("#menu-list li:first-child a");
    public static By secondPointLocator =  By.cssSelector("#menu-list li:nth-child(2) a");
    public static By fourthPointLocator = By.cssSelector("#menu-list li:nth-child(4) a");
    public static By fifthPointLocator = By.cssSelector("#menu-list li:nth-child(5) a");
    public static By fifthPointControlElementLocator = By.cssSelector("#wb_Text8 span");
    public static By sixPointLocator = By.cssSelector("#menu-list li:nth-child(6) a");
    public static By sixPointControlElementLocator =  By.cssSelector("#wb_Text6 span");
}
