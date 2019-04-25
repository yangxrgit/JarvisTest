package Jarvis.test.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
/*
BasePage类是所有page类的基类，包括初始化浏览器驱动和一些页面常见的操作。
 */
public class BasePage {

    public WebDriver driver;
    public WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
    }

    public void waitVisibility(By by) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));

    }

    //点击
    public void click(By by) {
        waitVisibility(by);
        driver.findElement(by).click();
    }

    //输入框输入
    public void sendKeys(By by, String text) {
        waitVisibility(by);
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(text);
    }

    //获取Text
    public String getText(By by) {
        waitVisibility(by);
        return driver.findElement(by).getText();
    }

    public void assertEquals(By by, String expectedText) {
        waitVisibility(by);
        Assert.assertEquals(getText(by), expectedText);
    }
}


