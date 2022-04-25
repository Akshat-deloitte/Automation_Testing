import PageObjects.*;
import Utilities.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class RunTeamTests {

    public static WebDriver driver;

    private  static final String LOG_FILE = "log4j.properties";
    // TO ADD LOGGING IN OUR PROGRAM
    private static Logger log  = LogManager.getLogger(monthly_ExpenseTest.class);

    @Test(priority = 18)
    public void beforeAll() throws IOException {
        log.info("Opening the webpage and the url");
        driver = BaseUtilities.initialSetup("C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
        driver.get("https://acb-fe-urtjok3rza-wl.a.run.app/login");
        driver.manage().window().maximize();
        LoginPage login = new LoginPage(this.driver);
        login.loginwith_Validusername_Validpassword();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    @Test(priority = 2)
    public void teamoption() {

        log.info("Checking if the send to team option is accessible");
        SendToTeamPage sendteam = new SendToTeamPage(this.driver);
        sendteam.team_button();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        sendteam.click_team_button();

    }

    @Test(priority = 3)
    public void revertback() {
        log.info("Checking if the reverting back is working on clicking the Monthly billing details link");
        SendToTeamPage sendteam = new SendToTeamPage(this.driver);
        sendteam.revert_back();
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        sendteam.verify_revert();
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        System.out.println("revert was successful");
        sendteam.click_team_button();
    }

    @Test(priority = 4)
    public void monthoption() {
        log.info("Checking if we can click on the month drop down option and able to select any option");
        SendToTeamPage sendteam = new SendToTeamPage(this.driver);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        sendteam.click_month();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        sendteam.choose_months(2);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.findElement(By.className("monthly-expense")).click();

    }

    @Test(priority = 5)
    public void yearoption() {
        log.info("Checking if we can click on the year drop down option and able to select any option");
        SendToTeamPage sendteam = new SendToTeamPage(this.driver);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        sendteam.click_year();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        sendteam.choose_years(0);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.findElement(By.className("monthly-expense")).click();

    }

    @Test(priority = 6)
    public void unverifiedbilloption() {
        log.info("Checking if we can click on the unverified bills drop down option and able to select any option");
        SendToTeamPage sendteam = new SendToTeamPage(this.driver);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        sendteam.click_unverified_bill();
        sendteam.choose_unverifiedBills(0);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.findElement(By.className("monthly-expense")).click();
    }

    @Test(priority = 7)
    public void submitoption() {
        log.info("Checking if we can click on the submit option");
        SendToTeamPage sendteam = new SendToTeamPage(this.driver);
        driver.findElement(By.className("monthly-expense")).click();
        sendteam.SUBMIT_button();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        sendteam.click_submit_button();
    }

    @Test(priority = 8)
    public void checking_elements_in_bill() {
        log.info("Checking if we all the elements are present in the bill");
        SendToTeamPage sendteam = new SendToTeamPage(this.driver);
        sendteam.bill_name();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        sendteam.bill_id();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        sendteam.team_lead_status();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        sendteam.team_client_status();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        sendteam.team_payment_status();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        sendteam.project_id();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        sendteam.bill_month();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        sendteam.issued_date();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        sendteam.due_date();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        sendteam.teamlead_name();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        sendteam.teamlead_name();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        sendteam.teamlead_contactno();
    }

    @Test(priority = 9)
    public void checking_amount_in_bill() {
        log.info("Checking if the linetotal and the total amount is equal");
        SendToTeamPage sendteam = new SendToTeamPage(this.driver);
        sendteam.check_amount();

    }

    @Test(priority = 10)
    public void checking_click_on_send_approval_button() {
        log.info("Checking if we can click on the send approval option");
        SendToTeamPage sendteam = new SendToTeamPage(this.driver);
        sendteam.Click_Sendapproval_Button();

    }

    @Test(priority = 11)
    public void check_total_amount() {
        log.info("Checking if the amount generated by the computer and the calculated amount is same");
        SendToTeamPage sendteam = new SendToTeamPage(this.driver);
        sendteam.Calculate_total_amount();
        Assert.assertTrue(false);

    }
}