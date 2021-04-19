package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import org.w3c.dom.Document;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class CommonOps extends Base {
    public static String getData(String nodeName)
    {
        File fXmlFile;
        DocumentBuilderFactory dbFactory;
        DocumentBuilder dBuilder;
        Document doc = null;
        try {
            fXmlFile = new File("./Configuration/DataConfig.xml");
            dbFactory = DocumentBuilderFactory.newInstance();
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();

        }
        catch (Exception e){
            System.out.println("Error reading XML file" + e);

        }
        finally {
            return doc.getElementsByTagName(nodeName).item(0).getTextContent();
        }
    }
    public static void initBroswer(String browserType){
        if (browserType.equalsIgnoreCase("chrome"))
            driver=initChromeDriver();
        else if (browserType.equalsIgnoreCase("firefox"))
            driver=initFirefoxDriver();
        else if (browserType.equalsIgnoreCase("ie"))
            driver=initIEDriver();
        else
            throw new RuntimeException("Invalid Browser Type");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("Timeout")), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver,Long.parseLong(getData("Timeout")));
        driver.get(getData("url"));
        ManagePages.initGrafana();
        action = new Actions(driver);




    }
    public static WebDriver initChromeDriver(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        return driver;
    }

    public static WebDriver initFirefoxDriver(){
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        return driver;
    }

    public static WebDriver initIEDriver(){
        WebDriverManager.iedriver().setup();
        WebDriver driver = new InternetExplorerDriver();
        return driver;
        }

        public static  void initAPI(){
            RestAssured.baseURI = getData("urlAPI");
            httpRequest = RestAssured.given().auth().preemptive().basic(getData("UserName"),getData("Password"));

        }

        public static void initElectron(){
        System.setProperty("webdriver.chrome.driver",getData("ElectronDriverPath"));
            ChromeOptions opt = new ChromeOptions();
            opt.setBinary(getData("ElectronAppPath"));
            dc.setCapability("chromeOptions",opt);
            dc.setBrowserName("chrome");
            driver = new ChromeDriver(dc);
            ManagePages.initToDo();
        }

    @BeforeClass
    @Parameters("PlatformName")
    public void startSession(String PlatformName)  {
        platform = PlatformName;
        if (platform.equalsIgnoreCase("web"))
            initBroswer(getData("BrowserName"));
        //else if (platform.equalsIgnoreCase("mobile"))
            //initMobile();
            else if (platform.equalsIgnoreCase("api"))
            initAPI();
       // else if (platform.equalsIgnoreCase("electron"))
           // initElectron();
        else
            throw new RuntimeException("Invalid platform name");
                softAssert = new SoftAssert();
                screen = new Screen();

                ManageDB.openConnection(getData("DBURL"),getData("DBUserName"),getData("DBPassword"));

    }
    @AfterClass
    public void closeSession(){
        ManageDB.closeConnection();
        if (!platform.equalsIgnoreCase("api")){
            driver.quit();
        }

    }

    @AfterMethod
    public void afterMethod(){
        if (platform.equalsIgnoreCase("web"))
        driver.get(getData("url"));
    }

    @BeforeMethod
    public void beforeMethod(Method method){
        if (!platform.equalsIgnoreCase("api")){
            try {
                MonteScreenReorder.startRecord(method.getName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

