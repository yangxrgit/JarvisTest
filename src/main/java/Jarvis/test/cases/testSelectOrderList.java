package Jarvis.test.cases;

import Jarvis.test.page.LoginPage;
import Jarvis.test.page.WelfareOrderManagePage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.*;
import java.util.concurrent.TimeUnit;

import static Jarvis.test.config.sysConfig.BaseUrl;
import static Jarvis.test.config.sysConfig.DataBaseUrl;
import static Jarvis.test.page.LoginPage.loginPath;
import static Jarvis.test.page.WelfareOrderManagePage.*;


public class testSelectOrderList {

    //测试福利社订单管理页面的订单列表查询

    WebDriver driver;

    //验证查询全部返回数据总数需要的元素
    public By maxPage = By.xpath("//*[@id=\"inner\"]/div/div[5]/div/ul/li[8]");


    @BeforeMethod
    public void setUp() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(BaseUrl+loginPath);
        LoginPage.login(driver,"yangxr","123456");
        Thread.sleep(5000);
        driver.get(BaseUrl+pagePath);
    }

    //测试查询全部
    @Test
    public void testSelectOrderListAll() throws ClassNotFoundException, SQLException {
        //调用查询全部的方法
        WelfareOrderManagePage.selectOrderListAll(driver);

        //验证：返回内容数量与数据库t_prize_record表中内容数量一致
        //1.加载jdbc驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2.使用DriverManager获取数据库连接
        Connection conn = DriverManager.getConnection("jdbc:mysql://10.10.4.179:3306/activity","admin_rrtv","rrtv1230D");//暂时使用测试环境179的库
        //3.使用Connection来创建一个Statement对象
        Statement stmt = conn.createStatement();
        //4.执行SQL语句
        ResultSet rs = ((Statement) stmt).executeQuery("select count(id) from t_prize_info where is_del =0 order by sort_value desc");
        int recordsTotal = rs.getInt(0);//得到返回数据的数量

        //总页数
        if (recordsTotal%20 == 0){
            int pagesTotal = recordsTotal/20;
        }else {
            int pagesTotal = recordsTotal/20+1;
        }


        Assert.assertEquals(pagesTotal,);
    }




    @AfterMethod
    public void tearDown(){

        driver.quit();
    }



}
