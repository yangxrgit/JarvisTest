package Jarvis.test.cases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

/*
BaseTest类实现的测试前准备动作，测试完成的动作。
 */
public class BaseTest {
    public WebDriver driver;

    @BeforeClass
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @AfterClass
    public void teardown(){
        driver.quit();
    }
}
