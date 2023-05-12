import Managers.WebDriverManager;
import org.junit.jupiter.api.*;
import pageObjects.HomePage;
import pageObjects.RegisterPage;

public class JunitPractice {

    WebDriverManager webDriverManager = new WebDriverManager("CHROME");

    @BeforeEach
    public void beforeTestProcedure() {
        webDriverManager.getDriver().get("https://demo.opencart.com/");
    }

    @AfterEach
    public void afterTestInstructions() {
        webDriverManager.getDriver().close();

    }

    @Test
    @DisplayName("Registration page is accessible from Home page")
    public void verifyIfTheRegisterPageIsAccessible() {

        HomePage homePage = new HomePage(webDriverManager.getDriver());
        homePage.navigateToRegisterPage();

        boolean urlIsValid = webDriverManager.getDriver().getCurrentUrl().contains("register");

        Assertions.assertTrue(urlIsValid, "Url address is not valid");
    }

    @Test
    @DisplayName("Register page elements are displayed")
    public void registerPageElementsAreDisplayed() {

        HomePage homePage = new HomePage(webDriverManager.getDriver());
        homePage.navigateToRegisterPage();

        RegisterPage registerPage = new RegisterPage(webDriverManager.getDriver());

        Assertions.assertTrue(registerPage.allTheElementsAreDisplayed(), "At least one of elements was not displayed");
    }

    @Test
    @DisplayName("Registration form is completed")
    public void fillInTheRegistrationForm() throws InterruptedException{
        HomePage homePage=new HomePage(webDriverManager.getDriver());
        homePage.navigateToRegisterPage();

        RegisterPage registerPage=new RegisterPage(webDriverManager.getDriver());

        registerPage.fillInTheRegisterForm("Chetrusca","Victoria","chetruscav@mail.ru","123654789");



        Thread.sleep(10000);
    }

}
