import Managers.WebDriverManager;
import pageObjects.HomePage;
import pageObjects.RegisterPage;

public class TestRunner {
    public static void main(String[] args) throws  InterruptedException{
        WebDriverManager webDriverManager=new WebDriverManager("CHROME");
        webDriverManager.getDriver().get("https://demo.opencart.com/");

        HomePage homePage=new HomePage(webDriverManager.getDriver());
        homePage.navigateToRegisterPage();

        RegisterPage registerPage=new RegisterPage(webDriverManager.getDriver());
        registerPage.fillInTheRegisterForm("Chetrusca","Victoria","chetruscav@mail.ru","123654789");

        Thread.sleep(15000);
        webDriverManager.closeDriver();


    }
}
