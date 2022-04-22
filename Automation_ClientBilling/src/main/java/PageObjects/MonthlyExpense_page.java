package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import java.util.List;

public class MonthlyExpense_page {

    WebDriver localdriver;
    MonthlyExpense_page(WebDriver remotedriver)
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
    By un_generated_Bills_list =  By.xpath("//app-monthly-expense[1]//button[1]/span[1]");
    By generated_Bills_list =  By.xpath("//app-monthly-expense[1]//button[1]/span[1]");
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


    public void Type_onSearchBar()
    {
        localdriver.findElement(Search_Bar).sendKeys("pass here from excel");
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
        if(localdriver.findElement(View_Bills_Button).isEnabled())
        {
            Assert.assertTrue(true,"View bill Button is Enabled");
        }else {
            Assert.assertTrue(false,"View bill Button is not Disabled");
        }

    }

    public void select_GenerateBill()
    {
        localdriver.findElement(Generate_Bills_Button).click();
        if(localdriver.findElement(Generate_Bills_Button).isEnabled())
        {
            Assert.assertTrue(true,"Generate bill Button is Enabled");
        }else {
            Assert.assertTrue(false,"Generate bill Button is not Disabled");
        }

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



    public int assert_un_generated_bills()
    {


        List<WebElement> ungenerated_bills = null;
        ungenerated_bills = (List<WebElement>) localdriver.findElement(un_generated_Bills_list);
        if(ungenerated_bills.size()>0)
        {
            Assert.assertTrue(true,"Products with Un generated Bills Are Visible");
        }
        else {
            Assert.assertTrue(false,"NO Products Found But in website Products are there");
        }

        return ungenerated_bills.size();
    }

    public int assert_generated_bills()
    {

        List<WebElement> generated_bills = null;
        generated_bills = (List<WebElement>) localdriver.findElement(generated_Bills_list);
        if(generated_bills.size()>0)
        {
            Assert.assertTrue(true,"Products with  generated Bills Are Visible");
        }
        else {
            Assert.assertTrue(false,"NO Products Found But in website Products are there");
        }

        return generated_bills.size();
    }








}
