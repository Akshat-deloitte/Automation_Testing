package PageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;




public class SendToClientPage {


    WebDriver local_driver;
    public SendToClientPage(WebDriver remote_driver)
    {
        this.local_driver = remote_driver;
        PageFactory.initElements(remote_driver,this);
    }

    By send_to_client_button = By.xpath("//*[text()=' SEND TO CLIENT ']");
    By month_list = By.xpath("/html/body/app-root/app-dashboard/app-c-dashboard/div/div[2]/div[1]/div[2]/select");
    By year_list = By.xpath("/html/body/app-root/app-dashboard/app-c-dashboard/div/div[2]/div[2]/div[2]/select");
    By bill_list = By.xpath("/html/body/app-root/app-dashboard/app-c-dashboard/div/div[2]/div[3]/div[2]/select");
    By submit_button = By.xpath("/html/body/app-root/app-dashboard/app-c-dashboard/div/div[2]/button");
    By send_for_approval_button = By.xpath("//*[text()='SEND FOR APROVAL']");
    By id_bill = By.xpath("/html/body/app-root/app-dashboard/app-c-dashboard/div/app-c-details/div/div[1]/div[1]/div[1]/div[2]");
    By id_project = By.xpath("/html/body/app-root/app-dashboard/app-c-dashboard/div/app-c-details/div/div[1]/div[1]/div[1]/div[3]");
    By description_bill = By.xpath("/html/body/app-root/app-dashboard/app-c-dashboard/div/app-c-details/div/div[1]/div[1]/div[2]/h2");
    By name_bill = By.xpath("/html/body/app-root/app-dashboard/app-c-dashboard/div/app-c-details/div/div[1]/div[1]/div[1]/div[1]");
    By invoice_no = By.xpath("/html/body/app-root/app-dashboard/app-c-dashboard/div/app-c-details/div/div[1]/div[2]/div[1]/div[1]/p[1]/span");
    By issue_date = By.xpath("/html/body/app-root/app-dashboard/app-c-dashboard/div/app-c-details/div/div[1]/div[2]/div[1]/div[1]/p[2]/span");
    By due_date = By.xpath("/html/body/app-root/app-dashboard/app-c-dashboard/div/app-c-details/div/div[1]/div[2]/div[1]/div[1]/p[3]/span");
    By client_name = By.xpath("/html/body/app-root/app-dashboard/app-c-dashboard/div/app-c-details/div/div[1]/div[2]/div[1]/div[2]/p[1]/span");
    By client_email = By.xpath("/html/body/app-root/app-dashboard/app-c-dashboard/div/app-c-details/div/div[1]/div[2]/div[1]/div[2]/p[2]/span");
    By client_contact = By.xpath("/html/body/app-root/app-dashboard/app-c-dashboard/div/app-c-details/div/div[1]/div[2]/div[1]/div[2]/p[3]/span");
    By name_on_bill = By.xpath("/html/body/app-root/app-dashboard/app-c-dashboard/div/app-c-details/div/div[1]/div[2]/div[3]/div/div[1]/p");
    By hour = By.xpath("/html/body/app-root/app-dashboard/app-c-dashboard/div/app-c-details/div/div[1]/div[2]/div[3]/p[1]");
    By rate = By.xpath("/html/body/app-root/app-dashboard/app-c-dashboard/div/app-c-details/div/div[1]/div[2]/div[3]/p[2]");
    By amount = By.xpath("/html/body/app-root/app-dashboard/app-c-dashboard/div/app-c-details/div/div[1]/div[2]/div[3]/p[4]");

    // cases to check if buttons are clickable
    public void client_button() { Assert.assertTrue(local_driver.findElement(send_to_client_button).isEnabled()); }

    public void month_button() {Assert.assertTrue(local_driver.findElement(month_list).isEnabled());}

    public void year_button() {
        Assert.assertTrue(local_driver.findElement(year_list).isEnabled());
    }

    public void bill_button() {
        Assert.assertTrue(local_driver.findElement(bill_list).isEnabled());
    }

    public void submit_button() {
        Assert.assertTrue(local_driver.findElement(submit_button).isEnabled());
    }

    public void approval_button() {
        Assert.assertTrue(local_driver.findElement(send_for_approval_button).isEnabled());
    }

    // cases to check if data is visible
    public void bill_id() { Assert.assertTrue(local_driver.findElement(id_bill).isDisplayed()); }
    public void project_id() { Assert.assertTrue(local_driver.findElement(id_project).isDisplayed()); }
    public void bill_name() { Assert.assertTrue(local_driver.findElement(name_bill).isDisplayed()); }
    public void bill_description() { Assert.assertTrue(local_driver.findElement(description_bill).isDisplayed()); }
    public void invoice() { Assert.assertTrue(local_driver.findElement(invoice_no).isDisplayed()); }
    public void date_issued() { Assert.assertTrue(local_driver.findElement(issue_date).isDisplayed()); }
    public void due_date() { Assert.assertTrue(local_driver.findElement(due_date).isDisplayed()); }
    public void contact_client() { Assert.assertTrue(local_driver.findElement(client_contact).isDisplayed()); }
    public void email_client() { Assert.assertTrue(local_driver.findElement(client_email).isDisplayed()); }
    public void name_client() { Assert.assertTrue(local_driver.findElement(client_name).isDisplayed()); }
    public void name_product() { Assert.assertTrue(local_driver.findElement(name_on_bill).isDisplayed()); }
    public void hours_info() { Assert.assertTrue(local_driver.findElement(hour).isDisplayed()); }
    public void rate_info() { Assert.assertTrue(local_driver.findElement(rate).isDisplayed()); }
    public void total_amount() { Assert.assertTrue(local_driver.findElement(amount).isDisplayed()); }

    // choose various input
    public void choose_month(int i)
    {
        WebElement Dropdown_month_list =  local_driver.findElement(month_list);
        Select month_dropdown = new Select(Dropdown_month_list);
        month_dropdown.selectByIndex(i);
    }

    public void choose_year(int i) {
        WebElement Dropdown_year_list = local_driver.findElement(year_list);
        Select month_dropdown = new Select(Dropdown_year_list);
        month_dropdown.selectByIndex(i);
    }

    public void choose_bill(int i) {
        WebElement Dropdown_bill_list = local_driver.findElement(bill_list);
        Select month_dropdown = new Select(Dropdown_bill_list);
        month_dropdown.selectByIndex(i);
    }

    // click button
    public void click_client() { local_driver.findElement(send_to_client_button).click(); }

    public void click_month() { local_driver.findElement(month_list).click();}

    public void click_year() { local_driver.findElement(year_list).click();}

    public void click_bill() { local_driver.findElement(bill_list).click();}

    public void click_submit() { local_driver.findElement(submit_button).click();}

    public void click_approval() { local_driver.findElement(send_for_approval_button).click();}

    // validate information
    public void validate_amount() {
        int x = Integer.parseInt(local_driver.findElement(hour).getText());
        int y = Integer.parseInt(local_driver.findElement(rate).getText());
        int z = 18;
        int amt = x*y + ((x*y*z)/100);
        int amt1 = Integer.parseInt(local_driver.findElement(amount).getText());
        Assert.assertEquals(amt1, amt);
    }

    public void validate_id() {
        int x = Integer.parseInt(local_driver.findElement(id_project).getText());
        int y = Integer.parseInt(local_driver.findElement(id_bill).getText());
        Assert.assertEquals(x,y);
    }

}

