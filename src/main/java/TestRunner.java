import Managers.WebDriverManager;

public class TestRunner {
    public static void main(String[] args) throws  InterruptedException{
        WebDriverManager webDriverManager=new WebDriverManager("CHROME");
        webDriverManager.getDriver().get("https://testautomationu.applitools.com/");

        Thread.sleep(15000);
        webDriverManager.closeDriver();


    }
}
