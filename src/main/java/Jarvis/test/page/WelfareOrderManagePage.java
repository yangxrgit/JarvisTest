package Jarvis.test.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//商城管理-福利社订单管理
public class WelfareOrderManagePage {

    //页面的路径
    public static String pagePath = "/jarvis/#/welfare/orderManage";

    //查询功能需要的页面元素
    public static By startDateInput = By.xpath("//*[@id=\"inner\"]/div/form/div[1]/div/div/div/input");//开始时间输入框
    public static By endDateInput = By.xpath("//*[@id=\"inner\"]/div/form/div[2]/div/div/div/input");//结束时间输入框

    public static By shippingStatusInput = By.xpath("//*[@id=\"inner\"]/div/form/div[3]/div/div/div[1]/input");//发货状态输入框
    public static By shippingStatusTrue = By.xpath("/html/body/div[6]/div/div[1]/ul/li[2]");//已发货
    public static By shippingStatusFalse = By.xpath("/html/body/div[6]/div/div[1]/ul/li[3]");//未发货

    public static By goodsTypeInput = By.xpath("//*[@id=\"inner\"]/div/form/div[4]/div/div/div[1]/input");//商品类型输入框
    public static By goodsTypeGoods = By.xpath("/html/body/div[6]/div/div[1]/ul/li[2]");//普通商品
    public static By goodsTypeMedal = By.xpath("/html/body/div[6]/div/div[1]/ul/li[3]");//勋章
    public static By goodsTypeCard = By.xpath("/html/body/div[6]/div/div[1]/ul/li[4]");//卡密

    public static By payTypeInput = By.xpath("//*[@id=\"inner\"]/div/form/div[5]/div/div/div[1]/input");//支付类型输入框
    public static By payTypeSilver = By.xpath("/html/body/div[7]/div/div[1]/ul/li[2]/span");//银币
    public static By payTypeAchievement = By.xpath("/html/body/div[7]/div/div[1]/ul/li[3]");//成就值

    public static By prizeNameInput = By.xpath("//*[@id=\"inner\"]/div/form/div[6]/div/div/input");//商品名称输入框
    public static By userIdInput = By.xpath("//*[@id=\"inner\"]/div/form/div[7]/div/div/input");//用户id输入框

    public static By selectButton = By.xpath("//*[@id=\"inner\"]/div/form/div[8]/div/button/span");//筛选按钮

    /*
    查询条件：时间段、发货状态、商品类型、支付类型、礼品名称、用户UID
     */

    //查询全部
    public static void selectOrderListAll(WebDriver driver){

            driver.findElement(selectButton).click();
    }

    //按日期查询
    public static void selectOrderListWithDate(WebDriver driver,String startDate,String endDate){

        driver.findElement(startDateInput).sendKeys(startDate);
        driver.findElement(endDateInput).sendKeys(endDate);
        driver.findElement(selectButton).click();
    }

    //按发货状态查询:shippingStatus;//0:未发货 1：已发货
    public static void selectOrderListWithShippingStatus(WebDriver driver,int shippingStatus){

        driver.findElement(shippingStatusInput).click();
        if (shippingStatus == 1){
            driver.findElement(shippingStatusTrue).click();
        }else if (shippingStatus == 0){
            driver.findElement(shippingStatusFalse).click();
        }else {
            System.out.println("发货状态有误");
        }
        driver.findElement(selectButton).click();
    }

    //按商品类型查询:goodsType;//goods medal card
    public static void selectOrderListWithGoodsType(WebDriver driver,String goodsType){

        driver.findElement(goodsTypeInput).click();
        if (goodsType == "goods"){
            driver.findElement(goodsTypeGoods).click();
        }else if (goodsType == "medal"){
            driver.findElement(goodsTypeMedal).click();
        }else if (goodsType == "card"){
            driver.findElement(goodsTypeCard).click();
        }else{
            System.out.println("商品类型有误");
        }
        driver.findElement(selectButton).click();
    }

    //按支付类型查询：payType;//silver achievement
    public static void selectOrderListWithPayType(WebDriver driver,String payType){

        driver.findElement(payTypeInput).click();
        if (payType == "silver"){
            driver.findElement(payTypeSilver).click();
        }else if (payType == "achievement"){
            driver.findElement(payTypeAchievement).click();
        }else{
            System.out.println("支付类型输入有误");
        }
        driver.findElement(selectButton).click();
    }

    //按商品名称查询
    public static void selectOrderListWithPrizeName(WebDriver driver,String prizeName){
        driver.findElement(prizeNameInput).sendKeys(prizeName);
        driver.findElement(selectButton).click();
    }

    //按用户ID查询
    public static void selectOrderListWithUserId(WebDriver driver,String userId){
        driver.findElement(userIdInput).sendKeys(userId);
        driver.findElement(selectButton).click();
    }

    //综合查询///
    public static void selectOrderListWithAll(WebDriver driver,String startDate,String endDate,int shippingStatus,String goodsType,String payType,String prizeName,String userId){

        //填写日期
        driver.findElement(startDateInput).sendKeys(startDate);
        driver.findElement(endDateInput).sendKeys(endDate);

        //填写发货状态
        driver.findElement(shippingStatusInput).click();
        if (shippingStatus == 1){
            driver.findElement(shippingStatusTrue).click();
        }else if (shippingStatus == 0){
            driver.findElement(shippingStatusFalse).click();
        }else {
            System.out.println("发货状态有误");
        }

        //填写商品类型
        driver.findElement(goodsTypeInput).click();
        if (goodsType == "goods"){
            driver.findElement(goodsTypeGoods).click();
        }else if (goodsType == "medal"){
            driver.findElement(goodsTypeMedal).click();
        }else if (goodsType == "card"){
            driver.findElement(goodsTypeCard).click();
        }else{
            System.out.println("商品类型有误");
        }

        //填写支付类型
        driver.findElement(payTypeInput).click();
        if (payType == "silver"){
            driver.findElement(payTypeSilver).click();
        }else if (payType == "achievement"){
            driver.findElement(payTypeAchievement).click();
        }else{
            System.out.println("支付类型输入有误");
        }

        //填写礼品名称
        driver.findElement(prizeNameInput).sendKeys(prizeName);

        //填写用户ID
        driver.findElement(userIdInput).sendKeys(userId);

        //查询
        driver.findElement(selectButton).click();
    }

    /*
    测试点：
    查询
    导出
    列表内容展示
    翻页
    修改发货状态
     */

}
