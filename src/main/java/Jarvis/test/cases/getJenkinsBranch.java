package Jarvis.test.cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class getJenkinsBranch {

    public static String JenkinsPage ="http://10.10.2.222:8082";
    public static By usernameInput = By.xpath("//*[@id=\"j_username\"]");//用户名
    public static By passwordInput = By.xpath("/html/body/div/div/form/div[2]/input");//密码
    public static By loginButton = By.xpath("/html/body/div/div/form/div[3]/input"); //登录

    //登录
    public static void login(WebDriver driver) throws InterruptedException {
        //driver.findElement(usernameInput).clear();
        driver.findElement(usernameInput).sendKeys("yangxr"); //用户名输入
        //Thread.sleep(2000);
       // driver.findElement(passwordInput).clear();
        driver.findElement(passwordInput).sendKeys("123456");//密码输入
       // Thread.sleep(2000);
        driver.findElement(loginButton).click();//点击登录
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    //获取分支
    public static void getBranch(WebDriver driver){

        List<WebElement> list= driver.findElements(By.className(" job-status-blue"));
        List<String> jobList = new ArrayList<String>();

        for (int i=0;i<list.size();i++){
            String jobName = list.get(i).getAttribute("id").substring(4);
            jobList.add(jobName);
        }

        for (int i=0;i<jobList.size();i++){
            String url = "http://10.10.2.222:8082/job/"+jobList.get(i)+"/configure";
            driver.get(url);
            //driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            String branch = driver.findElement(By.xpath("//*[@id=\"main-panel\"]/div/div/div/form/table/tbody/tr[114]/td[3]/div/div[1]/table/tbody/tr[1]/td[3]/input")).getAttribute("value");
            System.out.println(jobList.get(i)+"分支："+branch);
        }
    }

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get(JenkinsPage);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        login(driver);
        getBranch(driver);
    }

}
