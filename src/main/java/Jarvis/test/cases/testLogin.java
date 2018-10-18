package Jarvis.test.cases;

import Jarvis.test.page.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static Jarvis.test.config.sysConfig.BaseUrl;
import static Jarvis.test.page.LoginPage.loginPath;

//测试登录
public class testLogin {
    //验证登录是否成功，使用的页面元素
    public By login_user = By.cssSelector("#page-wrapper > div.row.border-bottom > nav > ul > li.dropdown.hidden-xs > a > i");

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test //使用账户名和密码登录
    public void testLogin() throws InterruptedException {
        driver.get(BaseUrl+loginPath);
        //调用登录
        LoginPage.login(driver,"yangxr","123456");//用户名密码需要参数化--
        Thread.sleep(5000);
        //验证
        String loginUserInfo = driver.findElement(login_user).getText();
        Assert.assertEquals(loginUserInfo,"yangxr");
        //退出
        LoginPage.logoutadmin3(driver);
    }

    @AfterMethod
    public void tearDown(){

        driver.quit();
    }
}
