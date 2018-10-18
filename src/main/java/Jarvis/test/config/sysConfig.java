package Jarvis.test.config;

import org.openqa.selenium.Cookie;

public class sysConfig {

    //配置环境
    public static String OnlineEnv = "http://adminwow.rr.tv";
    public static String UATEnv = "http://uat-adminwow.rr.tv";
    public static String TestEnv = "http://test.rr.tv:8081";

    public static String BaseUrl;

    static {
        BaseUrl = TestEnv;
    }

    //配置数据库url


}



