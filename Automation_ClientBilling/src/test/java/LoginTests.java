import PageObjects.LoginPage;
import PageObjects.SendToTeamPage;
import Utilities.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class LoginTests {

    public static WebDriver driver;
    LoginPage loginPage;

    private  static final String LOG_FILE = "log4j.properties";
    // TO ADD LOGGING IN OUR PROGRAM
    private static Logger log  = LogManager.getLogger(monthly_ExpenseTest.class);

    @BeforeTest
    public  void Setup(){

      driver = BaseUtilities.initialSetup("C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
        loginPage  = new LoginPage(this.driver);


    }


    @Test(priority = 1)
    public void validating_launch_LoginPage(){
        log.info("");
        loginPage.launch_LoginPage();
        driver.manage().window().maximize();
    }


    @Test(priority = 2)
    public void validating_find_Logo(){
        log.info("");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        loginPage.find_Logo();
    }


    @Test(priority = 3)
    public void validating_find_UsernameField(){
        log.info("");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        loginPage.find_UsernameField();
    }


    @Test(priority = 4)
    public void validating_find_PasswordField(){
        log.info("");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        loginPage.find_PasswordField();
    }


    @Test(priority = 5)
    public void validating_Empusername_Emppassword() throws TimeoutException {
        log.info("");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        loginPage.loginwith_Empusername_Emppassword();
    }

    @Test(priority = 6)
    public void validating_Invalidusername_Emppassword() throws TimeoutException, IOException {
        log.info("");
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        loginPage.loginwith_Invalidusername_Emppassword();
    }


    @Test(priority = 7)
    public void validating_Empusername_Invalidpassword() throws TimeoutException, IOException {
        log.info("");
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        loginPage.loginwith_Empusername_Invalidpassword();
    }

    @Test(priority = 8)
    public void validating_Validusername_Invalidpassword() throws TimeoutException, IOException {
        log.info("");
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        loginPage.loginwith_Validusername_Invalidpassword();
    }

    @Test(priority = 9)
    public void validating_Invalidusername_Validpassword() throws TimeoutException, IOException {
        log.info("");
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        loginPage.loginwith_Invalidusername_Validpassword();
    }

    @Test(priority = 10)
    public void validating_Invalidusername_Invalidpassword() throws TimeoutException, IOException {
        log.info("");
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        loginPage.loginwith_Invalidusername_Invalidpassword();
    }

    @Test(priority = 11)
    public void validating_Validusername_Validpassword() throws TimeoutException, IOException {
        log.info("");
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        loginPage.loginwith_Validusername_Validpassword();
        loginPage.assert_ValidLogin();
    }
//
    @Test(priority = 12)
    public void validating_loginwith_Admin() throws TimeoutException, IOException {
        log.info("");
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        loginPage.loginwith_Admin();
    }

    @Test(priority = 13)
    public void validating_loginwith_TeamLead() throws TimeoutException, IOException, InterruptedException {
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        log.info("");
        loginPage.launch_LoginPage();
        loginPage.loginwith_TeamLead();

    }

    @Test(priority = 14)
    public void validating_loginwith_Client() throws TimeoutException, IOException, InterruptedException {
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        log.info("");
        loginPage.launch_LoginPage();
        loginPage.loginwith_Client();

    }

    @Test(priority = 15)
    public void validating_PasswordVisibility() throws TimeoutException, IOException, InterruptedException {
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        log.info("");
        loginPage.launch_LoginPage();
        loginPage.PasswordVisibility();

    }

    @Test(priority = 16)
    public void validating_ForgotPassword() throws TimeoutException, IOException, InterruptedException {
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        log.info("");
        loginPage.launch_LoginPage();
        loginPage.ForgotPassword();
    }




}
