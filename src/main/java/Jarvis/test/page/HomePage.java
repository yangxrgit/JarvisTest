package Jarvis.test.page;

import org.openqa.selenium.WebDriver;

/*
HomePage主要是唤起浏览器，进入到首页？
 */
public class HomePage extends BasePage{
    public HomePage(WebDriver driver){
        super(driver);
    }

    //切换环境
    public String BaseUrl = "http://uat-adminwow.rr.tv";
//    public String BaseUrl = "http://uat-adminwow.rr.tv";



}
