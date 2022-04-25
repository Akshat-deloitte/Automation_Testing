package PageObjects;


import Utilities.BaseUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;

public class MonthlyExpense_page {

    WebDriver localdriver;
    public MonthlyExpense_page(WebDriver remotedriver)
    {
        this.localdriver = remotedriver;
        PageFactory.initElements(remotedriver,this);
    }


    By Search_Bar = By.xpath("//app-monthly-expense[1]//nz-input-group[1]/span[1]/input[1]");
    By Search_Button = By.xpath("//nz-input-group[1]/span[1]/span[1]/button[1]");
    By Month_Dropdown = By.xpath("(//app-monthly-expense[1]//select[1])[2]");
    By Year_Dropdown = By.xpath("//app-monthly-expense[1]/div[1]/div[1]/div[2]/div[2]/div[1]/select[2]");
    By Filter_projects_Dropdown = By.xpath("(//app-monthly-expense[1]//select[1])[1]");
    By View_All_Button = By.xpath("//h3[contains(text(),'View All')]");
    By View_Bills_Button = By.xpath("(//div[1]/div[2]/div[2]/button[1]/span[1])[1]");
    By Generate_Bills_Button = By.xpath("(//div[1]/div[2]/div[2]/button[1]/span[1])[1]");
    By GetProductName_onSearch = By.xpath("(//app-card[1]/div[1])[1]/child::*[1]");
    By GetProductID_onSearch = By.xpath("//app-monthly-expense/div/div/div[2]/div[1]/div[4]/div[1]/app-card/div/div[1]/div[5]");
    By un_generated_Bills_list =  By.xpath("//app-monthly-expense[1]//button[1]/span[1]");
    By generated_Bills_list =  By.xpath("//app-monthly-expense[1]//button[1]/span[1]");
    By Logout_dropdown =  By.xpath("//app-header/div[1]/div[3]/a[1]/i[1]/*[1]");
    By Logout_Button =  By.xpath("//li[contains(text(),'Logout')]");
    By team_leadStatus =  By.xpath("//body/app-root[1]/app-dashboard[1]/app-project-details[1]/div[1]/div[2]/div[2]/nz-steps[1]/div[1]/nz-step[3]/div[1]/div[1]/span[1]/span[1]/span[1]");
    By Client_Status =  By.xpath("//body/app-root[1]/app-dashboard[1]/app-project-details[1]/div[1]/div[2]/div[2]/nz-steps[2]/div[1]/nz-step[3]/div[1]/div[1]/span[1]/span[1]/span[1]");
    By Payment_Status =  By.xpath("//body/app-root[1]/app-dashboard[1]/app-project-details[1]/div[1]/div[2]/div[2]/nz-steps[3]/div[1]/nz-step[3]/div[1]/div[1]/span[1]/span[1]/span[1]");
    By get_SearchedProduct =  By.xpath("(//app-monthly-expense[1]//div[1]/app-card[1]/div[1]//child::*)[1]");

    By Payment_mode_field =  By.xpath("//body/app-root[1]/app-client-dashboard[1]/app-homepage[1]/div[2]/div[1]/div[2]/div[1]/textarea[1]");
    By ConfirmPayment_button =  By.xpath("//span[contains(text(),'CONFIRM PAYMENT')]");
    By Comment_field =  By.xpath("//body/app-root[1]/app-client-dashboard[1]/app-homepage[1]/div[2]/div[1]/div[2]/div[2]/textarea[1]");
    By DeclinePayment_option =  By.xpath("//span[contains(text(),'DECLINE PAYMENT')]");

    public void enter_mode_of_Payment()
    {
        localdriver.findElement(Payment_mode_field).sendKeys("NFT");
    }
    public void ConfirmPayment()
    {
        localdriver.findElement(ConfirmPayment_button).click();
    }

    public void enter_Comments()
    {
        localdriver.findElement(Comment_field).sendKeys("Wrong Bill");
    }
    public void DeclinePayment()
    {
        localdriver.findElement(DeclinePayment_option).click();
    }


    public void asserting_teamLeadStatus()
    {
        if(localdriver.findElement(team_leadStatus).isDisplayed())
        {
            System.out.println("Team's Lead Approval Status is Displaying");
            Assert.assertTrue(true);
        }
        else {
            System.out.println("Team's Lead Approval Status is not Displaying");
            Assert.assertTrue(false);
        }
    }

    public void asserting_ClientStatus()
    {
        if(localdriver.findElement(Client_Status).isDisplayed())
        {
            System.out.println("Client Approval Status is Displaying");
            Assert.assertTrue(true);
        }
        else {
            System.out.println("Client Approval Status is not Displaying");
            Assert.assertTrue(false);
        }
    }
    public void asserting_PaymentStatus()
    {
        if(localdriver.findElement(Payment_Status).isDisplayed())
        {
            System.out.println("Payment Status is Displaying");
            Assert.assertTrue(true);
        }
        else {
            System.out.println("Payment Status is not Displaying");
            Assert.assertTrue(false);
        }
    }


    public void Click_SearchBar()
    {
        localdriver.findElement(Search_Bar).click();
        if(localdriver.findElement(Search_Bar).isEnabled())
        {
            Assert.assertTrue(true,"Search Bar is Clickable");
        }else {
            Assert.assertTrue(false,"Search Bar is not Clickable");
        }

    }


    public void Type_IDonSearchBar() throws IOException {
        localdriver.findElement(Search_Bar).sendKeys(BaseUtilities.getCellvalue(BaseUtilities.path_of_DB,BaseUtilities.sheet_name,1,2));
    }

    public void Type_NameonSearchBar() throws IOException {
        localdriver.findElement(Search_Bar).sendKeys(BaseUtilities.getCellvalue(BaseUtilities.path_of_DB,BaseUtilities.sheet_name,1,3));
    }

    public void asserting_ProductName() throws IOException {
        String Product_Appeared  = localdriver.findElement(get_SearchedProduct).getText();
        Assert.assertEquals(Product_Appeared,BaseUtilities.getCellvalue(BaseUtilities.path_of_DB,BaseUtilities.sheet_name,1,3));
    }

    public void asserting_ProductId() throws IOException {
        String Product_IDAppeared  = localdriver.findElement(GetProductID_onSearch).getText();
        Assert.assertEquals(Product_IDAppeared,BaseUtilities.getCellvalue(BaseUtilities.path_of_DB,BaseUtilities.sheet_name,1,2));
    }


    public void Click_SearchButton()
    {
        localdriver.findElement(Search_Button).click();
        if(localdriver.findElement(Search_Button).isEnabled())
        {
            Assert.assertTrue(true,"Search Button is Enabled");
        }else {
            Assert.assertTrue(false,"Search Button is not Disabled");
        }

    }

    public String getProductFound()
    {

        return localdriver.findElement(GetProductName_onSearch).getText();
    }

    public void select_viewAll()
    {
        localdriver.findElement(View_All_Button).click();
        if(localdriver.findElement(View_All_Button).isEnabled())
        {
            Assert.assertTrue(true,"View All Button is Enabled");
        }else {
            Assert.assertTrue(false,"View All Button is not Disabled");
        }


    }


    public void select_viewBill()
    {

        localdriver.findElement(View_Bills_Button).click();
    }

    public void select_GenerateBill()
    {

        localdriver.findElement(Generate_Bills_Button).click();
    }

    public void selectYear()
    {

        WebElement Dropdown_year_list =  localdriver.findElement(Year_Dropdown);
        Select year_dropdown = new Select(Dropdown_year_list);
        year_dropdown.selectByIndex(0);
    }

    public void selectMonth()
    {
        WebElement Dropdown_month_list = localdriver.findElement(Month_Dropdown);
        Select month_dropdown = new Select(Dropdown_month_list);
        month_dropdown.selectByIndex(2);

    }

    public void select_Filter_projects(int i)
    {
        WebElement Dropdown_month_list = localdriver.findElement(Filter_projects_Dropdown);
        Select filter_dropdown = new Select(Dropdown_month_list);
        filter_dropdown.selectByIndex(i);
    }

    public void assert_all__bills()
    {


        List<WebElement>  ungenerated_bills =  localdriver.findElements(un_generated_Bills_list);

        System.out.println(ungenerated_bills.size() + "Product Found" );
        if(ungenerated_bills.size()>0)
        {
            Assert.assertTrue(true,"Products with all Bills Are Visible");
        }
        else {
            Assert.assertTrue(false,"NO Products Found But in website Products are there");
        }


    }


    public void assert_un_generated_bills()
    {
        boolean flag =true;
        List<WebElement>   ungenerated_bills =  localdriver.findElements(un_generated_Bills_list);
        System.out.println(ungenerated_bills.size() + "Product Found with Ungenerated bills" );
        for(int i=1;i<=ungenerated_bills.size();i++)
        {
            String path ="(//app-monthly-expense[1]//button[1]/span[1])" +"["+i+"]";
            By all_generated_un_generated_list =  By.xpath(path);
            String getText = localdriver.findElement(all_generated_un_generated_list).getText();
            if(!getText.equals("Generate Bills"))
            {
                flag =false;
            }
        }

        if(ungenerated_bills.size()>0 && flag == true)
        {
            Assert.assertTrue(true,"Products with Un generated Bills Are Visible");
        }
        else {
            Assert.assertTrue(false,"NO Products Found But in website Products are there");
        }


    }

    public void assert_generated_bills()
    {

        boolean flag =true;
        List<WebElement>  generated_bills = localdriver.findElements(generated_Bills_list);
        System.out.println(generated_bills.size() + "Product Found with generated bills" );
        for(int i=1;i<=generated_bills.size();i++)
        {
            String path ="(//app-monthly-expense[1]//button[1]/span[1])" +"["+i+"]";
            By all_generated_un_generated_list =  By.xpath(path);
            String getText = localdriver.findElement(all_generated_un_generated_list).getText();
            if(!getText.equals("View Bills"))
            {
                flag =false;
            }
        }
        if(generated_bills.size()>0 && flag== true)
        {


            Assert.assertTrue(true,"Products with  generated Bills Are Visible");
        }
        else {
            Assert.assertTrue(false,"NO Products Found But in website Products are there");
        }


    }

    public void clear_SearchField()
    {
        localdriver.findElement(Search_Bar).clear();
    }

    public void assert_months()
    {
        WebElement Dropdown_month_list = localdriver.findElement(Month_Dropdown);
        Select month_dropdown = new Select(Dropdown_month_list);

        for(int i=0;i<month_dropdown.getOptions().size();i++)
        {
            month_dropdown.selectByIndex(i);
        }

        if(Dropdown_month_list.isEnabled() && Dropdown_month_list.isDisplayed() && month_dropdown.getOptions().size()==12)
        {
            System.out.println("Month Dropdown is enabled and clickable");
            Assert.assertTrue(true,"Month dropdown is working");
        }else {
            Assert.assertTrue(false,"Month dropdown in not working");
        }

    }
    public void assert_year()
    {


        WebElement Dropdown_year_list =  localdriver.findElement(Year_Dropdown);
        Select year_dropdown = new Select(Dropdown_year_list);

        for(int i=0;i<year_dropdown.getOptions().size();i++)
        {
            year_dropdown.selectByIndex(i);
        }

        if(Dropdown_year_list.isEnabled() && Dropdown_year_list.isDisplayed())
        {
            System.out.println("Year Dropdown is Enabled and Clickable");
            Assert.assertTrue(true);
        }
        else {
            Assert.assertTrue(false);
        }
    }

    public  void Logout()
    {
        localdriver.findElement(Logout_dropdown).click();
        localdriver.findElement(Logout_Button).click();
    }

}