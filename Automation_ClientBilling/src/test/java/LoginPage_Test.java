import Utilities.BaseUtilities;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginPage_Test {


    public static WebDriver driver;

    @BeforeTest
    public static void beforeAll(){

        driver = BaseUtilities.initialSetup("C:\\Selenium\\chromedriver_win32\\chromedriver.exe");

    }




}
