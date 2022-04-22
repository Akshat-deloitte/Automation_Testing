package java.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SendToTeamPage {

    WebDriver localdriver;
    SendToTeamPage(WebDriver remotedriver)
    {
        this.localdriver = remotedriver;
        PageFactory.initElements(remotedriver,this);
    }
    By Team_Send_To_Teams_Option = By.xpath("/html/body/app-root/app-dashboard/app-header/div/div[2]/div[2]");
    By Team_Month_Dropdown = By.xpath("/html/body/app-root/app-dashboard/app-t-dashboard/div/div[2]/div[1]/div[2]/selec");
    By Team_Year_Dropdown = By.xpath("/html/body/app-root/app-dashboard/app-t-dashboard/div/div[2]/div[2]/div[2]/select");
    By Team_Unverified_bills_Dropdown = By.xpath("/html/body/app-root/app-dashboard/app-t-dashboard/div/div[2]/div[3]/div[2]/select");
    By Team_Submit_Button = By.xpath("/html/body/app-root/app-dashboard/app-t-dashboard/div/div[2]/button");
    By Team_Ungenerated_Bill_Name = By.className("title-left");
    By Team_Ungenerated_Bill_id = By.xpath("/html/body/app-root/app-dashboard/app-t-dashboard/div/app-t-details/div/div[1]/div[1]/div[1]/div[2]");
    By Team_Ungenerated_Project_id = By.xpath("/html/body/app-root/app-dashboard/app-t-dashboard/div/app-t-details/div/div[1]/div[1]/div[1]/div[3]");
    By Team_revert_Monthly_billing_Expense = By.xpath("/html/body/app-root/app-dashboard/app-t-dashboard/div/div[1]/p/a");
    By Team_ungenerated_billmonth = By.xpath("/html/body/app-root/app-dashboard/app-t-dashboard/div/app-t-details/div/div[1]/div[1]/div[2]/div");
    By Team_Send_for_Approval = By.className("ant-btn ant-btn-primary ant-btn-block");
    By Team_invoice_number = By.xpath("/html/body/app-root/app-dashboard/app-t-dashboard/div/app-t-details/div/div[1]/div[2]/div[1]/div[1]/p[1]");
    By Team_issued_date = By.xpath("/html/body/app-root/app-dashboard/app-t-dashboard/div/app-t-details/div/div[1]/div[2]/div[1]/div[1]/p[2]");
    By Team_Due_Date = By.xpath("/html/body/app-root/app-dashboard/app-t-dashboard/div/app-t-details/div/div[1]/div[2]/div[1]/div[1]/p[3]");
    By Team_Teamlead_Name = By.xpath("/html/body/app-root/app-dashboard/app-t-dashboard/div/app-t-details/div/div[1]/div[2]/div[1]/div[2]/p[1]");
    By Team_Teamlead_Email = By.xpath("/html/body/app-root/app-dashboard/app-t-dashboard/div/app-t-details/div/div[1]/div[2]/div[1]/div[2]/p[3]");
    By Team_Approval_Status = By.xpath("/html/body/app-root/app-dashboard/app-t-dashboard/div/app-t-details/div/div[2]/h2[2]");
    By Team_TeamLeadsApproval = By.xpath("/html/body/app-root/app-dashboard/app-t-dashboard/div/app-t-details/div/div[2]/h1[1]");
    By Team_TeamLeadClientApproval = By.xpath("/html/body/app-root/app-dashboard/app-t-dashboard/div/app-t-details/div/div[2]/h1[2]");
    By Team_PaymentStatus = By.xpath("/html/body/app-root/app-dashboard/app-t-dashboard/div/app-t-details/div/div[2]/h1[3]");
    By Team_Item_Name = By.xpath("/html/body/app-root/app-dashboard/app-t-dashboard/div/app-t-details/div/div[1]/div[2]/div[2]/p[1]");
    By Team_Hours = By.xpath("/html/body/app-root/app-dashboard/app-t-dashboard/div/app-t-details/div/div[1]/div[2]/div[2]/p[2]");
    By Team_Rate_per_Hour = By.xpath("/html/body/app-root/app-dashboard/app-t-dashboard/div/app-t-details/div/div[1]/div[2]/div[2]/p[3]");
    By Team_Tax = By.xpath("/html/body/app-root/app-dashboard/app-t-dashboard/div/app-t-details/div/div[1]/div[2]/div[2]/p[4]");
    By Team_LineTotal = By.xpath("/html/body/app-root/app-dashboard/app-t-dashboard/div/app-t-details/div/div[1]/div[2]/div[2]/p[5]");
    By Team_LineTotalAmount = By.xpath("/html/body/app-root/app-dashboard/app-t-dashboard/div/app-t-details/div/div[1]/div[2]/div[3]/p[4]");
    By Team_TotalAmountamount = By.xpath("/html/body/app-root/app-dashboard/app-t-dashboard/div/app-t-details/div/div[1]/div[2]/div[4]/div[2]");
    By Team_Total_Amount = By.xpath("/html/body/app-root/app-dashboard/app-t-dashboard/div/app-t-details/div/div[1]/div[2]/div[4]/div[1]");

    public void click_Send_to_Team()
    {
        localdriver.findElement(Team_Send_To_Teams_Option).click();
    }

    public void assert_click_send_to_team()
    {
        if(localdriver.findElement(Team_Send_To_Teams_Option).isEnabled())
        {
            Assert.assertTrue(true);
        }else {
            Assert.assertTrue(false);
        }
    }

    public void click_Team_Month_Dropdown()
    {
        localdriver.findElement(Team_Month_Dropdown).click();
    }

    public void select_click_Team_Month_Dropdown(int i)
    {
        WebElement Dropdown_Team_Month =  localdriver.findElement(Team_Month_Dropdown);
        Select month_dropdown = new Select(Dropdown_Team_Month);
        month_dropdown.selectByIndex(i);
    }

    public void click_Team_Year_Dropdown()
    {
        localdriver.findElement(Team_Month_Dropdown).click();
    }

    public void select_click_Team_Year_Dropdown()
    {
        WebElement Dropdown_Team_Year =  localdriver.findElement(Team_Year_Dropdown);
        Select year_dropdown = new Select(Dropdown_Team_Year);
        year_dropdown.selectByIndex(0);
    }

    public void click_Team_Unverified_bills_Dropdown()
    {
        localdriver.findElement(Team_Unverified_bills_Dropdown).click();
    }

    public void select_Team_Unverified_bills_Dropdown()
    {
        WebElement Dropdown_Team_Unverified_bill =  localdriver.findElement(Team_Unverified_bills_Dropdown);
        Select unverified_bill__dropdown = new Select(Dropdown_Team_Unverified_bill);
        unverified_bill__dropdown.selectByIndex(0);
    }

    public void assert_click_Team_Submit_Button()
    {
        if(localdriver.findElement(Team_Submit_Button).isEnabled())
        {
            Assert.assertTrue(true);
        }else {
            Assert.assertTrue(false);
        }
    }

    public void Team_Submit_Button()
    {
        localdriver.findElement(Team_Submit_Button).click();
    }

    public void assert_click_Team_Send_for_Approval()
    {
        if(localdriver.findElement(Team_Submit_Button).isEnabled())
        {
            Assert.assertTrue(true);
        }else {
            Assert.assertTrue(false);
        }
    }

    public void Team_Send_for_Approval()
    {
        localdriver.findElement(Team_Send_for_Approval).click();
    }
}
