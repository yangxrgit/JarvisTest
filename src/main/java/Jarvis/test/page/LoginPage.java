package Jarvis.test.page;

import Jarvis.test.util.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//登录页面
public class LoginPage extends BasePage{

    //登录方法使用的页面元素
    public By loginNameInput = By.id("username");//用户名输入框
    public By PasswordInput = By.id("password");//密码输入框
    public By loginButton =By.xpath("/html/body/div/div/form/button");//登录按钮

    //退出方法使用的页面元素
    public By JarvisLogoutButton = By.xpath("//*[@id=\"nav\"]/div/ul/li[16]");//jarvis的退出按钮
    public By admin3LogoutButton = By.xpath("//*[@id=\"page-wrapper\"]/div[1]/nav/ul/li[2]/a");//3.0的退出按钮

    public LoginPage(WebDriver driver) {
        super(driver);
    }



    public LoginPage login(String username,String password){
        driver.get("http://uat-adminwow.rr.tv/page/index");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.info("输入用户名");
        sendKeys(element(loginNameInput),username);//用户名输入框，输入username
        Log.info("输入密码");
        sendKeys(element(PasswordInput),password);//密码输入框，输入password
        Log.info("点击登录");
        click(element(loginButton));
        Log.info("登录成功");
        return this;
    }

    //jarvis页面的退出登录
    public void logout(WebDriver driver){
        click(element(JarvisLogoutButton));
    }

    //3.0旧页面的退出登录
    public void logoutadmin3(WebDriver driver){
        click(element(admin3LogoutButton));
    }
}