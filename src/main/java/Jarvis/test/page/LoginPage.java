package Jarvis.test.page;

import Jarvis.test.util.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//登录页面
public class LoginPage extends BasePage{

    public static String loginPath = "/page/index";//登录页面的路径

    //登录方法使用的页面元素
    public static By loginNameInput = By.id("username");//用户名输入框
    public static By PasswordInput = By.id("password");//密码输入框
    public static By loginButton =By.xpath("/html/body/div/div/form/button");//登录按钮

    //退出方法使用的页面元素
    By JarvisLogoutButton = By.xpath("//*[@id=\"nav\"]/div/ul/li[16]");//jarvis的退出按钮
    By admin3LogoutButton = By.xpath("//*[@id=\"page-wrapper\"]/div[1]/nav/ul/li[2]/a");//3.0的退出按钮

    public LoginPage(WebDriver driver) {

    }

//    //获取用户名输入框
//    public WebElement getUserElement(){
//        return element(getByLocator.getLocator("username"));
//    }
//    //获取密码输入框Element
//    public WebElement getPasswordElement(){
//        return element(getByLocator.getLocator("userpass"));
//    }
//    //获取登录按钮element
//    public WebElement getLoginButtonElement(){
//        return element(getByLocator.getLocator("loginbutton"));
//    }
//    //获取自动登录
//    public WebElement getAutoSigninElement(){
//        return element(getByLocator.getLocator("autoSignin"));
//    }
//
//    public By getLoginButton() {
//        return loginButton;
//    }

    /**
     * 登录
     * @param driver
     * @param username
     * @param password
     */

    public LoginPage login(WebDriver driver,String username,String password){
        driver.get("http://adminwow.rr.tv/page/index");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.info("输入用户名");
        sendKeys(element(driver,loginNameInput),username);//用户名输入框，输入username
        Log.info("输入密码");
        sendKeys(element(driver,PasswordInput),password);//密码输入框，输入password
        Log.info("点击登录");
        click(element(driver,loginButton));
        Log.info("登录成功");
        return this;
    }

    //jarvis页面的退出登录
    public void logout(WebDriver driver){
        click(element(driver,JarvisLogoutButton));
    }

    //3.0旧页面的退出登录
    public void logoutadmin3(WebDriver driver){
        click(element(driver,admin3LogoutButton));
    }
}