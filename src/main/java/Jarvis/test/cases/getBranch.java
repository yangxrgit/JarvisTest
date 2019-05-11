package Jarvis.test.cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static Jarvis.test.cases.getJob.JenkinsPage;
import static Jarvis.test.cases.getJob.login;

public class getBranch {


    //获取分支
    public static void getBranch(WebDriver driver) throws IOException {

        //从F:\JenkinsJob\jobList.txt中获取job生成jobList
        String job;
        List jobList = new ArrayList<String>();
        BufferedReader br = new BufferedReader(new FileReader("F:\\JenkinsJob\\jobList.txt"));
        while ((job = br.readLine())!=null){
            jobList.add(job);
        }
        br.close();

        //获取分支名字
        for (int i=0;i<jobList.size();i++){
            String url = "http://10.10.2.222:8082/job/"+jobList.get(i)+"/configure";
            driver.get(url);
            //driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            String branch = driver.findElement(By.xpath("//*[@id=\"main-panel\"]/div/div/div/form/table/tbody/tr[114]/td[3]/div/div[1]/table/tbody/tr[1]/td[3]/input")).getAttribute("value");
            System.out.println(jobList.get(i)+"分支："+branch);
        }
    }

    public static void main(String[] args) throws InterruptedException, IOException {

        WebDriver driver = new ChromeDriver();
        driver.get(JenkinsPage);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        login(driver);
        getBranch(driver);
    }

}
