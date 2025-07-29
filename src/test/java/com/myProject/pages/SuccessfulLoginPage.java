package com.myProject.pages;

import com.myProject.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SuccessfulLoginPage extends BasePage {

    @FindBy(id = "user-name")
    public WebElement usernameBox;

    @FindBy(id = "password")
    public WebElement passwordBox;

    @FindBy(id = "login-button")
    public WebElement loginButton;

    @FindBy(css = "div.form_group > #user-name + svg.error_icon")
    public WebElement usernameErrorIcon;

    @FindBy(css = "div.form_group > #password + svg.error_icon")
    public WebElement passwordErrorIcon;

    @FindBy(className = "error-message-container")
    public WebElement errorMessageContainer;

    public void login() {
        loginButton.click();
    }

    public boolean elementPresent(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }


}
