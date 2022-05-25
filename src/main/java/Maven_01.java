import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import sun.jvm.hotspot.utilities.Assert;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class Maven_01 {
    // start writing code from here
    protected static WebDriver driver;  //(Manually: through = in POM)import selenium webdriver dependency by clicking on bulb(red)

//======================================================================================================================
    @BeforeMethod
    public void openBrowser(){
//declaration and instantiation of objects/variables
        System.setProperty("webdriver.chrome.driver", "src/test/java/Drivers/chromedriver.exe");
        //chrome will open
        driver = new ChromeDriver(); //(in POM file)import chrome web-Driver dependency)
        //waiting of duration
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); //duration to be wait
        //screen maximize
        driver.manage().window().maximize(); //maximizing screen
        //type URL opening web page
        driver.get("https://demo.nopcommerce.com/");
    }

//======================================================================================================================
    //1 method-----------------------------------
    public static void clickOnElement(By by ) {                      //driver.findElement(By.xpath("//button[@id='register-button']")).click();
        driver.findElement(by).click();
    }
    //2 method------------------------------------
    public static void typeText(By by, String text) {               // typeText(By.id("ConfirmPassword"),"mpatel164");
        driver.findElement(by).sendKeys(text);
    }
    //3 method----------------------------------
    public static String randomDate() {
        Date date = new Date();  //2
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy/HH/mm/ss");
        return formatter.format(date);

        //Date date = new Date();  //1
        //SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy/HH/mm/ss");
        //String strDate = formatter.format(date);
        //System.out.println(strDate);
    }
    //4 method----------------------------------
    public static String getTextFormElement(By by) {
        driver.findElement(by).getText();
    }
//===================================================================================================================
    public static void driverWaitsUntillURLTobe(int time, String url){
        WebDriverWait wait01 = new WebDriverWait(driver, Duration.ofSeconds(time));
        //wait.until(ExpectedCondition.elementToBeClickable(By.Xpath("//button[@name='register-button']")));
        wait01.until(ExpectedConditions.urlToBe("https://demo.nopcommerce.com/"));
    }
    public static void driverWaitsUntillURLTobeClickable (By by,int time){ //1
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }                                                                                             //1driverWait commands
    public static void driverWait ( int time, String urlFraction){ //2
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.urlContains(urlFraction));
    }                                                                                             //3driverWait commands
    public static void driveWait ( int time, String Attribute, String value, By by){ //3
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.attributeContains(by, Attribute, value));
    }                                                                                           //4driverWait commands
    public static void driverWaitUrlContains ( int time, By by, String urlName){ //4
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.urlContains(urlName));
    }                                                                                          //5driverWait commands
    public static void DriverWaitSelectElement ( int time, By by){ //5
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));

    }                                                                                           //6driverWait commands
    public static void DriverWaitPresenceOfAllElementsLocatedBy ( int time, By by){ //6
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }                                                                                            //7driverWait commands
    public static void DriverWaitVisibilityOf ( int time, WebElement element){ //7
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.visibilityOf(element));
    }                                                                                             //8driverWait commands
    public static void DriverWaituntilinvisibilityOfWebElement ( int time, WebElement element){ //8
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.invisibilityOf(element));
    }                                                                                             //9driverWait commands
    public static void DriverWaitElementToBeSelected ( int time, By by){ //9
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.elementToBeSelected(by));

    }                                                                                            //10driverWait commands
    public static void DriverWait ( int time, String name) { //10
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.titleIs(name));
    }

//======================================================================================================================
    @Test
    public static void userShouldBeAbleToRegisterSuccessfully() {
        // click on register button//////////////////
        // driver.findElement(By.className("ico-register")).click();
        //Click on register button=================================================================================
        //driver.findElement(By.className("ico-register")); //1
        clickOnElement(By.className("ico-register"));       //2

        //select gender male or female Radio button
        //driver.findElement(By.xpath("//input[@id=\"gender-female\"]")).click(); //radio button
        clickOnElement(By.id("gender-female"));

        //Enter First Name------------------------
        //driver.findElement(By.xpath("//input[@name='FirstName']")).sendKeys("Smita");
        //driver.findElement(By.id("FirstName")).sendKeys("Smita"); //1
        typeText(By.id("FirstName"), "Smita");                   //2

        //Enter Last Name-------------------------
        //driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("Patel");
        //driver.findElement(By.id("LastName")).sendKeys("Patel");    //1
        typeText(By.id("LastName"), "Patel");                     //2

        //Date of birth day----------------------
        Select birthDay = new Select(driver.findElement(By.name("DateOfBirthDay")));//select on the day
        birthDay.selectByIndex(28);

        //Date of birth month---------------------
        Select birtMonth = new Select(driver.findElement(By.name("DateOfBirthMonth")));//select on month
        birtMonth.selectByIndex(6);

        //Date of birth year--------------------

        Select birthYear = new Select(driver.findElement(By.name("DateOfBirthYear")));//select on year
        birthYear.selectByVisibleText("1990");

        //Enter Email----------------------------

        System.out.println(randomDate());
        //driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("smita.mpatel164@gmail.com");
        //driver.findElement(By.id("Email")).sendKeys("smita.mpatel164@gmail.com");
        typeText(By.id("Email"), "smita.mpatel164" + randomDate() + "@gmail.com");

        //Enter Email----------------------------
        //driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("mpatel164");
        //driver.findElement(By.id("Password")).sendKeys("mpatel164");
        typeText(By.id("Password"), "mpatel164");

        //Enter your confirm password-------------
        //driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("mpatel164");
        //driver.findElement(By.id("ConfirmPassword")).sendKeys("mpatel164");
        typeText(By.id("ConfirmPassword"), "mpatel164");


        //Click on register button======================================================================================================
        //driver.findElement(By.xpath("//button[@id='register-button']")).click(); //belowsecond option  clickOnElement(By.id("register-button"));
        clickOnElement(By.id("register-button"));
        String expectedMessage = "Your registretion completed ";
        // String actualMessage = driver.findElement(By.className("result")).getText();//method 3
        String actualMessage = getTextFormElement(By.className("result"));   //method 4
        System.out.println("Actual message:" + actualMessage);
    }

//ChangeCurrency============================================================================
        @Test
        public void Currency() {

            @Test
            public void UserShouldBeAbleToChangeCurrency() {
                clickOnElement(By.name("customerCurrency"));
            }
            // public String getTextFromElement(By by) {
            public static String getTexFromElement(By by) {
                driver.findElement(By.xpath("//id=\"customerCurrency\"]")).getText();
        }
//====================================================================================================================
@Test
public void BuildYourOwnComputer() {
    driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Computers ']")).click();
    driver.findElement(By.xpath("//img[@alt=\"Picture for category Desktops\"]")).click();
    driver.findElement(By.xpath("//h2[@class=\"product-title\"]/a[@href=\"/build-your-own-computer\"]")).click();
    Select Processor = new Select(driver.findElement(By.id("product_attribute_1")));
    Processor.selectByValue("1");
    Select Ram = new Select(driver.findElement(By.id("product_attribute_2")));
    Ram.selectByValue("3");
    driver.findElement(By.xpath("//label[@for=\"product_attribute_3_6\"]")).click();
    driver.findElement(By.xpath("//label[@for=\"product_attribute_4_9\"]")).click();
    driver.findElement(By.xpath("//label[@for=\"product_attribute_5_11\"] ")).click();
    driver.findElement(By.xpath("//input[@value=\"12\"]")).click();
    clickOnElement(By.xpath("//button[@id=\"add-to-cart-button-1\"]"));
    clickOnElement(By.xpath("//span[@class=\"cart-label\"]"));
    //Assert for Shopping cart
    String expectedMessage = "Shopping cart";
    String actualMessage = driver.findElement(By.xpath("//h1 [contains (text (),'Shopping cart')]")).getText();
    Assert.assertEquals( actualMessage,expectedMessage, "The product will not added to the cart ");
    //Assert Build your own computer
    String expectedMessage1 = "Build your own computer";
    String actualMessage1 = driver.findElement(By.className("product-name")).getText();
    Assert.assertEquals( actualMessage,expectedMessage, " build your computer error  computer  ");

}//===================================================================================================================
    @Test
    public static void RegisterUerShouldReferproductToTheirFriends () {

        //driver.get("https://demo.nopcommerce.com/build-your-own-computer");
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Computers ']")).click();

        driver.findElement(By.xpath("//img[@alt=\"Picture for category Desktops\"]")).click();

        driver.findElement(By.xpath("//div[@data-productid=\"1\"]/div/div[3]/div[2]//button[@class=\"button-2 product-box-add-to-cart-button\"]")).click();

        driver.findElement(By.xpath("//*[@id=\"FriendEmail\"]")).sendKeys("Jigarsoni75@yahoo.com");

        driver.findElement(By.xpath("//*[@id=\"YourEmailAddress\"]")).sendKeys("Jigsoni155@gmail.com");

        driver.findElement(By.xpath("//*[@id=\"PersonalMessage\"]")).sendKeys("This computer is a very nice and good price.");

        clickOnElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[2]/button"));    //************

        clickOnElement(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[2]/button[1]"));//*******
    }

//===================================================================================================================


    @AfterMethod
    public static void closeBrowser() {
        driver.quit();
        System.out.println("finished");
    }


}

