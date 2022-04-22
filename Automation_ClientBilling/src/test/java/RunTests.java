import PageObjects.*;
import Utilities.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class RunTests {

    public static WebDriver driver;

    @Test(priority = 1)
    public static void beforeAll(){

      driver = BaseUtilities.initialSetup("C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
      driver.get("https://acb-fe-urtjok3rza-wl.a.run.app/login");
    }




}
