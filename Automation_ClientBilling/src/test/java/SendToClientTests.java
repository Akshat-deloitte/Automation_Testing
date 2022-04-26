
import PageObjects.LoginPage;
import PageObjects.SendToClientPage;
import Utilities.BaseUtilities;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class SendToClientTests {
    public static WebDriver driver;

    private  static final String LOG_FILE = "log4j.properties";
    // TO ADD LOGGING IN OUR PROGRAM
    private static Logger log  = LogManager.getLogger(monthly_ExpenseTest.class);

    @Test(priority = 1)
    public void test_case_0() throws IOException {
        log.info("test_case_0");
        driver = BaseUtilities.initialSetup( "C:\\Users\\adityakumar3\\Downloads\\chromedriver.exe");
        driver.get("https://acb-fe-urtjok3rza-wl.a.run.app/login");
        driver.manage().window().maximize();
        LoginPage login = new LoginPage(driver);
        login.loginwith_Validusername_Validpassword();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test(priority = 2)
    public void send_to_client_button() {
        log.info("send_to_client_button");
        SendToClientPage obj = new SendToClientPage(driver);
        obj.client_button();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        obj.click_client();
    }

    @Test(priority = 3)
    public void month073() {
        log.info("month073");
        SendToClientPage obj = new SendToClientPage(driver);
        obj.month_button();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
    }

    @Test(priority = 4)
    public void month074() {
        log.info("month074");
        SendToClientPage obj = new SendToClientPage(driver);
        obj.click_month();
        obj.choose_month(1);
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
    }

    @Test(priority = 5)
    public void year075() {
        log.info("year075");
        SendToClientPage obj = new SendToClientPage(driver);
        obj.year_button();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
    }

    @Test(priority = 6)
    public void year076() {
        log.info("year076");
        SendToClientPage obj = new SendToClientPage(driver);
        obj.click_year();
        obj.choose_year(0);
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
    }

    @Test(priority = 7)
    public void bill077() {
        log.info("bill077");
        SendToClientPage obj = new SendToClientPage(driver);
        obj.bill_button();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
    }

    @Test(priority = 8)
    public void bill078() {
        log.info("bill078");
        SendToClientPage obj = new SendToClientPage(driver);
        obj.click_bill();
        obj.choose_bill(0);
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
    }

    @Test(priority = 9)
    public void click_submit() {
        log.info("click_submit");
        SendToClientPage obj = new SendToClientPage(driver);
        obj.submit_button();
        obj.click_submit();
    }

    @Test(priority = 10)
    public void display_bill() {
        log.info("display_bill");
        SendToClientPage obj = new SendToClientPage(driver);
        obj.bill_name();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        obj.bill_id();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        obj.project_id();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        obj.bill_description();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        obj.validate_id();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
    }

    @Test(priority = 11)
    public void display_billing_info() {
        log.info("display_billing_info");
        SendToClientPage obj = new SendToClientPage(driver);
        obj.invoice();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        obj.date_issued();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        obj.due_date();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        obj.name_client();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        obj.email_client();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        obj.contact_client();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
    }

    @Test(priority = 12)
    public void item_details_info() {
        log.info("item_details_info");
        SendToClientPage obj = new SendToClientPage(driver);
        obj.name_product();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        obj.hours_info();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        obj.rate_info();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        obj.total_amount();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        obj.validate_amount();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
    }

    @Test(priority = 13)
    public void approval094() {
        log.info("approval094");
        SendToClientPage obj = new SendToClientPage(driver);
        obj.approval_button();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
    }

    @Test(priority = 14)
    public void approval095() {
        log.info("approval095");
        SendToClientPage obj = new SendToClientPage(driver);
        obj.click_approval();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
    }
}