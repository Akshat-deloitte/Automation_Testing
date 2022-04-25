package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SendToTeamPage {

    WebDriver localdriver;

    public SendToTeamPage(WebDriver remotedriver) {
        this.localdriver = remotedriver;
        PageFactory.initElements(remotedriver, this);
    }

    By send_to_team_button = By.xpath("//*[text()=' SEND TO TEAM ']");
    By choose_month = By.xpath("/html/body/app-root/app-dashboard/app-t-dashboard/div/div[2]/div[1]/div[2]/select");
    By choose_year = By.xpath("/html/body/app-root/app-dashboard/app-t-dashboard/div/div[2]/div[2]/div[2]/select");
    By choose_unverifiedBill = By.xpath("/html/body/app-root/app-dashboard/app-t-dashboard/div/div[2]/div[3]/div[2]/select");
    By revert = By.xpath("//*[text()='Monthly Billing Details']");
    By verifyrevert = By.className("address");
    By submit_button = By.xpath("//button[contains(text(),'SUBMIT')]");
    By billname = By.xpath("/html/body/app-root/app-dashboard/app-t-dashboard/div/app-t-details/div/div[1]/div[1]/div[1]/div[1]");
    By billnumber = By.xpath("/html/body/app-root/app-dashboard/app-t-dashboard/div/app-t-details/div/div[1]/div[1]/div[1]/div[2]");
    By teamLeadApprovalStatus = By.xpath("/html/body/app-root/app-dashboard/app-t-dashboard/div/app-t-details/div/div[2]/h1[1]");
    By clientApprovalStatus = By.xpath("/html/body/app-root/app-dashboard/app-t-dashboard/div/app-t-details/div/div[2]/h1[2]");
    By paymentStatus = By.xpath("/html/body/app-root/app-dashboard/app-t-dashboard/div/app-t-details/div/div[2]/h1[3]");
    By projectid = By.xpath("/html/body/app-root/app-dashboard/app-t-dashboard/div/app-t-details/div/div[1]/div[1]/div[1]/div[3]");
    By billmonth = By.xpath("/html/body/app-root/app-dashboard/app-t-dashboard/div/app-t-details/div/div[1]/div[1]/div[2]/div");
    By invoiceno = By.xpath("/html/body/app-root/app-dashboard/app-t-dashboard/div/app-t-details/div/div[1]/div[2]/div[1]/div[1]/p[1]");
    By issueddate = By.xpath("/html/body/app-root/app-dashboard/app-t-dashboard/div/app-t-details/div/div[1]/div[2]/div[1]/div[1]/p[2]");
    By duedate = By.xpath("/html/body/app-root/app-dashboard/app-t-dashboard/div/app-t-details/div/div[1]/div[2]/div[1]/div[1]/p[3]");
    By teamleadName = By.xpath("/html/body/app-root/app-dashboard/app-t-dashboard/div/app-t-details/div/div[1]/div[2]/div[1]/div[2]/p[1]");
    By teamleadEmail = By.xpath("/html/body/app-root/app-dashboard/app-t-dashboard/div/app-t-details/div/div[1]/div[2]/div[1]/div[2]/p[2]");
    By teamleadContact = By.xpath("/html/body/app-root/app-dashboard/app-t-dashboard/div/app-t-details/div/div[1]/div[2]/div[1]/div[2]/p[3]");
    By linetotal = By.xpath("/html/body/app-root/app-dashboard/app-t-dashboard/div/app-t-details/div/div[1]/div[2]/div[3]/p[4]");
    By totalamount = By.xpath("/html/body/app-root/app-dashboard/app-t-dashboard/div/app-t-details/div/div[1]/div[2]/div[4]/div[2]");
    By sendApproval_button = By.xpath("/html/body/app-root/app-dashboard/app-t-dashboard/div/app-t-details/div/div[2]/button");
    By hours = By.xpath("/html/body/app-root/app-dashboard/app-t-dashboard/div/app-t-details/div/div[1]/div[2]/div[3]/p[1]");
    By rate_hr = By.xpath("/html/body/app-root/app-dashboard/app-t-dashboard/div/app-t-details/div/div[1]/div[2]/div[3]/p[2]");
    By tax = By.xpath("/html/body/app-root/app-dashboard/app-t-dashboard/div/app-t-details/div/div[1]/div[2]/div[3]/p[3]");


    public void team_button() {
        Assert.assertTrue(localdriver.findElement(send_to_team_button).isEnabled());
    }

    public void click_team_button(){localdriver.findElement(send_to_team_button).click();}

    public void revert_back(){localdriver.findElement(revert).click();}

    public void verify_revert(){localdriver.findElement(verifyrevert);}

    public void click_month(){localdriver.findElement(choose_month).click();}

    public void choose_months(int i)
    {
        WebElement Dropdown_month_list =  localdriver.findElement(choose_month);
        Select month_dropdown = new Select(Dropdown_month_list);
        month_dropdown.selectByIndex(i);
    }

    public void click_year(){localdriver.findElement(choose_year).click();}

    public void choose_years(int i)
    {
        WebElement Dropdown_year_list =  localdriver.findElement(choose_year);
        Select year_dropdown = new Select(Dropdown_year_list);
        year_dropdown.selectByIndex(i);
    }

    public void click_unverified_bill(){localdriver.findElement(choose_unverifiedBill).click();}

    public void choose_unverifiedBills(int i)
    {
        WebElement Dropdown_bill_list =  localdriver.findElement(choose_unverifiedBill);
        Select unverifiedbill_dropdown = new Select(Dropdown_bill_list);
        unverifiedbill_dropdown.selectByIndex(i);
    }

    public void SUBMIT_button() {
        Assert.assertTrue(localdriver.findElement(submit_button).isEnabled());
    }

    public void click_submit_button(){localdriver.findElement(submit_button).click();}

    public void bill_name(){
        if(localdriver.findElement(billname).isDisplayed())
        {
            System.out.println("The bill name is present");
        }
        else
        {
            System.out.println("the bill name is not present");
        }
    }

    public void bill_id()
    {
        if (localdriver.findElement(billnumber).isDisplayed()) {
            System.out.println("The bill id is present");
        } else {
            System.out.println("the bill id is not present");
        }
    }

    public void team_lead_status()
    {
        if (localdriver.findElement(teamLeadApprovalStatus).isDisplayed()) {
            System.out.println("The Team Lead Status is present");
        } else {
            System.out.println("The team Lead Status is not present");
        }
    }

    public void team_client_status()
    {
        if (localdriver.findElement(clientApprovalStatus).isDisplayed()) {
            System.out.println("The Client Status is present");
        } else {
            System.out.println("The Client Status is not present");
        }
    }
    public void team_payment_status()
    {
        if (localdriver.findElement(paymentStatus).isDisplayed()) {
            System.out.println("The Payment Status is present");
        } else {
            System.out.println("The Payment Status is not present");
        }
    }

    public void project_id()
    {
        if (localdriver.findElement(projectid).isDisplayed()) {
            System.out.println("The Project id is present");
        } else {
            System.out.println("The Project id is not present");
        }
    }

    public void bill_month()
    {
        if (localdriver.findElement(billmonth).isDisplayed()) {
            System.out.println("The bill month is present");
        } else {
            System.out.println("The bill month is not present");
        }
    }

    public void invoice_number()
    {
        if (localdriver.findElement(invoiceno).isDisplayed()) {
            System.out.println("The invoice number is present");
        } else {
            System.out.println("The invoice number is not present");
        }
    }

    public void issued_date()
    {
        if (localdriver.findElement(issueddate).isDisplayed()) {
            System.out.println("The issued date is present");
        } else {
            System.out.println("The issued date is not present");
        }
    }

    public void due_date()
    {
        if (localdriver.findElement(duedate).isDisplayed()) {
            System.out.println("The due date is present");
        } else {
            System.out.println("The due date is not present");
        }
    }

    public void teamlead_name()
    {
        if (localdriver.findElement(teamleadName).isDisplayed()) {
            System.out.println("The due date is present");
        } else {
            System.out.println("The due date is not present");
        }
    }

    public void teamlead_email()
    {
        if (localdriver.findElement(teamleadEmail).isDisplayed()) {
            System.out.println("The teamlead email is present");
        } else {
            System.out.println("The teamlead email is not present");
        }
    }

    public void teamlead_contactno()
    {
        if (localdriver.findElement(teamleadContact).isDisplayed()) {
            System.out.println("The teamlead contact is present");
        } else {
            System.out.println("The teamlead contact is not present");
        }
    }

    public void check_amount()
    {
        String price= localdriver.findElement(linetotal).getText();
        String newPrice = price.replace("INR"," ").replace("","");
        String tprice= localdriver.findElement(totalamount).getText();
        String tnewPrice = tprice.replace("INR"," ").replace("","");
        if(newPrice == tnewPrice)
        {
            System.out.println("The line total and the total amount are equal");
        }
        else
        {
            System.out.println("The line total and the total amount are not equal");
        }

    }

    public void Click_Sendapproval_Button()
    {
        localdriver.findElement(sendApproval_button).click();
        if(localdriver.findElement(sendApproval_button).isEnabled())
        {
            System.out.println("Send Approval is Enabled");
        }else {
            System.out.println("Send Approval is Disabled");
        }

    }

    public void Calculate_total_amount(){
        String taxx= localdriver.findElement(tax).getText();
        String modifiedtax = taxx.replace("%"," ").replace("","");
        System.out.println(modifiedtax);
        int newtax = Integer.parseInt((modifiedtax).trim());
        int hour = Integer.parseInt(localdriver.findElement(hours).getText());
        System.out.println(hour);
        int rateper_hour = Integer.parseInt(localdriver.findElement(rate_hr).getText());
        System.out.println(rateper_hour);
        int total_amount = hour*rateper_hour*newtax;
        System.out.println(total_amount);
        String tprice= localdriver.findElement(linetotal).getText();
        String tnewPrice = tprice.replace("INR"," ").replace("","");
        int newtnewprice = Integer.parseInt((tnewPrice).trim());
        System.out.println(newtnewprice);
        if(total_amount == newtnewprice)
        {
            System.out.println("The system generated value is equal to the actual calculated value");
        }
        else
            System.out.println("The system generated value is not equal to the actual calculated value");
    }
}
