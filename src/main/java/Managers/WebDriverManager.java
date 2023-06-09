package Managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverManager {

    public WebDriverManager(String webDriverType){
        this.webDriverType=webDriverType;

    }

    private WebDriver driver;
    private String webDriverType;

    private WebDriver createDriver (){
        switch (webDriverType){
            case "CHROME":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--remote-allow-origins=*");
                System.setProperty("webdriver.chrome.driver","src/main/resources/drivers/chromedriver.exe");
                driver = new ChromeDriver(chromeOptions);
                break;
            case "FIREFOX":
                System.setProperty("webdriver.gecko.driver","src/main/resources/drivers/geckodriver.exe");
                driver=new FirefoxDriver();
                break;
            default:
                System.out.println("The driver was not created");
                System.out.println("There is not defined such type of Driver:" + webDriverType);
        }
        return driver;
    }
    public WebDriver getDriver(){
        if(driver==null){
            driver=createDriver();
        }
        return driver;
    }

    public void closeDriver(){
        driver.quit();
    }


}
