package com.myProject.pages;

import com.myProject.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SuccessfulLoginPage extends BasePage {

//    WebDriver driver = Driver.get();

    @FindBy(id = "user-name")
    public WebElement usernameBox;

    @FindBy(id = "password")
    public WebElement passwordBox;

    @FindBy(id = "login-button")
    public WebElement loginButton;

    public void inputText(WebElement element, String text) {
        element.sendKeys(text);
    }

    public void login() {
        loginButton.click();
    }


}
