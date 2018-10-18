package Jarvis.test.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//登录页面
public class LoginPage {

    public static String loginPath = "/page/index";//登录页面的路径

    //登录方法使用的页面元素
    public static By loginNameInput = By.id("username");//用户名输入框
    public static By PasswordInput = By.id("password");//密码输入框
    public static By loginButton =By.xpath("/html/body/div/div/form/button");//登录按钮

    //退出方法使用的页面元素
    public static By JarvisLogoutButton = By.xpath("//*[@id=\"nav\"]/div/ul/li[16]");//jarvis的退出按钮
    public static By admin3LogoutButton = By.xpath("//*[@id=\"page-wrapper\"]/div[1]/nav/ul/li[2]/a");//3.0的退出按钮

    /**
     * 登录
     * @param driver
     * @param username
     * @param password
     */
    public static void login(WebDriver driver,String username,String password){

        driver.findElement(loginNameInput).clear();
        driver.findElement(loginNameInput).sendKeys(username);
        driver.findElement(PasswordInput).clear();
        driver.findElement(PasswordInput).sendKeys(password);
        driver.findElement(loginButton).sendKeys(password);
        driver.findElement(loginButton).click();

    }

    //jarvis页面的退出登录
    public static void logout(WebDriver driver){
        driver.findElement(JarvisLogoutButton).click();
    }

    //3.0旧页面的退出登录
    public static void logoutadmin3(WebDriver driver){
        driver.findElement(admin3LogoutButton).click();
    }
}