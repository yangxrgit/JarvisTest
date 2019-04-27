package Jarvis.test.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
/*
BasePage类是所有page类的基类，包括初始化浏览器驱动和一些页面常见的操作。
 */
public class BasePage {

    //public WebDriver driver;

//    public BasePage(WebDriver driver) {
//        this.driver = driver;
//        //wait = new WebDriverWait((WebDriver) driver, 15);
//    }

    //封装Element方法
    public WebElement element(WebDriver driver,By by){
        WebElement element = driver.findElement(by);
        return  element;
    }

    //封装点击
    public void click(WebElement element) {
        if (element !=null){
            element.click();
        }else{
            System.out.println("元素没有定位到，点击失败");
        }
    }

    //封装输入
    public void sendKeys(WebElement element, String value) {
        if (element !=null){
            element.clear();
            element.sendKeys(value);
        }else{
            System.out.println("元素没有定位到，输入失败"+value);
        }
    }

    //判断元素是否显示
    public boolean assertElementIs(WebElement element){
        return element.isDisplayed();
    }

    //获取Text
    public String getText(WebElement element) {
        return element.getText();
    }

    public void assertEquals(WebElement element, String expectedText) {
        Assert.assertEquals(getText(element), expectedText);
    }

}


