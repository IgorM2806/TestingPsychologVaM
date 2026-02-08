package org.example.aboutMe;

import org.openqa.selenium.By;

public class AboutMeLocators {
    public static By headerLocator = By.id("Heading1");
    public static By mainPointLocator = By.cssSelector("#menu-list li:first-child a");
    public static By aboutMePointLocators = By.cssSelector("#menu-list li:nth-child(2) a");
    public static By educationPointLocator = By.cssSelector("#menu-list li:nth-child(3) a");
    public static By allPublicationsPointLocator = By.cssSelector("#menu-list li:nth-child(4) a");
    public static By contactsPointLocator = By.cssSelector("#menu-list li:nth-child(5) a");
    public static By controlElementContactsLocator = By.cssSelector("#wb_Text8 span");
    public static By submitApplicationPointLocator = By.cssSelector("#menu-list li:nth-child(6) a");
    public static By controlElementApplicationLocator = By.cssSelector("#wb_Text6 span");
}
