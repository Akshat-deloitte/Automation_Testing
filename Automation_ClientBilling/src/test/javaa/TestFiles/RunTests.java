package javaa.TestFiles;

import javaa.Utilities.BaseUtilities;
import org.testng.annotations.BeforeClass;

public class RunTests {

    @BeforeClass
    public void SetUp(){         //Here inside getLogger it accepts class name as a parameter

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\adityakumar3\\Downloads\\chromedriver.exe");
        driver = BaseUtilities.initialSetup()
        driver.get(BaseUtilities.ur);
        driver.manage().window().maximize();

        log.info("Browser Launched");
    }




}
