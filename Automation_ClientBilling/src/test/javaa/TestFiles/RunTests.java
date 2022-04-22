package javaa.TestFiles;

import javaa.PageObjects.LoginPage;
import javaa.PageObjects.MonthlyExpense_page;
import javaa.Utilities.BaseUtilities;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class RunTests {


    public WebDriver driver;
    LoginPage loginPage;
    MonthlyExpense_page monthlyExpense_page;

    @BeforeTest
    public void SetUp(){         //Here inside getLogger it accepts class name as a parameter

        driver = BaseUtilities.initialSetup("C:\\Users\\adityakumar3\\Downloads\\chromedriver.exe");
        driver.get(BaseUtilities.url);
        driver.manage().window().maximize();
    }




    @Test(priority = 1)
    public void Validating_SearchBar() throws IOException {
        loginPage  = new LoginPage(this.driver);
        monthlyExpense_page = new MonthlyExpense_page(this.driver);

        loginPage.loginwith_Validusername_Validpassword();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        monthlyExpense_page.selectMonth();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        monthlyExpense_page.selectYear();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        monthlyExpense_page.Click_SearchBar();
        monthlyExpense_page.Type_onSearchBar();
        monthlyExpense_page.Click_SearchButton();
    }


}
