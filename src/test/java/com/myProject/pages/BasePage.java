package com.myProject.pages;

import com.myProject.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


public abstract class BasePage {

    public BasePage(){
        PageFactory.initElements(Driver.get(),this);
    }

    public void inputText(WebElement element, String text) {
        element.sendKeys(text);
    }

    public void refreshPage() {
        Driver.get().navigate().refresh();
    }


}
