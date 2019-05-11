package Jarvis.test.cases;

import Jarvis.test.page.LoginPage;
import Jarvis.test.util.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

//测试登录
public class LoginTest extends BaseTest{

    WebDriver driver = new ChromeDriver();

    //验证登录是否成功，使用的页面元素
    //public By login_user = By.cssSelector("#page-wrapper > div.row.border-bottom > nav > ul > li.dropdown.hidden-xs > a > i");
    public static By login_user = By.xpath("//*[@id=\"page-wrapper\"]/div[1]/nav/ul/li[1]/a/i");


    //使用账户名和密码登录
    @Test
    @Parameters({"username","password"})
    public void loginTest(String username,String password) throws InterruptedException {
        //调用登录
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username,password);
        Thread.sleep(5000);
        Log.info("登录测试用例执行完毕");
        //验证
        String loginUserInfo = driver.findElement(login_user).getText();
        Assert.assertEquals(loginUserInfo,"yangxr");
        //退出
        loginPage.logoutadmin3(driver);
    }

}
