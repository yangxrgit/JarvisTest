package Jarvis.test.cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdSetting {


    public static void main(String[] args) throws ClassNotFoundException, SQLException, InterruptedException {

//        //通过厂商id从数据库获取该厂商的所有广告ID：AdIdList
//        Class.forName("com.mysql.jdbc.Driver");
//        Connection conn = DriverManager.getConnection("jdbc:mysql://10.10.2.148:3306/rrmj2","root","e9V5ubCU0SnACDXq");//uat库
//        //String sql="SELECT ID FROM t_ad_order WHERE MISSION_AD_ID in (SELECT ID FROM t_mission_ad WHERE partner_id=14";
//        String sql = "SELECT a.ID FROM t_ad_order a,t_mission_ad m WHERE m.PARTNER_ID =? AND a.MISSION_AD_ID =m.ID";//？占位符
//        PreparedStatement ps = conn.prepareStatement(sql);
//        /*
//        1	自家API	API	RRMJ
//        2	OPPO	SDK	OPPO
//        3	推啊	SDK	TUIA
//        4	畅思	SDK	CSB
//        5	新数	SDK	XS
//        6	大众点评	SDK	DZDP
//        7	亿玛	SDK	EAD
//        8	NOV广告	SDK	NOV
//        9	湛乘	SDK	ADXPAND
//        10	视连通	SDK	SLT
//        11	iOS旧亿玛	SDK	EAD
//        12	自家测试deeplink	SDK	RRMJ
//        13	VIVO	SDK	VIVO
//        14	LIGO	SDK	LIGO
//        15	头条/穿山甲	SDK	TT
//        16	广点通	SDK	GDT
//         */
//        ps.setObject(1,14);//把id=14（厂商是LOGO）的广告id取出来
//        ResultSet rs = ps.executeQuery();
//        List<Integer> AdIdList = new ArrayList<Integer>();
//        while (rs.next()){
//            AdIdList.add(rs.getInt(1));
//        }
//
//        System.out.println(AdIdList);
//
//        //关闭连接
//        if (rs != null){
//            rs.close();
//        }
//        if (ps != null){
//            ps.close();
//        }
//        if (conn !=null){
//            conn.close();
//        }

        List<Integer> AdIdList = new ArrayList<Integer>();
        AdIdList.add(363);
        AdIdList.add(364);
        System.out.println(AdIdList);
        //浏览器点击版本全选
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://uat-adminwow.rr.tv/page/index");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.id("username")).sendKeys("yangxr");//用户名输入框，输入username
        driver.findElement(By.id("password")).sendKeys("123456");//密码输入框，输入password
        driver.findElement(By.xpath("/html/body/div/div/form/button")).click();//点击登录按钮
        Thread.sleep(5000);

        String url ="http://uat-adminwow.rr.tv/jarvis/#/adManage/adNew?id=";
        for (int i=0;i<AdIdList.size();i++){
            driver.get(url+AdIdList.get(i));
            System.out.println("一个url"+AdIdList.get(i));
            Thread.sleep(3000);
            //如果元素未选中，那就选中保存
            WebElement el = driver.findElement(By.xpath("//*[@id=\"inner\"]/div/div/div[2]/form/div[3]/div/div/div/div[1]/label/span[1]/span")); //全选按钮
            if (!el.isSelected()){
                el.click();
            }
            Thread.sleep(3000);
            driver.findElement(By.xpath("//*[@id=\"inner\"]/div/div/div[2]/form/div[8]/div/button[1]/span")).click();//确定按钮
        }


    }

}
