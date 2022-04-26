import PageObjects.LoginPage;
import PageObjects.MonthlyExpense_page;
import Utilities.BaseUtilities;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class monthly_ExpenseTest {


    public WebDriver driver;
    LoginPage loginPage;
    MonthlyExpense_page monthlyExpense_page;

    private  static final String LOG_FILE = "log4j.properties";
    // TO ADD LOGGING IN OUR PROGRAM
    private static Logger log  = LogManager.getLogger(monthly_ExpenseTest.class);


    @Test(priority = 17)
    public void SetUp(){         //Here inside getLogger it accepts class name as a parameter
        driver = BaseUtilities.initialSetup( "C:\\Users\\adityakumar3\\Downloads\\chromedriver.exe");
        driver.get(BaseUtilities.url);
        driver.manage().window().maximize();
    }


    @Test(priority = 101)
    public void Validating_SearchBar_withProductName() throws IOException {
        log.info("Validating_SearchBar_withProductName");
        loginPage  = new LoginPage(this.driver);
        monthlyExpense_page = new MonthlyExpense_page(this.driver);
        loginPage.loginwith_Validusername_Validpassword();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        monthlyExpense_page.selectMonth();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        monthlyExpense_page.selectYear();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        monthlyExpense_page.Click_SearchBar();
        monthlyExpense_page.Type_NameonSearchBar();
        monthlyExpense_page.Click_SearchButton();
        monthlyExpense_page.asserting_ProductName();

    }

    @Test(priority = 102)
    public void Validating_SearchBar_withProductID() throws IOException {
        log.info("Validating_SearchBar_withProductID");
        monthlyExpense_page = new MonthlyExpense_page(this.driver);
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        monthlyExpense_page.clear_SearchField();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        monthlyExpense_page.Click_SearchBar();
        monthlyExpense_page.Type_IDonSearchBar();
        monthlyExpense_page.Click_SearchButton();
        monthlyExpense_page.asserting_ProductId();
    }

    @Test(priority = 103)
    public void Validating_Filter_allBills() throws IOException {
        log.info("Validating_Filter_allBills");
        monthlyExpense_page = new MonthlyExpense_page(this.driver);
        monthlyExpense_page.select_Filter_projects(0); //IT will select all bills
        monthlyExpense_page.select_viewAll();
        monthlyExpense_page.assert_all__bills();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }
    @Test(priority = 104)
    public void Validating_Filter_GeneratedBills() throws IOException {
        log.info("Validating_Filter_GeneratedBills");
        monthlyExpense_page = new MonthlyExpense_page(this.driver);
        monthlyExpense_page.select_Filter_projects(1); //IT will select all bills
        monthlyExpense_page.select_viewAll();
        monthlyExpense_page.assert_generated_bills();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

    }
    @Test(priority = 105)
    public void Validating_Filter_UnGeneratedBills() throws IOException {
        log.info("Validating_Filter_UnGeneratedBills");
        monthlyExpense_page = new MonthlyExpense_page(this.driver);
        monthlyExpense_page.select_Filter_projects(2); //IT will select all bills
        monthlyExpense_page.select_viewAll();
        monthlyExpense_page.assert_un_generated_bills();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

    }

    @Test(priority = 106)
    public void Validating_years() throws IOException {
        log.info("Validating_years");
        monthlyExpense_page = new MonthlyExpense_page(this.driver);
        monthlyExpense_page.assert_year();

    }
    @Test(priority = 107)
    public void Validating_months() throws IOException {
        log.info("Validating_months");
        monthlyExpense_page = new MonthlyExpense_page(this.driver);
        monthlyExpense_page.assert_months();

    }

    @Test(priority = 108)
    public void Validating_viewBill() throws IOException {
        log.info("Validating_viewBill");
        monthlyExpense_page = new MonthlyExpense_page(this.driver);
        monthlyExpense_page.selectMonth();
        monthlyExpense_page.selectYear();
        monthlyExpense_page.select_Filter_projects(1); //IT will select all bills
        monthlyExpense_page.select_viewAll();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        monthlyExpense_page.select_viewBill();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        BaseUtilities.refreshPage();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }

    @Test(priority = 109)
    public void team_lead_ApprovalStatus_ViewBillSection()
    {
        log.info("team_lead_ApprovalStatus_ViewBillSection");
        monthlyExpense_page = new MonthlyExpense_page(this.driver);
        monthlyExpense_page.asserting_teamLeadStatus();
    }

    @Test(priority = 110)
    public void client_ApprovalStatus_ViewBillSection()
    {
        log.info("client_ApprovalStatus_ViewBillSection");
        monthlyExpense_page.asserting_ClientStatus();
    }

    @Test(priority = 111)
    public void payment_status_ViewBillSection()
    {
        log.info("payment_status_ViewBillSection");
        monthlyExpense_page.asserting_PaymentStatus();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        BaseUtilities.logger.info("Error bill not approved ");
    }

    @Test(priority = 112)
    public void Validating_GenerateBill() throws IOException {
        log.info("Validating_GenerateBill");
        monthlyExpense_page.Logout();
        loginPage.loginwith_Validusername_Validpassword();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        monthlyExpense_page.selectMonth();
        monthlyExpense_page.selectYear();
        monthlyExpense_page.select_Filter_projects(2); //IT will select all bills
        monthlyExpense_page.select_viewAll();
        monthlyExpense_page.select_GenerateBill();

    }


    @Test(priority = 113)
    public void team_lead_ApprovalStatus()
    {
        log.info("team_lead_ApprovalStatus");
        loginPage  = new LoginPage(this.driver);
        monthlyExpense_page = new MonthlyExpense_page(this.driver);
        monthlyExpense_page.asserting_teamLeadStatus();
    }

    @Test(priority = 114)
    public void client_ApprovalStatus()
    {
        log.info("client_ApprovalStatus");
        monthlyExpense_page.asserting_ClientStatus();
    }
    @Test(priority = 115)
    public void payment_status()
    {
        log.info("payment_status");
        monthlyExpense_page.asserting_PaymentStatus();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

    }

    @Test(priority = 116)
    public void validating_ClientDashboard()
    {
        log.info("validating_ClientDashboard");
        monthlyExpense_page.Logout();
        try {
            loginPage.loginwith_Client();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 117)
    public void validating_ConfirmPaymentOption()
    {
        log.info("validating_ConfirmPaymentOption");
        monthlyExpense_page.Logout();
        try {
            loginPage.loginwith_Client();
        } catch (IOException e) {
            e.printStackTrace();
        }
        monthlyExpense_page.enter_mode_of_Payment();
        monthlyExpense_page.ConfirmPayment();
    }

    @Test(priority = 118)
    public void validating_declinePaymentOption()
    {
        log.info("validating_declinePaymentOption");
        monthlyExpense_page.Logout();
        try {
            loginPage.loginwith_Client();
        } catch (IOException e) {
            e.printStackTrace();
        }
        monthlyExpense_page.enter_Comments();
        monthlyExpense_page.DeclinePayment();
    }
}