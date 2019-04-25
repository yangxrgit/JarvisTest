package Jarvis.test.cases;

public class testSelectOrderList {

//    //测试福利社订单管理页面的订单列表查询
//
//    WebDriver driver;
//
//    //验证查询全部返回数据总数需要的元素
//    public By maxPage = By.xpath("//*[@id=\"inner\"]/div/div[5]/div/ul/li[8]");
//
//
//    @BeforeMethod
//    public void setUp() throws InterruptedException {
//        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//        driver.get(BaseUrl+loginPath);
//        LoginPage.login(driver,"yangxr","123456");
//        Thread.sleep(5000);
//        driver.get(BaseUrl+pagePath);
//    }
//
//    //测试查询全部
//    @Test
//    public void testSelectOrderListAll() throws ClassNotFoundException, SQLException {
//        //调用查询全部的方法
//        WelfareOrderManagePage.selectOrderListAll(driver);
//
//        //断言：
//        Class.forName("com.mysql.jdbc.Driver");
//        Connection conn = DriverManager.getConnection("jdbc:mysql://10.10.4.179:3306/rrmj_activity","admin_rrtv","rrtv1230D");//测试环境179的库
//        Statement stmt = conn.createStatement();
//<<<<<<< Updated upstream
//        //4.执行SQL语句
//        ResultSet rs = ((Statement) stmt).executeQuery("SELECT count(ID) FROM t_prize_record");
//        int recordsTotal = 0;
//        while (rs.next()){
//            recordsTotal =rs.getInt(1);//得到返回数据的数量
//        }
//
//
//        //总页数
//        int pagesTotal;
//        if (recordsTotal%20 == 0){
//            pagesTotal = recordsTotal/20;
//        }else {
//            pagesTotal = recordsTotal/20+1;
//        }
//
//
//        Assert.assertEquals(driver.findElement(maxPage).getText(),pagesTotal);
//
//        //关闭连接
//        if (rs != null){
//            rs.close();
//        }
//        if (stmt != null){
//            stmt.close();
//        }
//        if (conn !=null){
//            conn.close();
//        }
//=======
//        ResultSet rs = ((Statement) stmt).executeQuery("SELECT COUNT(*) FROM t_prize_record");
//
//
//
//>>>>>>> Stashed changes
//    }
//
//
//
//
//    @AfterMethod
//    public void tearDown(){
//
//        driver.quit();
//    }



}
