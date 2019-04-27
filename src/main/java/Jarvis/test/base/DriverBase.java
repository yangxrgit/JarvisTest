package Jarvis.test.base;

import org.openqa.selenium.WebDriver;

public class DriverBase {
    public WebDriver driver;
    public DriverBase(String browser){
        SelectDriver selectDriver = new SelectDriver();
        this.driver = selectDriver.driverName(browser);
    }

    //例子：封装一个driver的关闭方法
    public void stop(){
        System.out.println("stop webdriver");
        driver.close();
    }

}
