package Jarvis.test.cases;

import Jarvis.test.page.HomePage;
import Jarvis.test.page.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static Jarvis.test.page.LoginPage.loginPath;

//测试登录
public class LoginTest extends BaseTest{
    //验证登录是否成功，使用的页面元素
    //public By login_user = By.cssSelector("#page-wrapper > div.row.border-bottom > nav > ul > li.dropdown.hidden-xs > a > i");
    public By login_user = By.xpath("//*[@id=\"page-wrapper\"]/div[1]/nav/ul/li[1]/a/i");

    WebDriver driver;

//    @BeforeMethod
//    public void setUp(){
//        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//    }

    @Test //使用账户名和密码登录
    public void testLogin() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        driver.get(homePage.BaseUrl+loginPath);
        //调用登录
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(driver,"yangxr","123456");
        Thread.sleep(5000);
        //验证
        String loginUserInfo = driver.findElement(login_user).getText();
        Assert.assertEquals(loginUserInfo,"yangxr");
        //退出
        loginPage.logoutadmin3(driver);
    }

//    @AfterMethod
//    public void tearDown(){
//
//        driver.quit();
//    }
}
